import com.ruoyi.YztxApplication;
import com.ruoyi.system.domain.SysMedicinebox;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysCommentService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest(classes = {YztxApplication.class})
public class test {
    //    @Autowired
//    private ISysArticleService sysArticleService;

    @Autowired
    private SysCommentMapper sysCommentMapper;

    @Autowired
    private ISysCommentService sysCommentService;

    @Autowired
    private SysMedicineboxMapper sysMedicineboxMapper;

    @Test
    public void t() throws FileNotFoundException, JSONException {
//        SysArticle article = new SysArticle();
//        article.setTitle("1");
//        List<SysArticle> sysArticles = sysArticleService.selectSysArticleByTitle(article);
//        System.out.println(sysArticles);
//        Map map = new HashMap();
//        LocalDateTime begin = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
//        LocalDateTime end = LocalDateTime.of(2024, 2, 1, 0, 0, 0);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String s = begin.format(formatter);
//        String s1 = end.format(formatter);
//        map.put("begin",s);
//        map.put("end",s1);


//        System.out.println(sysUserMapper.countUsersByAge());
        //k值聚类
//        MyKmeans myKmeans = new MyKmeans(2, 5);
//        myKmeans.kmeans();
//        myKmeans.show();

//        System.out.println(sysCommentMapper.selectCommentWithUser("2"));
//        System.out.println(sysCommentService.selectCommentWithUser("2"));
//        String[] s = {"药品4", "药品5"};
//        sysMedicineboxMapper.deleteSysMedicineOfBox(s, 4l,"夏日必备");
        SysMedicinebox sysMedicinebox = new SysMedicinebox();
        sysMedicinebox.setUserId(4l);
        sysMedicinebox.setBoxCategory("夏日必备");
        System.out.println(sysMedicineboxMapper.deleteSysMedicineOfBox("药品4",4l,"夏日必备"));
    }
}
