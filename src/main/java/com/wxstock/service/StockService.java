package com.wxstock.service;

import com.wxstock.controller.model.StockBuyIn;
import com.wxstock.repository.entity.DbStock;
import com.wxstock.repository.entity.DbStockPrice;
import com.wxstock.repository.mapper.DbStockMapper;
import com.wxstock.repository.mapper.DbStockPriceMapper;
import com.wxstock.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * StockService
 * Created by wcong on 15/5/22.
 */
@Service
public class StockService {

    @Inject
    DbStockMapper dbStockMapper;

    @Inject
    DbStockPriceMapper dbStockPriceMapper;

    public List<DbStock> searchByCode(String code) {
        code = code + "%";
        return dbStockMapper.searchByCode(code);
    }

    public Integer stockResult(StockBuyIn stockBuyIn) throws ParseException {
        Date date = DateUtil.formatStringToDate(stockBuyIn.getDate());
        List<Date> dateList = DateUtil.makeDateListForBuyIn(date);
        if (dateList.isEmpty()) {
            return null;
        }
        List<DbStockPrice> dbStockMapperList = dbStockPriceMapper.selectByCodeAndDateList(stockBuyIn.getStockId(), dateList);
        Integer stockNum = stockBuyIn.getMoney() / dbStockMapperList.get(1).getPrice();
        return stockNum * (dbStockMapperList.get(0).getPrice() - dbStockMapperList.get(1).getPrice());
    }


}
