package com.ticketbooking.mapper;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;
import com.ticketbooking.response.RemoveVehicleResponce;

public interface TransportMapper {
    Transport vehicleRequestToEntity(CreateVehicleRequest request);

    RegisterVehicleResponse vehicleRegisterResponse(Transport request);

    RemoveVehicleResponce removeVehicleResponce(Transport byVehicleNo);
}
