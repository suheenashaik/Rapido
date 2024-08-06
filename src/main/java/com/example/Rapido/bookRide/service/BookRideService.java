package com.example.Rapido.bookRide.service;

import com.example.Rapido.bookRide.entity.BookRide;
import com.example.Rapido.bookRide.repository.BookRideRepository;
import com.example.Rapido.bookRide.util.BookRideDto;
import com.example.Rapido.registration.entity.UserRegistrationDetails;
import com.example.Rapido.registration.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class BookRideService {
    @Autowired
    private BookRideRepository bookRideRepository;
    @Autowired
    private UserRegistrationRepository registrationRepository;

    public ResponseEntity<String> bookRide(BookRideDto dto) {

            Optional<UserRegistrationDetails> mobile = this.registrationRepository.findByMobileNumber(dto.getMobileNumber());
            if (mobile.isPresent()) {
                BookRide bookRide = new BookRide();
                bookRide.setBookRideId(UUID.randomUUID().toString());
                bookRide.setUserName(dto.getUserName());
                bookRide.setMobileNumber(dto.getMobileNumber());
                bookRide.setPickUpLocation(dto.getPickUpLocation());
                bookRide.setDropOffLocation(dto.getDropOffLocation());
                bookRide.setPickUpDate(dto.getPickUpDate());
                this.bookRideRepository.save(bookRide);
                return ResponseEntity.ok("Book Ride created");
            }
            return ResponseEntity.ok("Mobile number not found");
    }

}
