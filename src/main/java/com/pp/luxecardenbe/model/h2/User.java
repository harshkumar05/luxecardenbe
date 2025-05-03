package com.pp.luxecardenbe.model.h2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@Builder
public class User {
    @Id
    private String email;
    private String name;
    private String otp;
    private LocalDateTime otpExpiryTime;
}