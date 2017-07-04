package com.roundforest.dao.mappers;

import com.roundforest.model.Food;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by UA C on 03.07.2017.
 */
public class FoodMapper implements RowMapper<Food> {
    public Food mapRow(ResultSet resultSet, int i) throws SQLException {
        Food food = new Food();
        food.setProductId(resultSet.getString("ProductId"));
        return food;
    }
}
