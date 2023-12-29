package com.ticketbooking.response;
import lombok.Data;

@Data
public class SendVerificationResponse {

    private  Integer accountId;
    private String accountType;
}
