package com.example.Rapido.registration.repository;

import com.example.Rapido.registration.entity.DriverRegistrationDetails;
import com.example.Rapido.registration.entity.UserRegistrationDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DriverRegistrationRepository extends CrudRepository<DriverRegistrationDetails, Long> {

    @Query("select u from DriverRegistrationDetails u where u.mobileNumber=?1")
    Optional<DriverRegistrationDetails> findByMobileNumber(String mobileNumber);
}
