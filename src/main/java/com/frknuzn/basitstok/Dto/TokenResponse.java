package com.frknuzn.basitstok.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TokenResponse {

    private String username;
    private long userId;
    private String token;
    private long tokenTime;
}
