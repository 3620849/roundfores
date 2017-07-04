package com.roundforest.services;

import com.roundforest.dao.SQLiteDAO;
import com.roundforest.model.Food;
import com.roundforest.model.Reviews;
import com.roundforest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by UA C on 03.07.2017.
 */

@Service("ReviewService")
public class ReviewService {
    @Autowired
    SQLiteDAO sqLiteDAO;

    public List<User> getListMostActive(){
        return sqLiteDAO.getListMostActive();
    }
    public List<Food>getMostComentedFoodItems(){
        return sqLiteDAO.getMostComentedFoodItems();
    }

    public List<String>getMostUsedWordsInRewiev(){

        CustomDictionary cd = new CustomDictionary();
        int size = sqLiteDAO.getSizeOfTabel();
        int currentRew = 1;
        while(currentRew!=size){
           String text =  sqLiteDAO.getTextById(currentRew).get(0);
            String [] arr = text.replaceAll("[^a-zA-Z ]", "").split(" ");
            for(String s: arr){
                cd.addWord(s);
            }
        }
        return cd.getMostUsedWords();
    };

    public Reviews translateRewiev(String input, String output,String text){
        return null;
    }

}
