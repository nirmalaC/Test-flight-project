package com.api.example.database.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by daniel on 23/11/2016.
 * provides readonly access to title reference data in api
 */
@Repository
public class ExampleTitleDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    @Qualifier("exampleDataSource")
    public void ExampleTitleDao(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @param active the active status desired
     * @return a list of Titles which match the desired active status
     */
    public List<String> findTitlesWhichAreActive(boolean active) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("p_active", active);
        String titleQuery = "SELECT p_code as title FROM [dbo].[titles] WHERE p_active = :p_active";
        return this.jdbcTemplate.query(titleQuery, namedParameters, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("title");
            }
        });
    }


}
