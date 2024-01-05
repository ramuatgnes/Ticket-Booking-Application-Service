package com.ticketbooking.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UpadateVehicleResponce {

    private String vehicleNo;

    private String startFrom;

    private String endTo;

    private Date departureTime;

    private Date arrivalTime;

    private List<String> noOfDay;

    private Float fair;

    private String totalSeat;
}
