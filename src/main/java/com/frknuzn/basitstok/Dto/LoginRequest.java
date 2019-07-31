package com.frknuzn.basitstok.Dto;

import lombok.Data;

//Login isteğinin geleceği request DTO su
@Data
public class LoginRequest {
    private String username;
    private String password;
}
