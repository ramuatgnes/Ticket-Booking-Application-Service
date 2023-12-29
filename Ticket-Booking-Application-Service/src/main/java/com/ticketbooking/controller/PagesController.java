package com.ticketbooking.controller;

import com.ticketbooking.request.ContactUsRequest;
import com.ticketbooking.response.ContactUsResponse;
import com.ticketbooking.service.PagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pages")
public class PagesController {

    @Autowired
    PagesService service;

    @PostMapping(path = "/contact-us")
    public ResponseEntity<ContactUsResponse> contactUsFormDetails(@RequestBody ContactUsRequest request) {
        return new ResponseEntity<>(service.contactUsFormDetails(request), HttpStatus.OK);
    }
}
