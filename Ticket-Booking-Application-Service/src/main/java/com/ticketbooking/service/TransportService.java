package com.ticketbooking.service;

import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.request.UpdateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;
import com.ticketbooking.response.RemoveVehicleResponce;
import com.ticketbooking.response.UpadateVehicleResponce;

public interface TransportService {
    RegisterVehicleResponse registerVehicle(CreateVehicleRequest request);

    RemoveVehicleResponce removeVehicle(String vehicleNumber);

    UpadateVehicleResponce updateVehicle(UpdateVehicleRequest request);
}
