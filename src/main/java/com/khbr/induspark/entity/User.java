package com.khbr.induspark.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by MoCush_Chao on 2018/10/1.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @Column(length = 32)
    private String id;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
