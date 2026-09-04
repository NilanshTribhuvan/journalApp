package com.nilanshki.journalApp.service;


import com.nilanshki.journalApp.api.response.WeatherResponse;
import com.nilanshki.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String apiKey="";

    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
       String finalAPI=API.replace("CITY",city).replace("API_KEY",apiKey);
//POST
//        String requestBody="{\n"+
//        "        \"userName\": \"tn\",\n"+
//        "        \"password\": \"tn\"\n"+
//        "}  ";
//
//        HttpEntity<String> httpEntity=new HttpEntity<>(requestBody);
//      above is a post call and in HttpMethod change .get to .POST and insted of null put httpEntity, this won't work on weather api because it doesn't know what it is.
//      if you have another return type then, for Example
        //User user= User.builder().userName("tn").password("tn").build();
        //and put it in place of requestBody...
// you can also add headers
//       HttpHeaders httpHeaders=new HttpHeaders();
//        httpHeaders.set("key","value"); send in the httpEntity (requestBody,httpHeaders)



        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }

}
