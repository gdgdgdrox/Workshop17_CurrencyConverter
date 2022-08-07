'''
<!-- TO-DO
3. Integrate Redis
4. Deploy to Heroku
5. Use GitHub secret
6. Use Json-P instead of Jackson
7. Use WebClient instead of RestTemplate -->

''''''''''''''''
API URL
    Request request = new Request.Builder()
      .url("https://api.apilayer.com/currency_data/convert?to={to}&from={from}&amount={amount}")
      .addHeader("apikey", "APIKEY")
      .method("GET", })
      .build();

'''''''''''''
API Response
{
  "date": "2005-01-01",
  "historical": true,
  "info": {
    "quote": 0.51961,
    "timestamp": 1104623999
  },
  "query": {
    "amount": 10,
    "from": "USD",
    "to": "GBP"
  },
  "result": 5.1961,
  "success": true
}





