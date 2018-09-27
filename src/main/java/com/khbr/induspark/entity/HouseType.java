package com.khbr.induspark.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/9/27 0027.
 */

@Entity
public class HouseType {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @Column(length = 32)
    private String id;
    private String imgUrl;
    private String typeName;
    private Byte sysStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Byte getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Byte sysStatus) {
        this.sysStatus = sysStatus;
    }

    @Override
    public String toString() {
        return "HouseType{" +
                "id='" + id + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", typeName='" + typeName + '\'' +
                ", sysStatus=" + sysStatus +
                '}';
    }
}
