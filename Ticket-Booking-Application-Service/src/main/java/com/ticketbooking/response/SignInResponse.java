package com.ticketbooking.response;
import lombok.Data;

@Data
public class SignInResponse {

    private String fisrtName;

    private String lastName;

    private String email;

    private String type;

    private String verificationStatus;
}
