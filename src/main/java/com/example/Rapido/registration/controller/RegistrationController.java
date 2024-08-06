package com.example.Rapido.registration.controller;

import com.example.Rapido.registration.service.RegistrationService;
import com.example.Rapido.registration.util.LoginDto;
import com.example.Rapido.registration.util.RegistrationDetailsDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    public RegistrationService service;

    @CrossOrigin
    @PostMapping("/UserRegistration")
    public ResponseEntity<String> registerUser(@ModelAttribute RegistrationDetailsDto registrationDetailsDto) throws IOException {
        return this.service.registerUser(registrationDetailsDto);
    }
    @CrossOrigin
    @PostMapping("driverRegistration")
    public ResponseEntity<String> registerDriver(@ModelAttribute RegistrationDetailsDto registrationDetailsDto) throws IOException {
        return this.service.registerDriver(registrationDetailsDto);
    }
    @CrossOrigin
    @PostMapping("/userLogin")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto, HttpServletResponse res)throws IOException {
        String response;
       String role=this.service.login(loginDto,res);
        if(role.equals("ROLE_USER")) {
            response="http://localhost:9696/indexPage";
            return ResponseEntity.ok(response);
        }
        else if(role.equals("ROLE_DRIVER")){
            response="http://localhost:9696/driverHome";
            return ResponseEntity.ok(response);
        }
        else{
            return ResponseEntity.ok("login");
        }
    }

}
