package com.ticketbooking.controller;

import com.ticketbooking.request.CreateVehicleRequest;
import com.ticketbooking.request.UpdateVehicleRequest;
import com.ticketbooking.response.*;
import com.ticketbooking.service.TransportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transport")
public class TransportController {
    @Autowired
    private TransportService service;

    @PostMapping(path = "/register-vehicle")
    public ResponseEntity<RegisterVehicleResponse> registerVehicle(@Valid @RequestBody CreateVehicleRequest request) {
        return new ResponseEntity<>(service.registerVehicle(request), HttpStatus.OK);
    }

    //to remove the Vehicle mail Update Vehicle is deleted To booked User...
    @DeleteMapping(path = "/remove-vehicle/{vehicleNumber}")
    public ResponseEntity<RemoveVehicleResponce> removeVehicle(@Valid @PathVariable String vehicleNumber) {
        return new ResponseEntity<>(service.removeVehicle(vehicleNumber), HttpStatus.OK);
    }

    //Update Request & sending mail Update Vehicle To booked User...
    @PutMapping(path = "/update-vehicle")
    public ResponseEntity<UpadateVehicleResponce> updateVehicle(@Valid @RequestBody UpdateVehicleRequest request) {
        return new ResponseEntity<>(service.updateVehicle(request), HttpStatus.OK);
    }

    @PostMapping(path = "/get-byVehicleNumber/{vehicleNumber}")
    public ResponseEntity<GetVehicleResponse> getVehicleByNumber(@Valid @PathVariable String vehicleNumber) {
        return new ResponseEntity<GetVehicleResponse>(service.getVehicleByNumber(vehicleNumber), HttpStatus.OK);
    }

    @GetMapping(path = "/get-allVehicle")
    public ResponseEntity<List<GetVehicleResponse>> getAllVehicle() {
        return new ResponseEntity<>(service.getAllVehivle(), HttpStatus.OK);
    }

}
