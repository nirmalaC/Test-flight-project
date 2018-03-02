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
import java.util.Random;

/**
 * Created by daniel on 23/11/2016.
 * provides read access to booking data in Example
 */
@Repository
public class BookingDao {

    static Random rand = new Random(System.currentTimeMillis());
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public BookingDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    static <T> T getRandomItem(List<T> list) {
        try {
            return list.get(rand.nextInt(list.size()));
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * @return list of all existing booking references
     */
    public List<String> getBookings() {
        String bookingQuery = "SELECT TOP (10) \n" +
                "      [p_bookingreference] \n" +
                "  FROM [dbo].[orders]\n" +
                "  INNER JOIN orderentries oe ON oe.p_order = orders.PK\n" +
                "  INNER JOIN warehouses w ON w.p_code = oe.p_flightcode\n" +
                "  ORDER BY w.p_departuretime ASC";
        return this.jdbcTemplate.query(bookingQuery, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("p_bookingreference");
            }
        });
    }

    /**
     *
     * @param status the status of bookings you want to return
     * @return list of all existing booking references for bookings with desired status
     */
    public List<String> getBookings(String status) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("p_status", status);
        String bookingQuery = "SELECT TOP (10) \n" +
                "      [p_bookingreference] \n" +
                "  FROM [dbo].[orders]\n" +
                "  INNER JOIN orderentries oe ON oe.p_order = orders.PK\n" +
                "  INNER JOIN warehouses w ON w.p_code = oe.p_flightcode\n" +
                " WHERE p_status = ~:p_status " +
                "  ORDER BY w.p_departuretime ASC";
        return this.jdbcTemplate.query(bookingQuery, namedParameters, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("p_bookingreference");
            }
        });
    }

    /**
     *
     * @return a random booking with any status
     */
    public String getRandomBooking() {
        return getRandomItem(getBookings());
    }

    /**
     *
     * @param status the status of bookings you want to return
     * @return a random booking reference for booking with desired status
     */
    public String getRandomBooking(String status) {
        return getRandomItem(getBookings(status));
    }

    /**
     *
     * @return an invalid booking reference
     */
    public int getInvalidBookingReference() {
        return 0;
    }
}




