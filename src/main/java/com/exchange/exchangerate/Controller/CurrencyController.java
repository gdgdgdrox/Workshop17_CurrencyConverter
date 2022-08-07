package com.exchange.exchangerate.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exchange.exchangerate.Model.Currency;
import com.exchange.exchangerate.Model.ExchangeRate;
import com.exchange.exchangerate.Service.ExchangeService;

@Controller
public class CurrencyController {

    @Autowired
    private ExchangeService service;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public String returnIndexPage(Model model){
        service.getCurrency();
        model.addAttribute("currency", Currency.currencyCodeAndValue);
        redisTemplate.opsForValue().set("example1", "examplezz");
        return "index";
    }

    @GetMapping("/result")
    public String returnResultPage(@RequestParam String to, 
                                    @RequestParam String from, 
                                    @RequestParam BigDecimal amount,
                                    Model model){
        ExchangeRate exchangeRate = service.getResult(to, from, amount);
        model.addAttribute("exchangeRate", exchangeRate);
        return "resultPage";

    }


}
