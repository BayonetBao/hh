package com.gem.shop.entity;

import java.util.Date;

public class Goods {
    private Integer id;
    private int i;
    private Integer catoryId;

    private String name;

    private Float price;

    private String pic;

    private Date createtime;

    private String detail;

    private  GoodsCatory catory;//意义关系的体现

    public GoodsCatory getCatory() {
        return catory;
    }

    public void setCatory(GoodsCatory catory) {
        this.catory = catory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatoryId() {
        return catoryId;
    }

    public void setCatoryId(Integer catoryId) {
        this.catoryId = catoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}