package com.api.example.database.example;

import com.api.example.database.example.models.AdminFeesModel;
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
 * Created by AndrewGr on 14/12/2016.
 * this class allows read access to admin fee data in Example
 */
@Repository
public class AdminFeeDao {
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public AdminFeeDao (@Qualifier("exampleDataSource") DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     *
     * @return list of Admin Fees from Example
     */
    public List<AdminFeesModel> getAdminFees() {
        String GET_ADMIN_FEES = "Select " +
                "[p_code], " +
                "[p_passengertype], " +
                "[taxrow].[p_value], " +
                "[currency].[p_isocode] " +
                "from [dbo].[taxes] as taxes " +
                "INNER JOIN [dbo].[taxrows] as taxrow ON [taxes].[PK] = [taxrow].[p_tax] " +
                "Left outer JOIN dbo.enumerationvalues as codeName ON p_channel = codeName.PK " +
                "Left outer join dbo.currencies as currency ON taxrow.p_currency = currency.PK " +
                "where  GETDATE() > taxrow.p_starttime and GETDATE() < taxrow.p_endtime " +
                "and taxes.p_code like '%CardFee%' or taxes.p_code like '%AdminFee%'";

        return this.jdbcTemplate.query(GET_ADMIN_FEES, new RowMapper<AdminFeesModel>() {
            @Override
            public AdminFeesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new AdminFeesModel(
                        rs.getString("p_code"),
                        rs.getString("p_passengertype"),
                        rs.getString("p_value"),
                        rs.getString("p_isocode"));
            }
        });
    }
}
