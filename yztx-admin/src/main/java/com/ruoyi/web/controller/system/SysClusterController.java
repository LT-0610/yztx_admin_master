package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.analysis.MyKmeans;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysCluster;
import com.ruoyi.system.service.ISysClusterService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 聚类结果信息Controller
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
@RestController
@RequestMapping("/system/cluster")
public class SysClusterController extends BaseController
{
    @Autowired
    private ISysClusterService sysClusterService;

    /**
     * 查询聚类结果信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysCluster sysCluster)
    {
        startPage();
        List<SysCluster> list = sysClusterService.selectSysClusterList(sysCluster);
        return getDataTable(list);
    }

    /**
     *k值聚类(年龄)
     */
    @GetMapping("/doCluster")
    public AjaxResult doCluster(){
        //k值聚类
        MyKmeans myKmeans = new MyKmeans(2, 10);
        myKmeans.kmeans();
        myKmeans.show();
        return success("k值聚类(年龄)执行成功");
    }

}
