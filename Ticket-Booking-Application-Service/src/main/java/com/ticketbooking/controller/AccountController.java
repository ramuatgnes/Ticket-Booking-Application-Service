package com.ticketbooking.controller;

import com.ticketbooking.request.*;
import com.ticketbooking.response.SendForgetPasswordCodeResponse;
import com.ticketbooking.response.SendVerificationResponse;
import com.ticketbooking.response.SignInResponse;
import com.ticketbooking.response.SignUpResponse;
import com.ticketbooking.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping(path = "/sign-up")
    public ResponseEntity<SignUpResponse> singnUpAccount(@Valid @RequestBody SignUpRequest request) {
        return new ResponseEntity<>(service.signUpAccount(request), HttpStatus.OK);
    }

    @PostMapping(path = "/send-verification-code/{email}")
    public ResponseEntity<SendVerificationResponse> sendVerificationCode(@PathVariable(name = "email") String email) {
        return new ResponseEntity<SendVerificationResponse>(service.sendVerificationCode(email), HttpStatus.OK);
    }

    @PostMapping(path = "/verify-code/{accountId}")
    public ResponseEntity<SendVerificationResponse> verifyVerificationCode
            (@PathVariable(name = "accountId") Integer accountId, @RequestBody VerificationRequest request) {
        return new ResponseEntity<SendVerificationResponse>(service.verifyVerificationCode(accountId, request), HttpStatus.OK);
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<SignInResponse> signInAccount(@RequestBody SignInRequest signIn) {
        return new ResponseEntity<SignInResponse>(service.signInAccount(signIn), HttpStatus.OK);
    }

    @PostMapping(path = "/forget-password/{email}")

    public ResponseEntity<SendForgetPasswordCodeResponse> forgotPassword(@PathVariable(name = "email") String email) {
        return new ResponseEntity<SendForgetPasswordCodeResponse>(service.forgotPassword(email), HttpStatus.OK);
    }

    @PutMapping(path = "/reset-password/token/{resetToken}")
    public ResponseEntity<SignInResponse> resetPassword(@PathVariable String resetToken, @RequestBody forgotPasswordRequest request
    ) {
        return new ResponseEntity<>(service.resetPassword(resetToken, request), HttpStatus.OK);
    }

    @PostMapping(path = "change-password/{accountId}")
    public ResponseEntity<SignInResponse> chengePassword(@PathVariable Integer accountId, @RequestBody ChangePasswordRequest request) {
        return new ResponseEntity<>(service.changePassword(accountId, request), HttpStatus.OK);
    }


}
