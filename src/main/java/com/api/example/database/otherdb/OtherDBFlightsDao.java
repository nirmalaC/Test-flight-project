package com.api.example.database.otherdb;

import org.apache.commons.lang3.StringUtils;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by daniel on 23/11/2016.
 * This class provides the ability to get available flights from OtherDB
 */
@Repository
public class OtherDBFlightsDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource for connecting to the other databse
     */
    @Autowired
    public OtherDBFlightsDao(@Qualifier("otherdbDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }



    /**
     *
     * @param numberOfSeatsNeeded the minimum number of available seats needed on the flight
     * @param fromDate the date that the flight must depart after
     * @param toDate the date the the flight must depart before
     * @return
     */
    public List<String> getFlightsAvailableBetweenWithNumberOfPassengers(int numberOfSeatsNeeded, Calendar fromDate, Calendar toDate) {
        return getFlightsAvailableBetweenWithNumberOfPassengers(numberOfSeatsNeeded, fromDate, toDate, null);
    }

    /**
     *
     * @param numberOfSeatsNeeded the minimum number of available seats needed on the flight
     * @param fromDate the date that the flight must depart after
     * @param toDate the date the the flight must depart before
     * @return
     */
    public List<String> getFlightsAvailableBetweenWithNumberOfPassengers(int numberOfSeatsNeeded, Calendar fromDate, Calendar toDate, String Bundles) {
        String fromDateForQuery = new SimpleDateFormat("yyyy-MM-dd HH:mm:00.000").format(fromDate.getTime());
        String toDateForQuery = new SimpleDateFormat("yyyy-MM-dd HH:mm:00.000").format(toDate.getTime());

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("fromDate", fromDateForQuery)
                .addValue("toDate", toDateForQuery)
                .addValue("numberOfSeats", numberOfSeatsNeeded);

        String query = "SELECT DISTINCT seg.[FlightKey] " +
                " FROM [ejFlight].[dbo].[Flight] seg" +
                " INNER JOIN [ejFlight].[dbo].[AirportCode] as Dep" +
                " ON Dep.AirportCodeId = DepAirportCodeID" +
                " INNER JOIN [ejFlight].[dbo].[AirportCode] as Arr" +
                " ON Arr.AirportCodeId = ArrAirportCodeID" +
                " INNER JOIN FlightFare" +
                " ON seg.FlightID = FlightFare.FlightID" +
                " INNER JOIN FareClassCode" +
                " ON FlightFare.FareClassCodeID = FareClassCode.FareClassCodeID" +
                " INNER JOIN FareClassPriceTranslation" +
                " ON FareClassCode.FareClassCodeID = FareClassPriceTranslation.FareClassCodeID" +
                " INNER JOIN dbo.FlightFare ff WITH (NOLOCK) ON ff.FlightID = seg.FlightID" +
                " AND ff.AU >  seg.SeatsSold" +
                " AND ff.AUmin <= seg.SeatsSold + :numberOfSeats" +
                " AND (seg.SeatsSold < seg.Lid" +
                " AND seg.Lid != 0)" +
                " AND ff.AUMin != seg.Lid" +
                " WHERE LocalDepDtTm BETWEEN :fromDate AND :toDate;";

        if (Bundles != null)
        {
            query = query.substring(0, query.length() -1);
            String [] bundleList = Bundles.split(",");
            String list = StringUtils.join(bundleList, "','");
            list = "'" + list + "'";
            query += " AND FareClassCode.FareClassCodeDescription IN (" + list + ");";
        }

        return this.jdbcTemplate.query(query, namedParameters, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("FlightKey");
            }
        });
    }

    /**
     *
     * @param numberOfSeatsNeeded the minimum number of available seats needed on the flight
     * @param fromDate the date that the flight must depart after
     * @param toDate the date the the flight must depart before
     * @param departureAirport the departure Airport
     * @param arrivalAirport the Arrival Airport
     * @return
     */
    public List<String> getFlightsAvailableBetweenFromAndToWithNumberOfPassengers(int numberOfSeatsNeeded, Calendar fromDate, Calendar toDate, String departureAirport, String arrivalAirport) {
        String fromDateForQuery = new SimpleDateFormat("yyyy-MM-dd HH:mm:00.000").format(fromDate.getTime());
        String toDateForQuery = new SimpleDateFormat("yyyy-MM-dd HH:mm:00.000").format(toDate.getTime());

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("fromDate", fromDateForQuery);
        mapSqlParameterSource.addValue("toDate", toDateForQuery);
        mapSqlParameterSource.addValue("depAirport", departureAirport);
        mapSqlParameterSource.addValue("arrAirport", arrivalAirport);
        SqlParameterSource namedParameters = mapSqlParameterSource.addValue("numberOfSeats", numberOfSeatsNeeded);


        String query = "SELECT DISTINCT seg.[FlightKey] " +
                " FROM [ejFlight].[dbo].[Flight] seg" +
                " INNER JOIN [ejFlight].[dbo].[AirportCode] as Dep" +
                " ON Dep.AirportCodeId = DepAirportCodeID" +
                " INNER JOIN [ejFlight].[dbo].[AirportCode] as Arr" +
                " ON Arr.AirportCodeId = ArrAirportCodeID" +
                " INNER JOIN FlightFare" +
                " ON seg.FlightID = FlightFare.FlightID" +
                " INNER JOIN FareClassCode" +
                " ON FlightFare.FareClassCodeID = FareClassCode.FareClassCodeID" +
                " INNER JOIN FareClassPriceTranslation" +
                " ON FareClassCode.FareClassCodeID = FareClassPriceTranslation.FareClassCodeID" +
                " INNER JOIN dbo.FlightFare ff WITH (NOLOCK) ON ff.FlightID = seg.FlightID" +
                " AND ff.AU >  seg.SeatsSold" +
                " AND ff.AUmin <= seg.SeatsSold + :numberOfSeats" +
                " AND (seg.SeatsSold < seg.Lid" +
                " AND seg.Lid != 0)" +
                " AND ff.AUMin != seg.Lid" +
                " WHERE LocalDepDtTm BETWEEN :fromDate AND :toDate " +
                " AND Dep.AirportCode = :depAirport and Arr.AirportCode = :arrAirport;";

        return this.jdbcTemplate.query(query, namedParameters, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("FlightKey");
            }
        });
    }

}
