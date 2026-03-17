package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author wuzhenyong
 * ClassName:QsFillVO.java
 * date:2024-03-02 14:52
 * Description: 问卷填报VO
 */
@Data
public class QsFillVO {
    private List<KeyValueDTO> titleList;
    /** 总记录数 */
    private long total;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;
    private List<Map<String, Object>> rows;

}
