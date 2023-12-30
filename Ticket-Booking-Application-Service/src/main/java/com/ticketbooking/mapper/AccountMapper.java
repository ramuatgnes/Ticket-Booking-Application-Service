package com.ticketbooking.mapper;

import com.ticketbooking.entity.Account;
import com.ticketbooking.request.AccountUpdateRequest;
import com.ticketbooking.request.SignUpRequest;
import com.ticketbooking.response.*;

public interface AccountMapper {

    public Account signUpAccountToEntity(SignUpRequest request);

    public SignUpResponse prepareSignUpResponse(Account account);

    public Account prepareVerificationCode(Account byEmail);

    public SendVerificationResponse sendVerificationResponse(Account code);

    public SendVerificationResponse prepareVerifyResponse(Account code);

    SignInResponse prepareSignInResponse(Account account);

    SendForgetPasswordCodeResponse prepareForgotPasswordResponse(Account account);

    Account updateAccount(Account byEmail, AccountUpdateRequest request);

    AccountUpdateResponse updateResponse(Account updateAccount);
}
