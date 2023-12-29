package com.ticketbooking.dbHelper;

import com.ticketbooking.entity.ContactUs;
import com.ticketbooking.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContactUsDBHelper {
    @Autowired
    ContactUsRepository repository;

    public Optional<ContactUs> findByEmail(String lowerCase) {
        return repository.findById(lowerCase);
    }

    public ContactUs save(ContactUs message) {
        return repository.save(message);
    }
}
