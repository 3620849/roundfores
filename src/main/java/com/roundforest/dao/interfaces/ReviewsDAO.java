package com.roundforest.dao.interfaces;

import com.roundforest.model.Food;
import com.roundforest.model.Reviews;
import com.roundforest.model.User;

import java.util.List;

/**
 * Created by UA C on 03.07.2017.
 */
public interface ReviewsDAO {
    List<User> getListMostActive();
    List<Food> getMostComentedFoodItems();
    List<String> getTextById(int id);
}
