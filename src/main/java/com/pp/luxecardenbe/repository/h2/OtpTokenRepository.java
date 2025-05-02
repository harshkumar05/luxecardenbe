package com.pp.luxecardenbe.repository.h2;

import com.pp.luxecardenbe.model.h2.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpTokenRepository extends JpaRepository<Otp,Long> {
    Optional <Otp> findByEmailID(String emailID);
    void deleteByEmailID(String emailID);
}
