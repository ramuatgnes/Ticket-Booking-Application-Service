package com.ticketbooking.controller;

import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;
import com.ticketbooking.service.TransportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transport")
public class TransportController {
    @Autowired
    private TransportService service;
    @PostMapping(path = "/register-vehicle")
    public ResponseEntity<RegisterVehicleResponse> registerVehicle(@Valid @RequestBody CreateVehicleRequest request){
        return new ResponseEntity<RegisterVehicleResponse>(service.registerVehicle(request), HttpStatus.OK);
    }
}
