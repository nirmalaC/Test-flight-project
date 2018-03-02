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
 * allows read access to airports data in Example
 */
@Repository
public class AirportsDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public AirportsDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @param active active status of airports desired
     * @return list of airport codes with desired status
     */
    public List<String> getAirportsThatAreActive(boolean active) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("p_active", active);
        String airportQuery = "SELECT [p_code] FROM [dbo].[transportfacility] WHERE p_active = :p_active;";
        return this.jdbcTemplate.query(airportQuery, namedParameters, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("p_code");
            }
        });
    }
}




