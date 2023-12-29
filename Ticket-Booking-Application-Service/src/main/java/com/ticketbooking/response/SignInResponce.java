package com.ticketbooking.response;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SignInResponce {

    private String userName;
    private String msg1="Wrong Your UserName or Password... ";
    private String msg2 = "Log In Sucessfull";

}
