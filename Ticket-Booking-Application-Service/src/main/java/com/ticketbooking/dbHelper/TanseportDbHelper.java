package com.ticketbooking.dbHelper;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.repository.TanseportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TanseportDbHelper {
    @Autowired
    private TanseportRepository repository;

    public Transport registerVehicle(Transport transport) {
        return repository.save(transport);
    }

    public Transport findByVehicleNo(String vehicleNo) {
        return repository.findByVehicleNo(vehicleNo);
    }


    public boolean removeVehicleByNumber(String vehicleNumber) {
        Transport byVehicleNo = repository.findByVehicleNo(vehicleNumber);
        if (byVehicleNo != null) {
            repository.delete(byVehicleNo);
            return true;
        } else {
            return false;
        }
    }

    public Transport saveUpdateVehicle(Transport transport) {
        Transport updateVehicle = repository.save(transport);
        return updateVehicle;
    }

    public List<Transport> getAllVehicleData() {
        return repository.findAll();
    }
}
