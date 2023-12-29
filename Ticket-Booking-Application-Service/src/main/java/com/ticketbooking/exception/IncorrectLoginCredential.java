package com.ticketbooking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IncorrectLoginCredential extends RuntimeException {
    private static final long serialNumber = 234567886;
    private String message;
}
