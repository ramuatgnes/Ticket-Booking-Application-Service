package com.ticketbooking.service;

import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;
import com.ticketbooking.response.RemoveVehicleResponce;

public interface TransportService {
    RegisterVehicleResponse registerVehicle(CreateVehicleRequest request);

    RemoveVehicleResponce removeVehicle(String vehicleNumber);
}
