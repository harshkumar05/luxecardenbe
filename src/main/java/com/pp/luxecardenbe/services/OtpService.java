package com.pp.luxecardenbe.services;

import com.pp.luxecardenbe.model.h2.Otp;
import com.pp.luxecardenbe.repository.h2.OtpTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {
    @Autowired
    private OtpTokenRepository otpTokenRepository;

    public String generateOtp(String emailID){
        String otpString = String.format("%06d", new Random().nextInt(999999));
        LocalDateTime timeToLive = LocalDateTime.now().plusMinutes(5);
        otpTokenRepository.deleteByEmailID(emailID);
        Otp otp=new Otp(emailID,otpString,timeToLive);
        otpTokenRepository.save(otp);
        return otpString;
    }

    public boolean validateOtp(String email,String otp){
        Optional<Otp> optional = otpTokenRepository.findByEmailID(email);

        if (optional.isEmpty()) return false;

        Otp token = optional.get();

        if (token.getExpiryTime().isBefore(LocalDateTime.now())) {
            otpTokenRepository.delete(token);
            return false;
        }

        boolean isValid = token.getOtp().equals(otp);

        if (isValid) {
            otpTokenRepository.delete(token); // One-time use
        }

        return isValid;
    }
}
