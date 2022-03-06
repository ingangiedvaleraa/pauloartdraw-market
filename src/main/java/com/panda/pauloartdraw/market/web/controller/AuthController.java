package com.panda.pauloartdraw.market.web.controller;

import com.panda.pauloartdraw.market.domain.dto.AuthenticationRequestDto;
import com.panda.pauloartdraw.market.domain.dto.AuthenticationResponseDto;
import com.panda.pauloartdraw.market.domain.dto.ClientDto;
import com.panda.pauloartdraw.market.domain.service.AuthService;
import com.panda.pauloartdraw.market.domain.service.ClientService;
import com.panda.pauloartdraw.market.web.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @CrossOrigin(origins = "http://localhost:3005")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> createToken(@RequestBody AuthenticationRequestDto request) {
        return authService.createToken(request);
    }

    @CrossOrigin(origins = "http://localhost:3005")
    @PostMapping("/register")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto client) {
        return new ResponseEntity<>(authService.saveAndFlush(client), HttpStatus.CREATED);
    }

}
