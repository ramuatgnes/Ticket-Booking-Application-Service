package com.ticketbooking.response;
import lombok.Data;

@Data
public class SignUpResponse {

    private Integer accountId;

    private String firstName;

    private String lastName;

    private String email;


}
