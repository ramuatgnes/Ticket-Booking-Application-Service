package com.ticketbooking.service.impl;

import com.ticketbooking.constants.Constants;
import com.ticketbooking.constants.ErrorMessageConstant;
import com.ticketbooking.dbHelper.AccountDbHelper;
import com.ticketbooking.entity.Account;
import com.ticketbooking.exception.*;
import com.ticketbooking.helper.AccountHelper;
import com.ticketbooking.mapper.AccountMapper;
import com.ticketbooking.request.*;
import com.ticketbooking.response.SendForgetPasswordCodeResponse;
import com.ticketbooking.response.SendVerificationResponse;
import com.ticketbooking.response.SignInResponse;
import com.ticketbooking.response.SignUpResponse;
import com.ticketbooking.service.AccountService;
import com.ticketbooking.utils.AppUtils;
import com.ticketbooking.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    EmailService emailService;

    @Autowired
    private AccountDbHelper accountDbHelper;

    @Autowired
    private AccountHelper accountHelper;

    @Override
    public SignUpResponse signUpAccount(SignUpRequest request) {
        Account byEmail = accountDbHelper.findByEmail(request.getEmail());
        if (byEmail != null) {
            throw new AccountAlradyExistException(ErrorMessageConstant.USER_EMAIL_ALRADY_EXIST);
        }

        Account account = accountMapper.signUpAccountToEntity(request);
        if (account != null) {
            Account signUpAccount = accountDbHelper.signUpAccount(account);
            return accountMapper.prepareSignUpResponse(signUpAccount);
        } else {
            throw new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);
        }
    }

    @Override
    public SendVerificationResponse sendVerificationCode(String email) {
        Account byEmail = accountDbHelper.findByEmail(email);
        if (byEmail == null) {
            throw new AccountNotFoundException(ErrorMessageConstant.EMAILID_NOT_FOUND);
        }
        //sending the vairefication code
        Account account = accountMapper.prepareVerificationCode(byEmail);
        Account code = accountDbHelper.sendVerificationCode(account);
        emailService.sendSimpleMessage(code.getEmail(), "Your Verification Code is: ", code.getVerificationCode());
        //set vairefication code in database
        return accountMapper.sendVerificationResponse(code);
    }

    @Override
    public SendVerificationResponse verifyVerificationCode(Integer accountId, VerificationRequest request) {
         Account byId = accountDbHelper.findById(accountId).get();
        if (byId == null) {
            throw new DataNotFoundException(ErrorMessageConstant.ACCOUNT_DETAILS_NOT_FOUND);
        }
        if (byId.getVerificationCode().equals(request.getVerificationCode())) {
            byId.setVerificationStatus(Constants.ACCOUNT_VERIFICATION_VERIFIED);
            byId.setUpdatedOn(AppUtils.getCurrentDateTime());
            byId.setVerifyOn(AppUtils.getCurrentDateTime());

            Account code = accountDbHelper.verifyVerificationCode(byId);
            if (code != null) {

                emailService.sendSimpleMessage(code.getEmail(), "Your Account Verification Done", "Your Account Verification Done");
                return accountMapper.prepareVerifyResponse(code);
            } else {
                throw new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);
            }
        } else {
            throw new VerificationCodeMismatchException(ErrorMessageConstant.VERIFICATION_CODE_MISMATCH);
        }

    }

    @Override
    public SignInResponse signInAccount(SignInRequest signIn) {
        Account byEmail = accountDbHelper.findByEmail(signIn.getEmail());
        if (byEmail == null) {
            throw new AccountNotFoundException(ErrorMessageConstant.EMAILID_NOT_FOUND);
        }
        if (byEmail.getVerificationStatus().equals(Constants.ACCOUNT_VERIFICATION_VERIFIED)) {

            Account account = accountDbHelper.findByEmailAndPassword(byEmail.getEmail(), signIn.getPassword());
            if (account == null) {
                throw new IncorrectLoginCredential(ErrorMessageConstant.WRONG_EMAILID_OR_PASSWORD);
            }

            return accountMapper.prepareSignInResponse(account);
        } else {
            throw new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);
        }

    }

    @Override
    public SendForgetPasswordCodeResponse forgotPassword(String email) {
        Account byEmail = accountDbHelper.findByEmail(email);
        if (byEmail != null) {
            String resetToken = AppUtils.generateRandomNumber(8);
            byEmail.setResetToken(resetToken);
            accountHelper.CreateForgotPasswordURL(byEmail);
            Account account = accountDbHelper.updateAccount(byEmail);
            if (account != null) {
                return accountMapper.prepareForgotPasswordResponse(account);
            }
        } else {
            throw new AccountNotFoundException(ErrorMessageConstant.ACCOUNT_DETAILS_NOT_FOUND);
        }
        return null;
    }

    @Override
    public SignInResponse resetPassword(String resetToken, forgotPasswordRequest request) {
        Account byResetToken = accountDbHelper.findByResetToken(resetToken);
        if (byResetToken != null && byResetToken.getResetToken().equals(resetToken)) {
            byResetToken.setPassword(request.getPassword());
            byResetToken.setResetToken(null);
            Account account = accountDbHelper.updateAccount(byResetToken);
            if (account != null) {
                emailService.sendSimpleMessage(byResetToken.getEmail(), "Your Account Password Updated", "Your Account Password updated Done Successfully");
                return accountMapper.prepareSignInResponse(account);
            }
        } else {
            throw new DataNotFoundException(ErrorMessageConstant.ACCOUNT_DETAILS_NOT_FOUND);
        }
        return null;
    }

    @Override
    public SignInResponse changePassword(Integer accountId, ChangePasswordRequest request) {
        Account byId = accountDbHelper.findById(accountId).get();
        if (byId != null) {
            if (request.getOldPassword().equals(byId.getPassword())) {
                byId.setPassword(request.getPassword());
                Account account = accountDbHelper.updateAccount(byId);
                if (account != null) {
                    return accountMapper.prepareSignInResponse(account);
                }
            }else{
                throw new SomthingIsWorngException(ErrorMessageConstant.SOMETHING_WENT_WRONG);
            }
        }else{
            throw new AccountNotFoundException(ErrorMessageConstant.ACCOUNT_DETAILS_NOT_FOUND);
        }
        return null;
    }
}