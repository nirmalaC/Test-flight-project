package com.api.example.database.example.models;

import lombok.Data;
import lombok.ToString;

/**
 * Created by daniel on 23/11/2016.
 */
@Data
@ToString
public class ExampleFlightDbModel {
    private String flightKey;
    private String localDepartureDate;
    private String arrivalTime;
    private String originTerminal;
    private String destinationTerminal;
    private String status;
    private String updatedDepartureTime;
    private String active;
    private String p_scheduleddeptime;
    private String scheduledArrivalTime;
    private String plannedDepartureTime;
    private String plannedArrivalTime;
    private String route;
    private String departs;
    private String arrives;
    private String currency;

    public ExampleFlightDbModel(String flightKey, String localDepartureDate, String arrivalTime, String originTerminal, String destinationTerminal,
                                String status, String updatedDepartureTime, String active, String p_scheduleddeptime, String scheduledArrivalTime, String plannedDepartureTime,
                                String plannedArrivalTime, String route, String departs, String arrives, String currency) {
        this.flightKey = flightKey;
        this.localDepartureDate = localDepartureDate;
        this.arrivalTime = arrivalTime;
        this.originTerminal = originTerminal;
        this.destinationTerminal = destinationTerminal;
        this.status = status;
        this.updatedDepartureTime = updatedDepartureTime;
        this.active = active;
        this.p_scheduleddeptime = p_scheduleddeptime;
        this.scheduledArrivalTime = scheduledArrivalTime;
        this.plannedDepartureTime = plannedDepartureTime;
        this.plannedArrivalTime = plannedArrivalTime;
        this.route = route;
        this.departs = departs;
        this.arrives = arrives;
        this.currency = currency;
    }
}
