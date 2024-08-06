package com.example.Rapido.registration.repository;

import com.example.Rapido.registration.entity.UserRegistrationDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRegistrationRepository extends CrudRepository<UserRegistrationDetails, Long> {
    @Query("SELECT u FROM UserRegistrationDetails u WHERE u.mobileNumber = :mobileNumber")
    Optional<UserRegistrationDetails> findByMobileNumber(@Param("mobileNumber") String mobileNumber);
}
