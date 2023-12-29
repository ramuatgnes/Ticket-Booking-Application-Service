package com.ticketbooking.repository;

import com.ticketbooking.entity.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepository  extends JpaRepository<ContactUs, String> {
}
