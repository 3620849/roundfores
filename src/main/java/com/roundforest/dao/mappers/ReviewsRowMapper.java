package com.roundforest.dao.mappers;

import com.roundforest.model.Reviews;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by UA C on 03.07.2017.
 */
public class ReviewsRowMapper implements RowMapper {

    public Reviews mapRow(ResultSet resultSet, int i) throws SQLException {
        Reviews reviews = new Reviews();
        reviews.setId(resultSet.getInt("Id"));
        reviews.setUserId(resultSet.getString("UserId"));
        reviews.setProductId(resultSet.getString("ProductId"));
        reviews.setProfileName(resultSet.getString("ProfileName"));
        reviews.setHelpfulnessNumerator(resultSet.getInt("HelpfulnessNumerator"));
        reviews.setHelpfulnessDenumerator(resultSet.getInt("HelpfulnessDenominator"));
        reviews.setScore(resultSet.getInt("Score"));
        reviews.setTime(new Date(resultSet.getLong("Time")));
        reviews.setSummary(resultSet.getString("Summary"));
        reviews.setText(resultSet.getString("Text"));

        return reviews;
    }
}