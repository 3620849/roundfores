package com.roundforest.controller;


import com.roundforest.dao.SQLiteDAO;
import com.roundforest.services.ReviewService;
import com.roundforest.services.TranslateService;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

/**
 * Before running please set url to database in spring-config.xml
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src\\main\\java\\spring-config.xml");
        ReviewService rws = (ReviewService)context.getBean("ReviewService");
        TranslateService trs = (TranslateService)context.getBean("TranslateService");
        System.out.println("Most active users:");
        System.out.println(rws.getListMostActive());
        System.out.println("Most commented food items:");
        System.out.println(rws.getMostComentedFoodItems());
        System.out.println("Most used words in rewiev");
        System.out.println(rws.getMostUsedWordsInRewiev());
        System.out.println();
        if(args.length>0 && args[0].equals("true")) {
            try {
                System.out.println(trs.translateAllRewiews("en", "fr"));
            } catch (IOException e) {
                e.getMessage();
            }
        };

    }
}
