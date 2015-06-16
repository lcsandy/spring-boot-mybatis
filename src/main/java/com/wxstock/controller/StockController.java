package com.wxstock.controller;

import com.wxstock.controller.model.StockBuyIn;
import com.wxstock.service.StockService;
import com.wxstock.service.model.Result;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;
import java.text.ParseException;

/**
 * about stock api
 * Created by wcong on 15/5/22.
 */
@Controller
public class StockController {

    @Inject
    StockService stockService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/stock/search/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result searchStock(@PathVariable String code) {
        return Result.success(stockService.searchByCode(code));
    }

    @RequestMapping("/result")
    public String stockResult(@Valid StockBuyIn stockBuyIn, ModelMap modelMap, BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors();
        }
        try {
            Integer result = stockService.stockResult(stockBuyIn);
            float resultFloat = ((float) result) / 1000;
            if (resultFloat > 0) {
                modelMap.put("head", "恭喜");
                modelMap.put("desc", "您获得了");
            } else {
                modelMap.put("head", "遗憾");
                modelMap.put("desc", "您损失了");
            }
            modelMap.put("result", resultFloat);
        } catch (Exception e) {
            modelMap.put("head", "抱歉");
            modelMap.put("desc", "您查询的股票");
            modelMap.put("result", "还没有数据");
        }
        return "result";
    }

}
