package com.pp.luxecardenbe.model.h2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "otp")
@NoArgsConstructor
@AllArgsConstructor
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailID;
    private String otp;
    private LocalDateTime expiryTime;

    public Otp(String emailID, String otp, LocalDateTime expiryTime) {
        this.emailID = emailID;
        this.otp = otp;
        this.expiryTime = expiryTime;
    }
}
