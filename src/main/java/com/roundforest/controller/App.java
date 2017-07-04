package com.roundforest.controller;


import com.roundforest.dao.SQLiteDAO;
import com.roundforest.services.ReviewService;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by UA C on 03.07.2017.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src\\main\\java\\spring-config.xml");
        ReviewService rws = (ReviewService)context.getBean("ReviewService");



        System.out.println(rws.getListMostActive());
        System.out.println(rws.getMostComentedFoodItems());
        //rws.getMostUsedWordsInRewiev();


    }
}
