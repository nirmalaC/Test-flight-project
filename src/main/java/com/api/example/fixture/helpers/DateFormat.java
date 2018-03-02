package com.api.example.fixture.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dwebb on 11/16/2016.
 */
public class DateFormat {

    private Date _date;

    public String AsUK() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(_date);
    }

    public String AsYearMonthDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(_date);
    }

    public DateFormat Today() {
        _date = new Date();
        return this;
    }

    public DateFormat WithDate(String date) throws Exception
    {
        SimpleDateFormat df = new SimpleDateFormat("E dd-MMM-yyyy HH-mm-ss");
        Date startDate;
        try {
            _date = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }

}
