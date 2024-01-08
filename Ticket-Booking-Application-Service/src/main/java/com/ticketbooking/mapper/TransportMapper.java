package com.ticketbooking.mapper;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.request.UpdateVehicleRequest;
import com.ticketbooking.response.*;

import java.util.List;

public interface TransportMapper {
    Transport vehicleRequestToEntity(CreateVehicleRequest request);

    RegisterVehicleResponse vehicleRegisterResponse(Transport request);

    RemoveVehicleResponce removeVehicleResponce(Transport byVehicleNo);

    Transport setUpdateToEntity(UpdateVehicleRequest request);

    UpadateVehicleResponce setUpdateResponce(Transport transport);

    GetVehicleResponse getVehicleByNumber(Transport byVehicleNo);

   List<GetVehicleResponse> getAllVehicleResponse(List<Transport> allVehicleDataList);
}
