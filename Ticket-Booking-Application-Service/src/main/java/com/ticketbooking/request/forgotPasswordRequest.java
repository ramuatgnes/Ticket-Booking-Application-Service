package com.ticketbooking.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class forgotPasswordRequest {

    @NotNull
    private String password;

}
