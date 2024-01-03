package com.ticketbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Ticket_Booking_Transport")
public class Transport {

    @Column
    private  String TransportType;

    @Id
    @Column
    private String vehicleNo;

    @Column
    private String startFrom;

    @Column
    private String endTo;

    @Column
    private Date departureTime;

    @Column
    private Date arrivalTime;

    @Column
    private String distance;

    @Column
    private List<String> noOfDay;

    @Column
    private Float fair;

    @Column
    private String totalSeat;
}
