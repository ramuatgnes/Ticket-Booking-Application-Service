package com.ticketbooking.mapper;

import com.ticketbooking.entity.ContactUs;
import com.ticketbooking.request.ContactUsRequest;
import com.ticketbooking.response.ContactUsResponse;

public interface PagesMapper {
    ContactUs createMessage(ContactUsRequest request);

    ContactUsResponse prepareContactUsResponse(ContactUs save);
}
