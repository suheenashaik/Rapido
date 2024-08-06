package com.example.Rapido.registration.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationDetailsDto {

    public String userId;
    public String userName;
    public String aadharNumber;
    public MultipartFile aadharImage;
    public Gender gender;
    public String mobileNumber;
}
