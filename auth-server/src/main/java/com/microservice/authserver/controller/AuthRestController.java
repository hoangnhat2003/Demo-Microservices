package com.microservice.authserver.controller;

import com.microservice.authserver.config.jwt.JwtUtils;
import com.microservice.authserver.domain.document.User;
import com.microservice.authserver.domain.exception.AuthExceptionHandling;
import com.microservice.authserver.domain.request.LoginRequest;
import com.microservice.authserver.domain.response.ApiResponse;
import com.microservice.authserver.domain.response.TokenDTO;
import com.microservice.authserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/authenticate")
@Slf4j
public class AuthRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtil;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest request) throws Exception {
        User userDetails = userService.findByEmail(request.getEmail());
        authenticate(request.getEmail(), request.getPassword());

        final String token = jwtUtil.generateToken(userDetails);

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUserId(userDetails.getId());
        tokenDTO.setEmail(request.getEmail());
        tokenDTO.setUsername(userDetails.getUsername());
        tokenDTO.setToken(token);
        tokenDTO.setExpiredDate(jwtUtil.getExpirationDateFromToken(token));

        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Login successfully" , tokenDTO));
    }

    private void authenticate(String email, String password) throws Exception {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthExceptionHandling("Password is incorrect");
        } catch (AuthenticationException e) {
            throw new AuthExceptionHandling("Email has not been registered");
        }
    }
}
