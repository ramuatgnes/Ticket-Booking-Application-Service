package com.ticketbooking.controller;

import com.ticketbooking.response.GetVehicleResponse;
import com.ticketbooking.service.TicketBookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ticket")
public class TicketBookingController {
    @Autowired
    TicketBookingService service;

    @GetMapping(path = "/search-ticket/{startTo}/{endTo}")
    public ResponseEntity<List<GetVehicleResponse>> getAllVehicle(@Valid @PathVariable String startTo, @PathVariable String endTo){
        return new ResponseEntity<>(service.getAllVehicle(startTo,endTo), HttpStatus.OK);
    }

}
