package com.roundforest.services;

import com.roundforest.dao.SQLiteDAO;
import com.roundforest.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by UA C on 08.07.2017.
 */
@Service("TranslateService")
public class TranslateService {
    @Autowired
    RestTemplate restTemplate;
    String url = "https://api.google.com/translate";
    @Autowired
    SQLiteDAO sqLiteDAO;


    public TranslateService( ) {
    }

    public  List<Reviews> translateAllRewiews(String from,String to) throws IOException {
        List<Reviews> reviewsList= sqLiteDAO.getAllReviews();
        for(Reviews r : reviewsList){
            String translate = translateString(from,to, r.getText());
            r.setText(translate);
        }
        return reviewsList;
    }
    private String translateString(String from,String to,String text) throws IOException {
        String json = parseToJson(from, to,text);
        System.out.println(json);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json,headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity,String.class);
        System.out.println(response.getStatusCode());
        if(!response.getStatusCode().equals(200)){
            throw new IOException("server return status code:"+response.getStatusCode().toString()+"when try translate text");
        }
        return response.toString();
    }
    private String parseToJson(String from,String to,String text){
        String json = "{\"input_lang\": \""+from+"\", \"output_lang\": \""+to+"\", \"text\": \""+text+"\"}";
     return json;
    }

}
