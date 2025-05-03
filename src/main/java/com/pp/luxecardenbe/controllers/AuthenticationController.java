package com.pp.luxecardenbe.controllers;

import com.pp.luxecardenbe.model.RequestBody.OtpAuth;
import com.pp.luxecardenbe.services.EmailService;
import com.pp.luxecardenbe.services.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-otp")
    public ResponseEntity <String> sendOTP(@RequestBody String userEmail){
        if(otpService.isUserRegistered(userEmail)){
            // update the OTP;
            // may be have the logic to stop further sending if expiry time is not passed
        }
        else{
            otpService.insertOTP(userEmail);
        }
       String otp=otpService.insertOTP(userEmail);
       emailService.sendOtp(userEmail,otp);
       return ResponseEntity.ok("OTP Sent to Email "+ userEmail);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> validateOTP(@RequestBody OtpAuth otpAuth){
        boolean isValid = otpService.validateOtp(otpAuth.getEmailID(), otpAuth.getOtp());
        return isValid ?
                ResponseEntity.ok("OTP is valid!") :
                ResponseEntity.badRequest().body("Invalid or expired OTP.");
    }


}
