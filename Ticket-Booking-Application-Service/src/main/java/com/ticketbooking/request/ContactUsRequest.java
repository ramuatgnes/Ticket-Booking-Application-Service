package com.ticketbooking.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContactUsRequest {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String message;
}
