package com.wxstock.repository.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DbStockPrice {
    private Integer id;

    private Boolean isDelete;

    private Date gmtCreate;

    private Date gmtModified;

    private String creator;

    private String modifier;

    private Integer stockId;

    private Date date;

    private Integer price;
}