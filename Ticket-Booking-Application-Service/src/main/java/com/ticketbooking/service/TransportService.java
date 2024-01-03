package com.ticketbooking.service;

import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;

public interface TransportService {
    RegisterVehicleResponse registerVehicle(CreateVehicleRequest request);
}
