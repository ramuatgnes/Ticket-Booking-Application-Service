package com.ticketbooking.mapper.impl;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.mapper.TransportMapper;
import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportMapperImp implements TransportMapper {
    @Autowired
    ModelMapper mapper;

    @Override
    public Transport vehicleRequestToEntity(CreateVehicleRequest request) {
         return mapper.map(request, Transport.class);
    }

    public RegisterVehicleResponse vehicleRegisterResponse(Transport request) {
         return mapper.map(request,RegisterVehicleResponse.class);
    }
}