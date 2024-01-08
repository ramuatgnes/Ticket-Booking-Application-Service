package com.ticketbooking.service;

import com.ticketbooking.response.GetVehicleResponse;

import java.util.List;

public interface TicketBookingService {
    List<GetVehicleResponse> getAllVehicle(String startTo, String endTo);
}
