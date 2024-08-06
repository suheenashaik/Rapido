package com.example.Rapido.bookRide.controller;

import com.example.Rapido.bookRide.service.BookRideService;
import com.example.Rapido.bookRide.util.BookRideDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ride")
public class BookRideController {

    @Autowired
    private BookRideService bookRideService;

    @CrossOrigin
    @PostMapping("/bookRide")
    public ResponseEntity<String> bookRide(@RequestBody BookRideDto dto){
        return this.bookRideService.bookRide(dto);
    }
}
