package com.nilanshki.journalApp.service;


import com.nilanshki.journalApp.api.response.WeatherResponse;
import com.nilanshki.journalApp.cache.AppCache;
import com.nilanshki.journalApp.constants.Placeholder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}") private String apiKey;



    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherResponse getWeather(String city){
       String finalAPI=appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholder.CITY,city).replace(Placeholder.API_KEY,apiKey);
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
