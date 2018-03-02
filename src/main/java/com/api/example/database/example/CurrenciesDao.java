package com.api.example.database.example;

import com.api.example.fixture.asserters.models.ExpectedCurrency;
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
 * Created by daniel on 23/11/2016
 * provides readonly access to currency data in api
 */
@Repository
public class CurrenciesDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public CurrenciesDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @param active the active status of currencies that you wish to return
     * @return a list of currencies from api
     */
    public List<ExpectedCurrency> getCurrencies(boolean active) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("p_active", active);
        String titleQuery = "SELECT [p_isocode], [p_symbol], [p_base], [p_digits], [p_active] FROM [dbo].[currencies] WHERE p_active = :p_active;";

        return this.jdbcTemplate.query(titleQuery, namedParameters, new RowMapper<ExpectedCurrency>() {
            @Override
            public ExpectedCurrency mapRow(ResultSet rs, int rowNum) throws SQLException {
                return ExpectedCurrency.builder()
                        .code(rs.getString("p_isocode"))
                        .displaySymbol(rs.getString("p_symbol"))
                        .isBaseCurrency(rs.getBoolean("p_base"))
                        .decimalPlaces(rs.getInt("p_digits"))
                        .isActive(rs.getBoolean("p_active"))
                        .build();
            }
        });
    }
}




