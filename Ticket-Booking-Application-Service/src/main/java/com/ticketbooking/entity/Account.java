package com.ticketbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "TicketBookingAccount")
public class Account {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer accountId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String type;
    @Column
    private String password;
    @Column
    private String verificationCode;
    @Column
    private String resetToken;
    @Column
    private String verificationStatus;
    @Column
    private Date verifyOn;
    @Column
    private Date createdOn;
    @Column
    private Date updatedOn;
}
