package com.ticketbooking.mapper.impl;

import com.ticketbooking.constants.Constants;
import com.ticketbooking.entity.Account;
import com.ticketbooking.mapper.AccountMapper;
import com.ticketbooking.request.SignUpRequest;
import com.ticketbooking.response.SendForgetPasswordCodeResponse;
import com.ticketbooking.response.SendVerificationResponse;
import com.ticketbooking.response.SignInResponse;
import com.ticketbooking.response.SignUpResponse;
import com.ticketbooking.utils.AppUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountMapperImpl implements AccountMapper {
    @Autowired
    ModelMapper mapper;

    @Override
    public Account signUpAccountToEntity(SignUpRequest request) {
        Account account = mapper.map(request, Account.class);
        account.setCreatedOn(AppUtils.getCurrentDateTime());
        account.setUpdatedOn(AppUtils.getCurrentDateTime());
        account.setVerificationStatus(Constants.ACCOUNT_VERIFICATION_PENDING);
        account.setVerificationCode(Constants.DEFAULT_ACCOUNT_VERIFICATION_CODE);

        return account;
    }

    @Override
    public SignUpResponse prepareSignUpResponse(Account account) {
        SignUpResponse response = new SignUpResponse();
        response.setAccountId(account.getAccountId());
        response.setFirstName(account.getFirstName());
        response.setLastName(account.getLastName());
        response.setEmail(account.getEmail());
        return response;
    }

    @Override
    public Account prepareVerificationCode(Account byEmail) {
        byEmail.setVerificationCode(AppUtils.generateRandomNumber(8));
        byEmail.setUpdatedOn(AppUtils.getCurrentDateTime());
        return byEmail;
    }

    @Override
    public SendVerificationResponse sendVerificationResponse(Account code) {
        SendVerificationResponse response = new SendVerificationResponse();
        response.setAccountId(code.getAccountId());
        response.setAccountType(code.getType());
        return response;
    }

    @Override
    public SendVerificationResponse prepareVerifyResponse(Account code) {
        SendVerificationResponse response = new SendVerificationResponse();
        response.setAccountId(code.getAccountId());
        response.setAccountType(code.getType());
        return response;
    }

    @Override
    public SignInResponse prepareSignInResponse(Account account) {
        SignInResponse response = new SignInResponse();
        response.setFisrtName(account.getFirstName());
        response.setLastName(account.getLastName());
        response.setEmail(account.getEmail());
        response.setType(account.getType());
        response.setVerificationStatus(account.getVerificationStatus());
        return response;
    }

    @Override
    public SendForgetPasswordCodeResponse prepareForgotPasswordResponse(Account account) {
        SendForgetPasswordCodeResponse response = new SendForgetPasswordCodeResponse();
        response.setEmail(account.getEmail());
        return response;
    }
}
