package com.pp.luxecardenbe.model.h2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpAuth {

    private String emailID;
    private String otp;
}
