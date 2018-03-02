package com.api.example.database.example.models;

import lombok.Data;

/**
 * Created by dwebb on 12/2/2016.
 */
@Data
public class CustomerModel {

    private String uid;
    private String customerid;
    private String status;
    private String employeeid;
    private String title;
    private String firstname;
    private String lastname;
    private String email;
    private String postalcode;
    private String country;
    private String town;
    private String ejplusnumber;
    private String flightclubnumber;

    public CustomerModel(String uid,String customerid, String status, String employeeid, String title, String firstname, String lastname, String ejplusnumber, String flightclubnumber,String postalcode,String town,String country) {
        this.uid=uid;
        this.customerid = customerid;
        this.status = status;
        this.employeeid = employeeid;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ejplusnumber = ejplusnumber;
        this.flightclubnumber = flightclubnumber;
        this.postalcode=postalcode;
        this.town=town;
        this.country=country;
    }

    public CustomerModel(String uid, String p_customerid) {
        this.customerid = customerid;
    }
}



