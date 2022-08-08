package com.exchange.exchangerate.Controller;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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

    //Task 1 requires us to get currency right after application is started. 
    //A method annotated with @PostConstruct is executed after application started
    //and Beans (e.g. CurrencyController, ExchangeService) have been instantiated
    @PostConstruct
    public void getCurrency(){
        service.getCurrency();
    }

    @GetMapping
    public String returnIndexPage(Model model){
        model.addAttribute("currency", Currency.currencyCodeAndValue);
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
