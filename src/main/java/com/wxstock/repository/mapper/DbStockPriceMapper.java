package com.wxstock.repository.mapper;

import com.wxstock.repository.entity.DbStockPrice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * DbStockPriceMapper
 * Created by wcong on 15/5/22.
 */
public interface DbStockPriceMapper {

    List<DbStockPrice> selectByCodeAndDateList(@Param("stockId") Integer stockId, @Param("dateList") List<Date> dateList);

}
