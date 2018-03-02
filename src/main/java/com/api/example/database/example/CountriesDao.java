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
 * provides read access to countries held in Example
 */
@Repository
public class CountriesDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public CountriesDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @param active the active status of countries you wish to return
     * @return a list of country iso codes for counntries
     */
    public List<String> getCountries(boolean active) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("p_active", active);
        String titleQuery = "SELECT [p_isocode] FROM [dbo].[countries] WHERE p_active = :p_active;";
        return this.jdbcTemplate.query(titleQuery, namedParameters, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("p_isocode");
            }
        });
    }
}




