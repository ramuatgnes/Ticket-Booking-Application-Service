package com.ticketbooking.controller;

import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.request.UpdateVehicleRequest;
import com.ticketbooking.response.RegisterVehicleResponse;
import com.ticketbooking.response.RemoveVehicleResponce;
import com.ticketbooking.response.UpadateVehicleResponce;
import com.ticketbooking.service.TransportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transport")
public class TransportController {
    @Autowired
    private TransportService service;

    @PostMapping(path = "/register-vehicle")
    public ResponseEntity<RegisterVehicleResponse> registerVehicle(@Valid @RequestBody CreateVehicleRequest request) {
        return new ResponseEntity<RegisterVehicleResponse>(service.registerVehicle(request), HttpStatus.OK);
    }

    //to remove the Vehicle mail Update Vehicle is deleted To booked User...
    @DeleteMapping(path = "/remove-vehicle/{vehicleNumber}")
    public ResponseEntity<RemoveVehicleResponce> removeVehicle(@PathVariable String vehicleNumber) {
        return new ResponseEntity<RemoveVehicleResponce>(service.removeVehicle(vehicleNumber), HttpStatus.OK);
    }

    //Update Request & sending mail Update Vehicle To booked User...
    @PutMapping(path = "update-vehicle")
    public ResponseEntity<UpadateVehicleResponce> upadateVehicle(@RequestBody UpdateVehicleRequest request) {
        return new ResponseEntity<UpadateVehicleResponce>(service.updateVehicle(request), HttpStatus.OK);
    }
}
