package com.exchange.exchangerate.Model;

import java.math.BigDecimal;

public class ExchangeRate{
    private Query query;
    private BigDecimal result;
    // private Date date;

    public Query getQuery() {
        return this.query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public BigDecimal getResult() {
        return this.result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{" +
            " query='" + getQuery() + "'" +
            ", result='" + getResult() + "'" +
            "}";
    }

}