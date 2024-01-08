package com.ticketbooking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NoTravelsAvaileble extends RuntimeException {

    public static final Long serialNumber = 876545678l;
    public String massage;

}
