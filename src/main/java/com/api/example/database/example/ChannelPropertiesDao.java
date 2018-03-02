package com.api.example.database.example;

import com.api.example.database.example.models.ChannelPropertiesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created by dwebb on 1/11/2017.
 */
@Repository
public class ChannelPropertiesDao {

    static Random rand = new Random(System.currentTimeMillis());
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public ChannelPropertiesDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private String getQuery()
    {
        return "SELECT ev.code\n" +
                "      ,p_propertyname\n" +
                "      ,p_propertyvalue\n" +
                "  FROM propvalueconfig\n" +
                "  INNER JOIN enumerationvalues ev ON ev.PK = p_channel\n" +
                "  ORDER BY p_channel";
    }

    /**
     * @return list of valid customers with a shipping address
     */
    public List<ChannelPropertiesModel> returnChannelProperties() {
        return this.jdbcTemplate.query(getQuery(), new RowMapper<ChannelPropertiesModel>() {
            @Override
            public ChannelPropertiesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ChannelPropertiesModel(
                        rs.getString("code"),
                        rs.getString("p_propertyname"),
                        rs.getString("p_propertyvalue"));

            }
        });
    }

}
