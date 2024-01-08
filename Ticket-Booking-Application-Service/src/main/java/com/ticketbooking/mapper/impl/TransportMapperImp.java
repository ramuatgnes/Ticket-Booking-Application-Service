package com.ticketbooking.mapper.impl;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.mapper.TransportMapper;
import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.request.UpdateVehicleRequest;
import com.ticketbooking.response.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportMapperImp implements TransportMapper {
    @Autowired
    ModelMapper mapper;

    @Override
    public GetVehicleResponse getVehicleByNumber(Transport byVehicleNo) {
        return mapper.map(byVehicleNo, GetVehicleResponse.class);
    }

    @Override
    public List<GetVehicleResponse> getAllVehicleResponse(List<Transport> list) {
        return list.stream()
                .map(data -> mapper.map(data, GetVehicleResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Transport vehicleRequestToEntity(CreateVehicleRequest request) {
        return mapper.map(request, Transport.class);
    }

    public RegisterVehicleResponse vehicleRegisterResponse(Transport request) {
        return mapper.map(request, RegisterVehicleResponse.class);
    }

    @Override
    public RemoveVehicleResponce removeVehicleResponce(Transport byVehicleNo) {
        RemoveVehicleResponce responce = new RemoveVehicleResponce();
        responce.setTransportType(byVehicleNo.getTransportType());
        responce.setVehicleNo(byVehicleNo.getVehicleNo());
        return responce;
    }

    @Override
    public Transport setUpdateToEntity(UpdateVehicleRequest request) {
        Transport transport = new Transport();
        transport.setStartFrom(request.getStartFrom());
        transport.setEndTo(request.getEndTo());
        transport.setDepartureTime(request.getDepartureTime());
        transport.setArrivalTime(request.getArrivalTime());
        transport.setNoOfDay(request.getNoOfDay());
        transport.setFair(request.getFair());
        transport.setTotalSeat(request.getTotalSeat());
        return transport;
    }

    @Override
    public UpadateVehicleResponce setUpdateResponce(Transport transport) {
        UpadateVehicleResponce responce = new UpadateVehicleResponce();
        responce.setVehicleNo(transport.getVehicleNo());
        responce.setStartFrom(transport.getStartFrom());
        responce.setEndTo(transport.getEndTo());
        responce.setDepartureTime(transport.getDepartureTime());
        responce.setArrivalTime(transport.getArrivalTime());
        responce.setNoOfDay(transport.getNoOfDay());
        responce.setFair(transport.getFair());
        responce.setTotalSeat(transport.getTotalSeat());
        return responce;
    }
}
