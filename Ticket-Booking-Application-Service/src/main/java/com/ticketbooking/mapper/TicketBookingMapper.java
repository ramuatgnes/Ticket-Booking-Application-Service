package com.ticketbooking.mapper;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.response.GetVehicleResponse;

import java.util.List;

public interface TicketBookingMapper {
    List<GetVehicleResponse> getVehicleResponce(List<Transport> vehicleByStartFromAndEndTo);
}

