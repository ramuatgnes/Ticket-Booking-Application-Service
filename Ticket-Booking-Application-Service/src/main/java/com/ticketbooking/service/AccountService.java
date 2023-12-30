package com.ticketbooking.service;

import com.ticketbooking.request.*;
import com.ticketbooking.response.*;

public interface AccountService {

    SignUpResponse signUpAccount(SignUpRequest request);

    public SendVerificationResponse sendVerificationCode(String email);

    public SendVerificationResponse verifyVerificationCode(Integer accountId, VerificationRequest request);

    public SignInResponse signInAccount(SignInRequest signIn);

    SendForgetPasswordCodeResponse forgotPassword(String email);

    SignInResponse resetPassword(String resetToken, forgotPasswordRequest request);

    SignInResponse changePassword(Integer accountId, ChangePasswordRequest request);

    SignInResponse getByEmail(String email);

    AccountUpdateResponse updateAccount(String email, AccountUpdateRequest request);
}
