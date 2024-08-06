package com.example.Rapido.registration.service;

import com.example.Rapido.registration.entity.DriverRegistrationDetails;
import com.example.Rapido.registration.entity.UserRegistrationDetails;
import com.example.Rapido.registration.repository.DriverRegistrationRepository;
import com.example.Rapido.registration.repository.UserRegistrationRepository;
import com.example.Rapido.registration.util.LoginDto;
import com.example.Rapido.registration.util.RegistrationDetailsDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Component
public class RegistrationService {

@Autowired
private UserRegistrationRepository registrationRepository;
@Autowired
private DriverRegistrationRepository driverRegistrationRepository;

    @Value("${image.upload.dir}")
    private String uploadDir;

    public ResponseEntity<String> registerUser(RegistrationDetailsDto userDetailsDto) throws IOException {
        UserRegistrationDetails registrationDetails = new UserRegistrationDetails();

        MultipartFile aadharImage = userDetailsDto.getAadharImage();
        String originalFilename = aadharImage.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new IOException("Invalid file name");
        }

        // Get file extension
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        // Create sanitized file name
        String fileName = userDetailsDto.getUserName() + fileExtension;
        // Construct path
        Path path = Paths.get(uploadDir+fileName);

        // Ensure the upload directory exists
       // Files.createDirectories(path.getParent());

        // Write the file to the specified path
       Files.write(path, aadharImage.getBytes());

        if (Files.exists(path)) {
            registrationDetails.setUserId(UUID.randomUUID().toString());
            registrationDetails.setUserRole("ROLE_USER");
            registrationDetails.setUserName(userDetailsDto.getUserName());
            registrationDetails.setAadharNumber(userDetailsDto.getAadharNumber());
            registrationDetails.setAadharImage(fileName);
            registrationDetails.setGender(userDetailsDto.getGender());
            registrationDetails.setMobileNumber(userDetailsDto.getMobileNumber());
            this.registrationRepository.save(registrationDetails);

            return ResponseEntity.ok().body("User registered successfully");
        }
        return ResponseEntity.badRequest().body("user Not Created");
    }

    public ResponseEntity<String> registerDriver(RegistrationDetailsDto userDetailsDto) throws IOException {
        DriverRegistrationDetails DriverDetails = new DriverRegistrationDetails();

        MultipartFile aadharImage = userDetailsDto.getAadharImage();
        String originalFilename = aadharImage.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new IOException("Invalid file name");
        }

        // Get file extension
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        // Create sanitized file name
        String fileName = userDetailsDto.getUserName() + fileExtension;
        // Construct path
        Path path = Paths.get(uploadDir+fileName);

        // Ensure the upload directory exists
        // Files.createDirectories(path.getParent());

        // Write the file to the specified path
        Files.write(path, aadharImage.getBytes());

        if (Files.exists(path)) {
            DriverDetails.setUserId(UUID.randomUUID().toString());
            DriverDetails.setUserRole("ROLE_DRIVER");
            DriverDetails.setUserName(userDetailsDto.getUserName());
            DriverDetails.setAadharNumber(userDetailsDto.getAadharNumber());
            DriverDetails.setAadharImage(fileName);
            DriverDetails.setGender(userDetailsDto.getGender());
            DriverDetails.setMobileNumber(userDetailsDto.getMobileNumber());
            this.driverRegistrationRepository.save(DriverDetails);

            return ResponseEntity.ok().body("Driver registered successfully");
        }
        return ResponseEntity.badRequest().body("Driver Not Registered");
    }

    public String login(LoginDto loginDto, HttpServletResponse res) throws IOException {
        Optional<UserRegistrationDetails> user=this.registrationRepository.findByMobileNumber(loginDto.getMobileNumber());
        Optional<DriverRegistrationDetails> driver=this.driverRegistrationRepository.findByMobileNumber(loginDto.getMobileNumber());
        if(user.isPresent()){
           String role = user.get().getUserRole();
           return role;
        }
        if(driver.isPresent()){
            String role = driver.get().getUserRole();
            return role;
        }
        else {
            return " User Not Registered";
        }
    }
}

