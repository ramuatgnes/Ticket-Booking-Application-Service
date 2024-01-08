package com.ticketbooking.dbHelper;

import com.ticketbooking.entity.Transport;
import com.ticketbooking.repository.TanseportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickeBookingDbHelper {
    @Autowired
    private TanseportRepository repository;


    public List<Transport> getVehicleByStartFromAndEndTo(String startFrom, String endTo) {
        return repository.findByStartFromAndEndTo(startFrom, endTo);
    }
}
