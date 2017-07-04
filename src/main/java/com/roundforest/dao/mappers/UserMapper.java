package com.roundforest.dao.mappers;

import com.roundforest.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by UA C on 03.07.2017.
 */
public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getString("UserId"));
        return user;
    }
}
