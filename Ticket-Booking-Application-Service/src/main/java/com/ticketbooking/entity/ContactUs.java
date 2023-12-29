package com.ticketbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TicketBookingContactUs")
public class ContactUs {

    @Column
    private String name;
    @Id
    @Column
    private String email;
    @Column
    private String message;
}
