package com.ticketbooking.mapper;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.request.UpdateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;
import com.ticketbooking.response.RemoveVehicleResponce;
import com.ticketbooking.response.UpadateVehicleResponce;

public interface TransportMapper {
    Transport vehicleRequestToEntity(CreateVehicleRequest request);

    RegisterVehicleResponse vehicleRegisterResponse(Transport request);

    RemoveVehicleResponce removeVehicleResponce(Transport byVehicleNo);

    Transport setUpdateToEntity(UpdateVehicleRequest request);

    UpadateVehicleResponce setUpdateResponce(Transport transport);
}
