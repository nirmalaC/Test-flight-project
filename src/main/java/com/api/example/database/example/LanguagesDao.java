package com.api.example.database.example;

import com.api.example.fixture.asserters.models.ExpectedLanguage;
import org.apache.commons.lang.LocaleUtils;
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
 * provides readonly access to languages reference data in api
 */
@Repository
public class LanguagesDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public LanguagesDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @param active the desired active status of languages
     * @return a list of languages matching the desired active status
     */
    public List<ExpectedLanguage> getLanguages(boolean active) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("p_active", active);
        String titleQuery = "SELECT [p_isocode], [p_active] FROM [dbo].[languages] WHERE p_bcp47code IS NOT NULL AND p_active = :p_active;";

        return this.jdbcTemplate.query(titleQuery, namedParameters, new RowMapper<ExpectedLanguage>() {
            @Override
            public ExpectedLanguage mapRow(ResultSet rs, int rowNum) throws SQLException {
                return ExpectedLanguage.builder()
                        .code(rs.getString("p_isocode"))
                        .isActive(rs.getBoolean("p_active"))
                        .isoCode(getLocale(rs.getString("p_isocode")))
                        .build();
            }
        });
    }

    private String getLocale(String isoCode) {
                return LocaleUtils.toLocale(isoCode).toString().replace("_", "-");
    }
}




