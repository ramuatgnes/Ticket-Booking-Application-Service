package com.ticketbooking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountNotFoundException extends RuntimeException {
    private static final long serialNumber = 987456789;
    private String message;
}
