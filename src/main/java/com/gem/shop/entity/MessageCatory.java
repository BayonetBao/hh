package com.gem.shop.entity;

public class MessageCatory {
    private Integer id;

    private String mcatory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMcatory() {
        return mcatory;
    }

    public void setMcatory(String mcatory) {
        this.mcatory = mcatory == null ? null : mcatory.trim();
    }
}