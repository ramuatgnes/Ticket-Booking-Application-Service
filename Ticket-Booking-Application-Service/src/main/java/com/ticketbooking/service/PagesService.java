package com.ticketbooking.service;

import com.ticketbooking.request.ContactUsRequest;
import com.ticketbooking.response.ContactUsResponse;

public interface PagesService {
    ContactUsResponse contactUsFormDetails(ContactUsRequest request);
}
