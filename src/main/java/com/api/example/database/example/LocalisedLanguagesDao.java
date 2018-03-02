package com.api.example.database.example;

import org.apache.commons.lang.LocaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 23/11/2016.
 * provides readonly access to localised language reference data in api
 */
@Repository
public class LocalisedLanguagesDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    @Qualifier("exampleDataSource")
    public void LocalisedLanguagesDao(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @return list of iso codes for languages
     */
    public List<String> get() {
        String titlesWhichAreActive = "SELECT p_isocode FROM [dbo].[basestore2languagerel] INNER JOIN languages ON languages.PK = basestore2languagerel.TargetPK";
        return this.jdbcTemplate.query(titlesWhichAreActive, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("p_isocode");
            }
        });
    }

    /**
     *
     * @param language the desired language to search for
     * @return a list of Locales for the desired language
     */
    public List<String> getLocales(String language) {
        List<String> isoCodes = get();
        List<String> locales = new ArrayList<>();
        for (String isoCode : isoCodes) {

            if (language == null) {
                locales.add(LocaleUtils.toLocale(isoCode).toString().replace("_", "-"));
            } else {
                if (isoCode.equals(language)) {
                    locales.add(LocaleUtils.toLocale(isoCode).toString().replace("_", "-"));
                }
            }
        }
        return locales;
    }
}
