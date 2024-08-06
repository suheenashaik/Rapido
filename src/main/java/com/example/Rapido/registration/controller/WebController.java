package com.example.Rapido.registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebController {
    @CrossOrigin
    @GetMapping("/indexPage")
    public String showIndexPage() {
        return "indexPage";
    }

    @CrossOrigin
    @GetMapping("/driverHome")
    public String showDriverHome( ) {
        return "DriverHome";
    }
    @CrossOrigin
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    @CrossOrigin
    @GetMapping("/home")
    public String showHome() {
        return "HomePage";
    }
    @CrossOrigin
    @GetMapping("/userRegistration")
    public String showUserRegistration() {
        return "UserRegistration";
    }
    @CrossOrigin
    @GetMapping("/driverRegistration")
    public String showDriverRegistration() {
        return "DriverRegistration";
    }
    @CrossOrigin
    @GetMapping("/help")
    public String showHelp() {
        return "HelpPage";
    }
    @CrossOrigin
    @GetMapping("/notification")
    public String showNotification() {
        return "notifications";
    }
    @CrossOrigin
    @GetMapping("/waitingForBike")
    public String showWaitingTime() {
        return "waitingForBike";
    }
    @CrossOrigin
    @GetMapping("/ridingStart")
    public String showRidingStart() {
        return "ridingStart";
    }
    @CrossOrigin
    @GetMapping("/ridingEnd")
    public String showRidingEnd() {
        return "rideEnd";
    }
    @CrossOrigin
    @GetMapping("/driverStarted")
    public String showDriverStarted() {
        return "DriverStarted";
    }
}

