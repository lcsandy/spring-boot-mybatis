package com.wxstock.repository.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DbStock {
    private Integer id;

    private Boolean isDelete;

    private Date gmtCreate;

    private Date gmtModified;

    private String creator;

    private String modifier;

    private String code;

    private String name;
}