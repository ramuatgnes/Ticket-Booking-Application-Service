package com.ticketbooking.mapper.impl;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.mapper.TicketBookingMapper;
import com.ticketbooking.response.GetVehicleResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketBookingMapperImp implements TicketBookingMapper {
    @Autowired
    ModelMapper mapper;

    @Override
    public List<GetVehicleResponse> getVehicleResponce(List<Transport> list) {
        return list.stream()
                .map(data -> mapper.map(data, GetVehicleResponse.class))
                .collect(Collectors.toList());
    }

}
