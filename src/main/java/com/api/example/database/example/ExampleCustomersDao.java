package com.api.example.database.example;

import com.api.example.database.example.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dwebb on 12/2/2016.
 * provides readonly access to customer data in api
 */
@Repository
public class ExampleCustomersDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public ExampleCustomersDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @return list of valid customers with a shipping address
     */
    public List<CustomerModel> returnValidCustomerWithShippingAddress() {
        String GET_VALID_CUSTOMER_PROFILES = "SELECT distinct \n" +
                "                      users.[p_uid]\n" +
                "                      ,users.[p_customerid]\n" +
                "                      ,users.[p_status]\n" +
                "                      ,users.[p_employeeid]\n" +
                "                      ,titles.p_code\n" +
                "                      ,users.[p_firstname]\n" +
                "                      ,users.[p_lastname]\n" +
                "                      ,users.[p_ejplusnumber]\n" +
                "                      ,users.[p_flightclubnumber]\n" +
                "                      ,addresses.[p_postalcode]\n" +
                "                      ,addresses.[p_town]\n" +
                "                      ,countrieslp.[p_name]\n" +
                "                  FROM [dbo].[users] as users  \n" +
                "                  INNER JOIN [dbo].[addresses] ON users.p_defaultshipmentaddress=addresses.PK\n" +
                "          INNER JOIN [dbo].[titles] as titles ON users.p_title=titles.PK\n" +
                "          INNER JOIN [dbo].[countries] ON countries.PK=addresses.p_country\n" +
                "          INNER JOIN [dbo].[countrieslp] ON countrieslp.ITEMPK=countries.PK";

        return this.jdbcTemplate.query(GET_VALID_CUSTOMER_PROFILES, new RowMapper<CustomerModel>() {
            @Override
            public CustomerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new CustomerModel(
                        rs.getString("p_uid"),
                        rs.getString("p_customerid"),
                        rs.getString("p_status"),
                        rs.getString("p_employeeid"),
                        rs.getString("p_code"),
                        rs.getString("p_firstname"),
                        rs.getString("p_lastname"),
                        rs.getString("p_ejplusnumber"),
                        rs.getString("p_flightclubnumber"),
                        rs.getString("p_postalcode"),
                        rs.getString("p_town"),
                        rs.getString("p_name"));

            }
        });
    }
}