package com.roundforest.dao;

import com.roundforest.dao.interfaces.ReviewsDAO;
import com.roundforest.dao.mappers.FoodMapper;
import com.roundforest.dao.mappers.UserMapper;
import com.roundforest.model.Food;
import com.roundforest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by UA C on 03.07.2017.
 */

@Repository
public class SQLiteDAO implements ReviewsDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getListMostActive() {
        String sql = "select UserId FROM Reviews GROUP BY UserId ORDER BY COUNT(Id) DESC LIMIT 1000";
        return  jdbcTemplate.query(sql,new UserMapper());
    }
    public List<Food> getMostComentedFoodItems(){
        String sql = "select ProductId FROM Reviews GROUP BY UserId ORDER BY COUNT(Id) DESC LIMIT 1000";
        return  jdbcTemplate.query(sql,new FoodMapper());
    }

    public List<String> getTextById(int id){
        String sql = "select LOWER(Text) as Text FROM Reviews WHERE Id = "+id;
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public int getSizeOfTabel(){
        String sql = "SELECT ROWID from Reviews ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
