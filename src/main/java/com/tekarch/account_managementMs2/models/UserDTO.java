package com.tekarch.account_managementMs2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Long userId;
    private String username;
    private String email;
    private String password_hash;
    private String phone_number;
    private Boolean two_factor_enabled = false;
    private String kyc_status = "pending";

}
