package com.ticketbooking.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountUpdateRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}
