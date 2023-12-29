package com.ticketbooking.service.impl;

import com.ticketbooking.dbHelper.ContactUsDBHelper;
import com.ticketbooking.entity.ContactUs;
import com.ticketbooking.mapper.PagesMapper;
import com.ticketbooking.request.ContactUsRequest;
import com.ticketbooking.response.ContactUsResponse;
import com.ticketbooking.service.PagesService;
import com.ticketbooking.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagesServiceImpl implements PagesService {
    @Autowired
    ContactUsDBHelper contactUsDBHelper;

    @Autowired
    PagesMapper mapper;

    @Autowired
    EmailService emailService;

    @Override
    public ContactUsResponse contactUsFormDetails(ContactUsRequest request) {
        if (request != null) {
            ContactUs message = mapper.createMessage(request);
            ContactUs save = contactUsDBHelper.save(message);
            if (save != null) {
                String matter = "Name : " + save.getName() + "\n" +
                        "Email :" + save.getEmail() + "\n" +
                        "Message : " + save.getMessage();
                emailService.sendSimpleMessage("torameshwarsingh@gmail.com", "Contact-Us-Query", matter);
                return mapper.prepareContactUsResponse(save);
            }
        }
        return null;
    }
}