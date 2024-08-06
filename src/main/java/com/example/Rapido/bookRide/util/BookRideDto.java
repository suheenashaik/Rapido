package com.example.Rapido.bookRide.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRideDto {
    public String bookRideId;
    public String userName;
    public String mobileNumber;
    public String pickUpLocation;
    public String dropOffLocation;
    public String pickUpDate;
}
