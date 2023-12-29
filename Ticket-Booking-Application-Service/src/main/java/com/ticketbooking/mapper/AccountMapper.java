package com.ticketbooking.mapper;

import com.ticketbooking.entity.Account;
import com.ticketbooking.request.SignUpRequest;
import com.ticketbooking.response.SendForgetPasswordCodeResponse;
import com.ticketbooking.response.SendVerificationResponse;
import com.ticketbooking.response.SignInResponse;
import com.ticketbooking.response.SignUpResponse;

public interface AccountMapper {

    public Account signUpAccountToEntity(SignUpRequest request);

    public SignUpResponse prepareSignUpResponse(Account account);

    public Account prepareVerificationCode(Account byEmail);

    public SendVerificationResponse sendVerificationResponse(Account code);

    public SendVerificationResponse prepareVerifyResponse(Account code);

    SignInResponse prepareSignInResponse(Account account);

    SendForgetPasswordCodeResponse prepareForgotPasswordResponse(Account account);
}
