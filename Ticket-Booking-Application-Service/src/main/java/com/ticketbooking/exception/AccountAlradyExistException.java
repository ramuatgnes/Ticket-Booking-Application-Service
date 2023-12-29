package com.ticketbooking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountAlradyExistException extends RuntimeException {

    private static final long serialNumber = 898565554;
    private String message;

}
