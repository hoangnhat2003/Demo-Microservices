package com.microservice.authserver.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservice.authserver.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    private Long userId;
    private String username;
    private String email;
    private String token;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date expiredDate;
    private Set<Role> roles;
}
