package com.example.Rapido.bookRide.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BookRide")
public class BookRide {
    @Id
    private String bookRideId;
    private String userName;
    private String mobileNumber;
    private String pickUpLocation;
    private String dropOffLocation;
    private String pickUpDate;
}
