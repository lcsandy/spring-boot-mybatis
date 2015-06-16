package com.wxstock.repository.mapper;

import com.wxstock.repository.entity.DbStock;

import java.util.List;

/**
 * DbStockMapper
 * Created by wcong on 15/5/22.
 */
public interface DbStockMapper {

    List<DbStock> searchByCode(String code);

}
