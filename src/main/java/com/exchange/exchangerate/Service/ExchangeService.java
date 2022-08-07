package com.exchange.exchangerate.Service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.exchange.exchangerate.Model.Currency;
import com.exchange.exchangerate.Model.ExchangeRate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExchangeService {
    
    @Value("${currency}")
    private String currencyURL;
    @Value("${baseURL}")
    private String baseURL;
    @Value("${apikey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public void getCurrency(){
        ResponseEntity<String> response = restTemplate.getForEntity(currencyURL, String.class);
        String responseBody = response.getBody();
        ObjectMapper mapper = new ObjectMapper();
        try {
            Currency.currencyCodeAndValue = mapper.readValue(responseBody, Map.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public ExchangeRate getResult(String to, String from, BigDecimal amount){
        String fullURL = UriComponentsBuilder.fromUriString(baseURL).
        queryParam("to", to).
        queryParam("from", from).
        queryParam("amount", amount).
        toUriString();
        System.out.println(fullURL);

        RequestEntity<Void> reqEntity = 
                    RequestEntity.get(fullURL).header("apikey", apiKey).build();

        ResponseEntity<ExchangeRate> respEntity = 
                    restTemplate.exchange(reqEntity, ExchangeRate.class);

        ExchangeRate exchangeRate = respEntity.getBody();
        return exchangeRate;
    }





    
}
