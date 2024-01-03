package com.ticketbooking.service.impl;

import com.ticketbooking.constants.ErrorMessageConstant;
import com.ticketbooking.dbHelper.TanseportDbHelper;
import com.ticketbooking.entity.Transport;
import com.ticketbooking.exception.SomthingIsWorngException;
import com.ticketbooking.exception.VehicleAllredyExits;
import com.ticketbooking.mapper.TransportMapper;
import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;
import com.ticketbooking.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportServiceImp implements TransportService {
    @Autowired
    private TransportMapper transportMapper;
    @Autowired
    private TanseportDbHelper dbHelper;

    @Override
    public RegisterVehicleResponse registerVehicle(CreateVehicleRequest request) {
        Transport byVehicleNo = dbHelper.findByVehicleNo(request.getVehicleNo());
        if (byVehicleNo != null) {
            throw new VehicleAllredyExits(ErrorMessageConstant.VEHICLE_ALREADY_EXITS);
        }

        Transport transport = transportMapper.vehicleRequestToEntity(request);
        if (transport != null) {
            Transport vehicle = dbHelper.registerVehicle(transport);
            return transportMapper.vehicleRegisterResponse(vehicle);
        } else {
            throw new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);
        }
    }
}
