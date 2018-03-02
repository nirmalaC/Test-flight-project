package com.api.example.database.example;

import com.api.example.database.example.models.PassengerTypeDbModel;
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
 * provides readonly access to passenger reference data in api
 */
@Repository
public class ExamplePassengerTypeDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public ExamplePassengerTypeDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @param passengerType the passenger type to search for
     * @return list of passenger types that match the passenger type requested
     */
    public List<PassengerTypeDbModel> getPassengersOfType(String passengerType) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("passengerType", passengerType);
        String passengerTypeQuery =
                "SELECT " +
                        "[p_code], " +
                        "[p_minage]," +
                        "[p_maxage]," +
                        "[p_passengertypecode]," +
                        "[p_active]" +
                        "FROM [dbo].[passengertype] " +
                        "WHERE p_code = :passengerType " +
                        "AND p_active = 1";

        return this.jdbcTemplate.query(passengerTypeQuery, namedParameters, new RowMapper<PassengerTypeDbModel>() {
            @Override
            public PassengerTypeDbModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new PassengerTypeDbModel(
                        rs.getString("p_code"),
                        rs.getInt("p_minage"),
                        rs.getInt("p_maxage"),
                        rs.getString("p_passengertypecode"),
                        rs.getBoolean("p_active"));
            }
        });
    }

    /**
     * @return list of passenger types that match the passenger type requested
     */
    public List<PassengerTypeDbModel> getPassengerTypes() {
        String passengerTypeQuery =
                "SELECT " +
                        "[p_code], " +
                        "[p_minage]," +
                        "[p_maxage]," +
                        "[p_passengertypecode]," +
                        "[p_active] " +
                        "FROM [dbo].[passengertype] " +
                        "WHERE p_active = 1";

        return this.jdbcTemplate.query(passengerTypeQuery, new RowMapper<PassengerTypeDbModel>() {
            @Override
            public PassengerTypeDbModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new PassengerTypeDbModel(
                        rs.getString("p_code"),
                        rs.getInt("p_minage"),
                        rs.getInt("p_maxage"),
                        rs.getString("p_passengertypecode"),
                        rs.getBoolean("p_active"));
            }
        });
    }
}
