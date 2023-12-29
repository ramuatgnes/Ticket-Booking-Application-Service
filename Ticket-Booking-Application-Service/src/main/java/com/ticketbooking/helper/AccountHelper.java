package com.ticketbooking.helper;

import com.ticketbooking.entity.Account;
import com.ticketbooking.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountHelper {

    @Autowired
    EmailService emailService;

    public void CreateForgotPasswordURL(Account byEmail) {
        String forgotURL = "http://localhost:4200/reset-password/" + byEmail.getResetToken();
        emailService.sendSimpleMessage(byEmail.getEmail(), "Reset Password Link", forgotURL);
    }
}
