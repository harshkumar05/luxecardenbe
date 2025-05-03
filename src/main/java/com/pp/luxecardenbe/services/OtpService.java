package com.pp.luxecardenbe.services;

import com.pp.luxecardenbe.model.h2.Otp;
import com.pp.luxecardenbe.model.h2.User;
import com.pp.luxecardenbe.repository.h2.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {
    @Autowired
    private UserRepository userRepository;

    public String generateOtp(){
        String otpString = String.format("%06d", new Random().nextInt(999999));
//        LocalDateTime timeToLive = LocalDateTime.now().plusMinutes(5);
//        userRepository.deleteByEmailID(emailID);
//        Otp otp=new Otp(emailID,otpString,timeToLive);
//        otpTokenRepository.save(otp);
        return otpString;
    }
    public String insertOTP(String emailID){
        String otpString = generateOtp();
        LocalDateTime timeToLive = LocalDateTime.now().plusMinutes(5);

        userRepository.save(User.builder().email(emailID).otp(otpString).otpExpiryTime(timeToLive).build());
        return otpString;
    }

    public boolean isUserRegistered(String emailID){
        Optional<User> optional = userRepository.findByEmail(emailID);
        if(optional.isPresent()) return true;
        return false;
    }

    public String updateOTP(String emailID){
        Optional<User> optionalUser = userRepository.findByEmail(emailID);
        if (optionalUser.isEmpty()) {
            return null; // Or throw an exception if user not found
        }
        String otpString = generateOtp();
        LocalDateTime timeToLive = LocalDateTime.now().plusMinutes(5);
        User user = optionalUser.get();
        user.setOtp(otpString);
        user.setOtpExpiryTime(timeToLive);
        userRepository.save(user);
        return otpString;
    }

    public boolean validateOtp(String email,String otp){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return false;
        }
        User user = optionalUser.get();
        if (user.getOtp() == null || user.getOtpExpiryTime() == null) {
            return false;
        }
        return user.getOtp().equals(otp) && LocalDateTime.now().isBefore(user.getOtpExpiryTime());
    }
}
