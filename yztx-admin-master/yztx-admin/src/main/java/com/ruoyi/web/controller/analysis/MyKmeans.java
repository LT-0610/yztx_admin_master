package com.ruoyi.web.controller.analysis;

import com.ruoyi.system.domain.SysCluster;
import com.ruoyi.system.mapper.SysClusterMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.ISysClusterService;
import com.ruoyi.system.service.impl.SysClusterServiceImpl;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class MyKmeans {
    private int k; //聚类数目
    private int m; //最大迭代次数
    private int dataLength; //数据集中数据的个数
    private ArrayList<double[]> data; //数据集
    private ArrayList<double[]> center; //聚类中心，结构与各数据点相同
    private ArrayList<ArrayList<double[]>> cluster; //聚类形成的簇
    private ArrayList<Double> SEE; //聚类中系统整体误差平方和
    private int temp; //用于记录最终迭代次数
    private ArrayList<double[]> center_copy; //记录初始聚类中心
    private int DIMENSION; //记录此次数据点的维度
    private static SysUserMapper sysUserMapper;
    private static SysClusterServiceImpl sysClusterServiceImpl;
    private List<List<List<Double>>> result = new ArrayList<>();//结果集
    @Autowired
    public void setSysUserMapper(SysUserMapper sysUserMapper){
        MyKmeans.sysUserMapper = sysUserMapper;
    }
    @Autowired
    public void setSysClusterServiceImpl (SysClusterServiceImpl sysClusterServiceImpl){
        MyKmeans.sysClusterServiceImpl  = sysClusterServiceImpl;
    }
    //空参构造函数
    public MyKmeans(){

    }
    //包含K值的构造函数
    public MyKmeans(int k){
        this.k = k;
    }
    public MyKmeans(int k,int m){
        this.k = k;
        this.m = m;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public ArrayList<double[]> getData() {
        return data;
    }

    public void setData(ArrayList<double[]> data) {
        this.data = data;
    }

    public ArrayList<double[]> getCenter() {
        return center;
    }

    public void setCenter(ArrayList<double[]> center) {
        this.center = center;
    }

    public ArrayList<ArrayList<double[]>> getCluster() {
        return cluster;
    }

    public void setCluster(ArrayList<ArrayList<double[]>> cluster) {
        this.cluster = cluster;
    }
    //初始化聚类，保证程序能够正常运行
    public void init(){
//        //默认情况下迭代次数为10，参考SPSS，暂未实装
//        m=10;
        //读取数据文件
        readData();
        dataLength = data.size();
        //判断K的取值，如果聚类数小于0则设为1类，如果大于数据集中元素个数，则设为dataLength个类
        if (k<=0){
            k=1;
        }
        if(k>dataLength){
            k=dataLength;
        }
        //初始化聚类中心，使用随机数实现
        initCenter();
        //初始化聚类结果，此时聚类结果为K个空的簇
        initCluster();
        //初始化聚类中的误差平方和
        initSEE();
    }
    //读取数据文件
    public void readData(){
        data = new ArrayList<>();
        List<Integer> userAges = sysUserMapper.selectUsersAge();
        System.out.println(userAges);
        // 转换 List<Integer> 到 ArrayList<double[]>
        for (Integer age : userAges) {
            double[] rowData = {age.doubleValue()}; // 将单个年龄值转换为 double[]
            data.add(rowData);
        }

        // 假设我们只关心年龄，所以维度是1
        DIMENSION = 1;
    }
    //显示聚类中心
    public void show_Cneter(ArrayList<double[]> center){
        for (int i  = 0; i < center.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(center.get(i)[j]);
                if (j!= DIMENSION-1)
                    System.out.print(",");
            }
            System.out.print("]\t");
        }
    }

    //初始化聚类中心，使用随机数生成
    public void initCenter(){
        center = new ArrayList<double[]>();
        for (int i = 0; i <k; i++) {
            Random random = new Random();
            double[] randoms_center;
            //随机指定数据点作为初始中心，可换用其他方法生成随机初始中心
            int index = random.nextInt(dataLength);
            randoms_center = data.get(index);
            center.add(randoms_center);
        }
        //保存初始聚类中心的副本
        //center_copy = center; 此种方法万万不可写
        center_copy = new ArrayList<>();
        center_copy.addAll(center);
        System.out.print("初始聚类中心是:");
        show_Cneter(center_copy);
        System.out.println();
        System.out.println();
    }


    //初始化聚类结果，此时聚类中包含K个孔的簇
    public void initCluster(){
        cluster = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            cluster.add(new ArrayList<>());
        }
    }

    //显示每个簇中的元素
    public void show_ClusterData(ArrayList<ArrayList<double[]>> cluster){
        List<List<Double>> result_list = new ArrayList<>();
        for (int i = 0; i < cluster.size(); i++) {
            System.out.print("类别"+(i+1)+"包含元素:");
            List<Double> list = new ArrayList<>();
            for (int j = 0; j < cluster.get(i).size(); j++) {
                System.out.print("[");
                for (int index = 0;index < DIMENSION; index++){
                    list.add(cluster.get(i).get(j)[index]);
                    System.out.print(cluster.get(i).get(j)[index]);
                    if (index!= DIMENSION-1)
                        System.out.print(",");
                }
                System.out.print("]\t");
            }
            System.out.println();
            result_list.add(list);//每一次的结果集
        }
        result.add(result_list);//总的结果集
    }

    //初始化聚类中的误差平方和
    public void initSEE(){
        SEE = new ArrayList<>();
    }

    /**
     * 计算两个点之间的距离
     * @param p1 第一个点
     * @param p2 第二个点
     * @return 两个点见的欧式距离
     */
    private double distance(double[] p1,double[] p2){
        double result;
        double temp_sum = 0.0;
        for (int i = 0; i < p1.length; i++) {
            temp_sum += (p1[i]-p2[i])*(p1[i]-p2[i]);
        }
        result = Math.sqrt(temp_sum);
        return result;
    }

    //找到当前数据距离聚类中心最小的类别位置
    private int minDistance(double[] disstance){
        double min_distance = disstance[0];
        int min_index = 0;
        for (int i = 1; i < disstance.length; i++) {
            if (disstance[i]<=min_distance){
                min_distance = disstance[i];
                min_index = i;
            }
        }
        return min_index;
    }
    //将当前数据元素放到聚类最近的簇中
    private void clusterSet(){
        double[] dis = new double[k];
        System.out.print("此时聚类中心：");
        show_Cneter(center);
        for (int i = 0; i < data.size(); i++) {
            System.out.println();
            for (int j = 0; j < k; j++) {
                dis[j] = distance(data.get(i),center.get(j));
            }
            System.out.print("第"+i+"个元素到中心的距离是:");
            for (int j = 0; j < dis.length; j++) {
                System.out.print(dis[j] + "\t");
            }
            int location = minDistance(dis);
            cluster.get(location).add(data.get(i));
        }
        System.out.println();
        //显示此时簇中包含的元素
        show_ClusterData(cluster);
        System.out.println();
    }

    /**
     * 求两点之间的误差平方
     * @param p1 第一个点
     * @param p2 第二个点
     * @return 两点之间的误差平方(距离)
     */
    private double errorSquare(double[] p1,double[] p2){
        double temp_sum = 0.0;
        for (int i = 0; i < p1.length; i++) {
            temp_sum += (p1[i]-p2[i])*(p1[i]-p2[i]);
        }
        return temp_sum;
    }

    //计算当前分类中所有簇中误差平方和
    private void countSEE(){
        double temp = 0;
        for (int i = 0; i < cluster.size(); i++) {
            for (int j = 0; j < cluster.get(i).size(); j++) {
                //计算当前簇中的所有数据到该簇聚类中心的距离
                temp += errorSquare(cluster.get(i).get(j),center.get(i));
            }
        }
        SEE.add(temp);
    }

    //设置新的聚类中心，依照以聚类好的各簇中数据求出新的聚类中心
    private void setNewCenter(){
//        System.out.println("新的聚类中心是：");
        for (int i = 0; i < cluster.size(); i++) {
            double[] temp_center = new double[DIMENSION];
            int n = cluster.get(i).size();
            if (n != 0){
                for (int j = 0; j < n; j++) {
                    for (int index = 0; index < DIMENSION; index++) {
                        temp_center[index] += cluster.get(i).get(j)[index];
                    }
                }
                for (int j = 0; j < DIMENSION; j++) {
                    temp_center[j] = temp_center[j]/n;
                }
                //将新的聚类中心放入动态数组
                center.set(i,temp_center);
            }
//            System.out.print("["+center.get(i)[0]+","+center.get(i)[1]+"]\t");
        }
        System.out.println();
    }

    /**
     * 显示聚类最终信息
     */
    public void show(){
        System.out.print("初始聚类中心是：");
        show_Cneter(center_copy);
        System.out.println();

        System.out.print("最终聚类中心：");
        show_Cneter(center);
        System.out.println();

        System.out.println("迭代执行的次数为："+(temp));
        System.out.print("各阶段系统误差平方和");
        for (int i = 0; i < SEE.size(); i++) {
            System.out.print(SEE.get(i)+"\t");
        }
        System.out.println();
        //显示最后系统中各簇中的元素
        show_ClusterData(cluster);
        System.out.println(result);
        //把最后一次聚类作为最终结果存到数据库
        SysCluster sysCluster = new SysCluster();
        sysCluster.setClusterName("用户年龄聚类");
        sysCluster.setClusterResult(result.get(result.size() - 1).toString());
        sysClusterServiceImpl.insertSysCluster(sysCluster);
    }

    /**
     *  kmeans算法具体实施步骤
     */
    public void kmeans(){
        //第一步，初始化各参数
        init();
        //第二步，执行聚类操作，直到收敛或者到达迭代次数
        temp = 1; //用来记录迭代次数
        while (true){
            //将各数据放入对应簇中
            clusterSet();
            //计算对应的误差平方好
            countSEE();
            if (temp > m){
                break;
            }
//            if (SEE.size()!=1){
//                if (SEE.get(temp-1) - SEE.get(temp-2) == 0)
//                    break;
//            }
            if (SEE.size() > 1) {
                // 计算误差平方和的变化
                double errorChange = SEE.get(temp - 1) - SEE.get(temp - 2);
                // 设置方差和小于某个定值，如5%
                double variance = Math.abs(errorChange / SEE.get(temp - 1));
                if (variance < 0.05) { // 方差小于5%
                    break;
                }
            }
            //第三步，设置新的聚类中心，重新开始聚类
            setNewCenter();
            cluster.clear();
            initCluster();
            //让迭代次数增加
            temp++;
        }
    }
}



