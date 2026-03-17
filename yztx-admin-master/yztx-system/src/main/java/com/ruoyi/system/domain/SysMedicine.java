package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class SysMedicine extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //药品名称
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
