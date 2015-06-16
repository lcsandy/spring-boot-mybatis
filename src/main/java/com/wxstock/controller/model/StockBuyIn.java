package com.wxstock.controller.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * buy in stock model
 * Created by wcong on 15/5/22.
 */
@Data
public class StockBuyIn {

    @NotNull
    @Min(1000)
    private Integer stockId;

    private String date;

    private Integer money;

}
