package com.ticketbooking.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class RegisterVehicleResponse implements Serializable {

    private String TransportType;

    private String vehicleNo;

    private String startFrom;

    private String endTo;

    private Date departureTime;

    private Date arrivalTime;

    private String distance;

    private List<String> noOfDay;

    private Float fair;

    private String totalSeat;
}
