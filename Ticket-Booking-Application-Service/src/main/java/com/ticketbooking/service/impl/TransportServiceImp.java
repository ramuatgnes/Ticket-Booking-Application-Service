package com.ticketbooking.service.impl;

import com.ticketbooking.constants.ErrorMessageConstant;
import com.ticketbooking.dbHelper.TanseportDbHelper;
import com.ticketbooking.entity.Transport;
import com.ticketbooking.exception.SomthingIsWorngException;
import com.ticketbooking.exception.VehicleAllredyExits;
import com.ticketbooking.exception.VehicleNotExitsException;
import com.ticketbooking.mapper.TransportMapper;
import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.request.UpdateVehicleRequest;
import com.ticketbooking.response.*;
import com.ticketbooking.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImp implements TransportService {
    @Autowired
    private TransportMapper transportMapper;
    @Autowired
    private TanseportDbHelper dbHelper;

    @Override
    public RegisterVehicleResponse registerVehicle(CreateVehicleRequest request) {
        System.out.println(request);
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

    @Override
    public RemoveVehicleResponce removeVehicle(String vehicleNumber) {
        Transport byVehicleNo = dbHelper.findByVehicleNo(vehicleNumber);
        if (byVehicleNo == null) {
            throw new VehicleNotExitsException(ErrorMessageConstant.VEHICLE_NOT_EXITS);
        }
        boolean removed = dbHelper.removeVehicleByNumber(vehicleNumber);
        if (removed) {
            return transportMapper.removeVehicleResponce(byVehicleNo);
        } else
            new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);

        return null;
    }

    @Override
    public UpadateVehicleResponce updateVehicle(UpdateVehicleRequest request) {
        Transport byVehicleNo = dbHelper.findByVehicleNo(request.getVehicleNo());
        if (byVehicleNo == null) {
            throw new VehicleNotExitsException(ErrorMessageConstant.VEHICLE_NOT_EXITS);
        }
        Transport transport = transportMapper.setUpdateToEntity(request);
        if (transport != null) {
            if (dbHelper.saveUpdateVehicle(transport) != null) {
                return transportMapper.setUpdateResponce(transport);
            }
        }
        throw new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);
    }

    @Override
    public GetVehicleResponse getVehicleByNumber(String vehicleNumber) {
        Transport byVehicleNo = dbHelper.findByVehicleNo(vehicleNumber);
        if (byVehicleNo != null) {
            transportMapper.getVehicleByNumber(byVehicleNo);
        } else {
            throw new VehicleNotExitsException(ErrorMessageConstant.VEHICLE_NOT_EXITS);
        }
        throw new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);
    }

    @Override
    public List<GetVehicleResponse> getAllVehivle() {
        List<Transport> allVehicleData = dbHelper.getAllVehicleData();
        if (allVehicleData == null) {
            throw new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);
        }
        return transportMapper.getAllVehicleResponse(allVehicleData);

    }
}
