package com.ticketbooking.service;

import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.request.UpdateVehicleRequest;
import com.ticketbooking.response.*;

import java.util.List;

public interface TransportService {
    RegisterVehicleResponse registerVehicle(CreateVehicleRequest request);

    RemoveVehicleResponce removeVehicle(String vehicleNumber);

    UpadateVehicleResponce updateVehicle(UpdateVehicleRequest request);

    GetVehicleResponse getVehicleByNumber(String vehicleNumber);

    List<GetVehicleResponse> getAllVehivle();
}
