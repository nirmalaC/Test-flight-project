package com.api.example.database.example;

import com.api.example.database.example.models.ExampleFlightDbModel;
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
 * provides readonly access to flight data in api
 */
@Repository
public class ExampleFlightsDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public ExampleFlightsDao(@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * @param flightKeys the flight keys to search for
     * @return a list of flights that exist in Example with the flight keys provided
     */
    public List<ExampleFlightDbModel> returnFlightsThatExistFromList(List<String> flightKeys) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("flightKeys", flightKeys);
        String SELECT_FLIGHTS_AVAILABLE_AFTER_TODAY_USING_FLIGHT_KEYS = "SELECT" +
                "       [warehouses].[p_code] as flightkey" +
                "      ,CONVERT(VARCHAR(10), CAST(p_departuretime AS DATE), 105) as localdepdt" +
                "      ,[p_arrivaltime]" +
                "      ,[p_originterminal]" +
                "      ,[p_destinationterminal]" +
                "      ,[p_status]" +
                "      ,[p_updateddeparturetime]" +
                "      ,[warehouses].[p_active]" +
                "      ,[p_scheduleddeptime]" +
                "      ,[p_scheduledarrtime]" +
                "      ,[p_planneddeptime]" +
                "      ,[p_plannedarrtime]" +
                ",sector.p_code as route" +
                ",origin.p_code as departs" +
                ",dest.p_code as arrives" +
                ",origin.p_defaultcurrency as currency" +
                "  FROM [dbo].[warehouses]" +
                "  INNER JOIN travelsector as sector ON p_travelsector = sector.PK" +
                "  INNER JOIN transportfacility as origin ON sector.p_origin = origin.PK" +
                "  INNER JOIN transportfacility as dest ON sector.p_destination = dest.PK" +
                " INNER JOIN enumerationvalues as enum ON enum.PK = warehouses.p_status" +
                "  WHERE [warehouses].[p_code] IN (:flightKeys)" +
                "  AND p_departuretime > GetDate()" +
                " AND enum.Code != 'CANCELLED'";
        return this.jdbcTemplate.query(SELECT_FLIGHTS_AVAILABLE_AFTER_TODAY_USING_FLIGHT_KEYS, namedParameters, new RowMapper<ExampleFlightDbModel>() {
            @Override
            public ExampleFlightDbModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ExampleFlightDbModel(
                        rs.getString("flightKey"),
                        rs.getString("localdepdt"),
                        rs.getString("p_arrivaltime"),
                        rs.getString("p_originterminal"),
                        rs.getString("p_destinationterminal"),
                        rs.getString("p_status"),
                        rs.getString("p_updateddeparturetime"),
                        rs.getString("p_active"),
                        rs.getString("p_scheduleddeptime"),
                        rs.getString("p_scheduledarrtime"),
                        rs.getString("p_planneddeptime"),
                        rs.getString("p_plannedarrtime"),
                        rs.getString("route"),
                        rs.getString("departs"),
                        rs.getString("arrives"),
                        rs.getString("currency"));

            }
        });
    }
}




