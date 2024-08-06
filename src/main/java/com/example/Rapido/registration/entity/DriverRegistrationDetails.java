package com.example.Rapido.registration.entity;

import com.example.Rapido.registration.util.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "DriverRegistrationDetatils")
public  class DriverRegistrationDetails {

        @Id
        private String userId;
        private String userRole;
        private String userName;
        private String aadharNumber;
        private String aadharImage;
        @Enumerated(EnumType.STRING)
        private Gender gender;
        private String mobileNumber;
}


