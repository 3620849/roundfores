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
public class ReviewService /*implements Runnable*/{
    @Autowired
    SQLiteDAO sqLiteDAO;

    public List<User> getListMostActive(){
        return sqLiteDAO.getListMostActive();
    }

    public List<Food>getMostComentedFoodItems(){
        return sqLiteDAO.getMostComentedFoodItems();
    }

    public List<String>getMostUsedWordsInRewiev(){

        Dictionary dictionary = new Dictionary();
        int size = sqLiteDAO.getSizeOfTabel();//Length of DB
        int currentRow = 1;
        while(currentRow<size){
           String text =  sqLiteDAO.getTextById(currentRow).get(0);
            String [] arr = text.replaceAll("[^a-zA-Z ]", "").replaceAll(" +"," ").split(" ");
            for(String s: arr){
                dictionary.addWord(s);
            }
            ++currentRow;

        }
        return dictionary.getMostCommonWord();
    };

    public Reviews translateRewiev(String input, String output,String text){
        return null;
    }

   /* public void run() {

    }*/
}
