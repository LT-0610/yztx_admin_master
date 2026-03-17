package com.ruoyi.web.controller.system;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.properties.BaiduVoiceProperties;
import com.ruoyi.system.domain.SysMedicine;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/system/medicineSearch")
public class SysMedicineController extends BaseController {
    /**
     * 通过药名查询药品信息
     */
    @Autowired
    private BaiduVoiceProperties baiduVoiceProperties;

    @PostMapping("/meidicineByname")
    public AjaxResult medicineSearchByname(@RequestBody SysMedicine sysMedicine) throws Exception {
        // 创建 httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建请求对象
        HttpPost httpPost = new HttpPost(RuoYiConfig.getMedicineUrl());
        //NameValuePair 是 Apache HttpClient 库中的一个接口，用于表示 HTTP 请求或响应中的名称-值
        //BasicNameValuePair 是 NameValuePair 接口的一个实现类
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("key", RuoYiConfig.getMedicineApikey()));
        formParams.add(new BasicNameValuePair("word", sysMedicine.getWord()));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, StandardCharsets.UTF_8);
        // 设置请求头
        entity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(entity);
        // 发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 解析返回结果
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            HttpEntity entity1 = response.getEntity();
            String responseBody = EntityUtils.toString(entity1, StandardCharsets.UTF_8);
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONObject result = jsonResponse.getJSONObject("result");
            JSONArray list = result.getJSONArray("list");
            JSONObject item = list.getJSONObject(0);
            String title = item.getString("title");
            String content = item.getString("content");
            String[] sections = content.split("<br />");
            //药的成分
            String ingredients = sections[0].replaceAll("【成分】 ", "").trim();
            //药的适应症
            String indicationsDosage = sections[1].replaceAll("【适应症】 ", "").trim();
            //药的用量用法
            String precautions = sections[2].replaceAll("【用量用法】 ", "").trim();
            //药的注意事项
            String specifications = sections[3].replaceAll("【注意事项】 ", "").trim();
            Map<String, String> map = new HashMap<>();
            map.put("成分", ingredients);
            map.put("适应症", indicationsDosage);
            map.put("用量用法", precautions);
            map.put("注意事项", specifications);
            response.close();
            httpClient.close();
            return success(map);
        } else {
            response.close();
            httpClient.close();
            return AjaxResult.error(statusCode, "药品查询返回结果失败");
        }
    }

    /**
     * 药品查询(药品信息转语音并生成语音文件置于ruoyi-admin/src/main/resources/test.mp3)
     * 下一次文件会被覆盖
     */
    @PostMapping("/medicineToVoice")
    public AjaxResult medicineToVoice(@RequestBody SysMedicine sysMedicine) throws Exception {
        // 创建 httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建请求对象
        HttpPost httpPost = new HttpPost(RuoYiConfig.getMedicineUrl());

        //NameValuePair 是 Apache HttpClient 库中的一个接口，用于表示 HTTP 请求或响应中的名称-值
        //BasicNameValuePair 是 NameValuePair 接口的一个实现类
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("key", RuoYiConfig.getMedicineApikey()));
        formParams.add(new BasicNameValuePair("word", sysMedicine.getWord()));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, StandardCharsets.UTF_8);

        // 设置请求头
        entity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(entity);

        // 发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

        // 解析返回结果
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            HttpEntity entity1 = response.getEntity();
            String responseBody = EntityUtils.toString(entity1, StandardCharsets.UTF_8);
            System.out.println("响应数据为：" + responseBody);
            System.out.println();

            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONObject result = jsonResponse.getJSONObject("result");
            JSONArray list = result.getJSONArray("list");
            JSONObject item = list.getJSONObject(0);
            String title = item.getString("title");
            String content = item.getString("content");
            String[] sections = content.split("<br />");
            //药的成分
//            String ingredients = sections[0].replaceAll("【成分】 ", "").trim();
            //药的适应症
            String indicationsDosage = sections[1].replaceAll("【适应症】 ", "").trim();
            //药的用量用法
            String precautions = sections[2].replaceAll("【用量用法】 ", "").trim();
            //药的注意事项
            String specifications = sections[3].replaceAll("【注意事项】 ", "").trim();
            //补上句号
            if (indicationsDosage.lastIndexOf("。") == -1) {
                indicationsDosage += "。";
            }
            if (precautions.lastIndexOf("。") == -1) {
                precautions += "。";
            }
            if (specifications.lastIndexOf("。") == -1) {
                specifications += "。";
            }

            StringBuilder sc = new StringBuilder();
            String voice = sc.append(title + "适用于:" + indicationsDosage
                    + "用量用法为:" + precautions + specifications + "用药时请遵循医嘱或在医生的指导下使用！").toString();
            synthesis(voice, "ruoyi-admin/src/main/resources/test.mp3");
            response.close();
            httpClient.close();
            return success("药品查询返回结果成功");
        }
        else{
            response.close();
            httpClient.close();
            return AjaxResult.error(statusCode, "药品查询返回结果失败");
        }
    }

    /**
     * 商品条码信息查询 - 药品条码查询 - 条形码查询 - API接口
     * 通过条形码获取到药品名字并返回map集合
     * 例
     * {medcineName=大宝SOD蜜青花香型90ml+3支大宝SOD倍润手霜}
     */
    @GetMapping("/{medicinecode}")
    public AjaxResult returnMedicineName(@PathVariable("medicinecode") String medicinecode) {
        String host = "https://codequery.market.alicloudapi.com";// 【1】请求地址 支持http 和 https 及 WEBSOCKET
        String path = "/querybarcode";// 【2】后缀
        String appcode = "f4c61070b6474c218e492b0ed4dcaabc"; // 【3】开通服务后 买家中心-查看AppCode
        String code = medicinecode; // 【4】请求参数，详见文档描述
        String urlSend = host + path + "?code=" + code; // 【5】拼接请求链接
        try {
            URL url = new URL(urlSend);
            HttpURLConnection httpURLCon = (HttpURLConnection) url.openConnection();
            httpURLCon.setRequestProperty("Authorization", "APPCODE " + appcode);// 格式Authorization:APPCODE
            // (中间是英文空格)
            int httpCode = httpURLCon.getResponseCode();
            if (httpCode == 200) {
                String json = read(httpURLCon.getInputStream());
                System.out.print(json);
                JSONObject jsonResponse = new JSONObject(json);
                String medcineName = jsonResponse.getJSONObject("result").getString("goodsName");
                System.out.println(medcineName);
                medcineName = medcineName.replaceAll("\\s", "");
                Map<String, String> map = new HashMap<>();
                map.put("medcineName", medcineName);
                return success(map);
            } else {
                Map<String, List<String>> map = httpURLCon.getHeaderFields();
                String error = map.get("X-Ca-Error-Message").get(0);
                if (httpCode == 400 && error.equals("Invalid AppCode `not exists`")) {
                    System.out.println("AppCode错误 ");
                } else if (httpCode == 400 && error.equals("Invalid Url")) {
                    System.out.println("请求的 Method、Path 或者环境错误");
                } else if (httpCode == 400 && error.equals("Invalid Param Location")) {
                    System.out.println("参数错误");
                } else if (httpCode == 403 && error.equals("Unauthorized")) {
                    System.out.println("服务未被授权（或URL和Path不正确）");
                } else if (httpCode == 403 && error.equals("Quota Exhausted")) {
                    System.out.println("套餐包次数用完 ");
                } else if (httpCode == 403 && error.equals("Api Market Subscription quota exhausted")) {
                    System.out.println("套餐包次数用完，请续购套餐");
                } else {
                    System.out.println("参数名错误 或 其他错误");
                    System.out.println(error);
                }
                return error(error);
            }

        } catch (MalformedURLException e) {
            System.out.println("URL格式错误");
        } catch (UnknownHostException e) {
            System.out.println("URL地址错误");
        } catch (Exception e) {
            // 打开注释查看详细报错异常信息
            // e.printStackTrace();
        }
        return error();
    }

    /*
     * 读取返回结果
     */
    private static String read(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null) {
            line = new String(line.getBytes(), "utf-8");
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    /**
     * 文本转语音
     *
     * @param text     文本
     * @param filePath 文件路径
     */
    public void synthesis(String text, String filePath) {
        // 初始化一个AipSpeec
        AipSpeech client = new AipSpeech(baiduVoiceProperties.getAppid(), baiduVoiceProperties.getApikey(), baiduVoiceProperties.getSecretkey());

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 设置可选参数
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 语速，取值0-15，默认为5中语速
        options.put("spd", 4);
        // 音调，取值0-15，默认为5中语调
        options.put("pit", 4);
        // 音量，取值0-15，默认为5中音量
        options.put("vol", 4);
        // 发音人选择, 基础音库：0为女声，1为男声，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女
        options.put("per", "1");
        // 下载的文件格式, 3：mp3(default) 4： pcm-16k 5： pcm-8k 6. wav
        options.put("aue", "6");
        TtsResponse res = client.synthesis(text, "zh", 1, options);
        System.out.println("返回信息：" + res.getResult());//服务器返回的内容，合成成功时为null,失败时包含error_no等信息
        if (null == res.getResult()) {
            byte[] data = res.getData();//生成的音频数据
            if (data != null) {
                try {
                    Util.writeBytesToFileSystem(data, filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

