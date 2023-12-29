package com.ticketbooking.mapper.impl;

import com.ticketbooking.entity.ContactUs;
import com.ticketbooking.mapper.PagesMapper;
import com.ticketbooking.request.ContactUsRequest;
import com.ticketbooking.response.ContactUsResponse;
import org.springframework.stereotype.Service;

@Service
public class PagesMapperImpl implements PagesMapper {
    @Override
    public ContactUs createMessage(ContactUsRequest request) {
        ContactUs contactUs = new ContactUs();
        contactUs.setName(request.getName());
        contactUs.setEmail(request.getEmail());
        contactUs.setMessage(request.getMessage());
        return contactUs;
    }

    @Override
    public ContactUsResponse prepareContactUsResponse(ContactUs save) {
        ContactUsResponse response = new ContactUsResponse();
        response.setEmail(save.getEmail());
        return response;
    }
}
