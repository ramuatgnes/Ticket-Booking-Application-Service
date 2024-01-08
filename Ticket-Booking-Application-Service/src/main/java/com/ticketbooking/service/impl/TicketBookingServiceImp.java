package com.ticketbooking.service.impl;

import com.ticketbooking.constants.ErrorMessageConstant;
import com.ticketbooking.dbHelper.TickeBookingDbHelper;
import com.ticketbooking.entity.Transport;
import com.ticketbooking.exception.NoTravelsAvaileble;
import com.ticketbooking.mapper.TicketBookingMapper;
import com.ticketbooking.response.GetVehicleResponse;
import com.ticketbooking.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketBookingServiceImp implements TicketBookingService {
    @Autowired
    TickeBookingDbHelper dbHelper;
    @Autowired
    TicketBookingMapper bookingMapper;

    @Override
    public List<GetVehicleResponse> getAllVehicle(String startFrom, String endTo) {
        List<Transport> list = dbHelper.getVehicleByStartFromAndEndTo(startFrom, endTo);
        if (list == null) {
            throw new NoTravelsAvaileble(ErrorMessageConstant.THERE_IS_NO_TRAVAILS_AVAILABLE);
        }
        return bookingMapper.getVehicleResponce(list);
    }

}
