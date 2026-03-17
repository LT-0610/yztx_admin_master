package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户自定义铃声对象 sys_ringtone
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
public class SysRingtone extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 铃声名字 */
    @Excel(name = "铃声名字")
    private String ringtoneName;

    /** 铃声路径 */
    @Excel(name = "铃声路径")
    private String filePath;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRingtoneName(String ringtoneName) 
    {
        this.ringtoneName = ringtoneName;
    }

    public String getRingtoneName() 
    {
        return ringtoneName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ringtoneName", getRingtoneName())
            .append("filePath", getFilePath())
            .append("userId", getUserId())
            .toString();
    }
}
