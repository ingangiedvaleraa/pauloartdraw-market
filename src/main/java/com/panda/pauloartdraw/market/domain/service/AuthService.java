package com.panda.pauloartdraw.market.domain.service;

import com.panda.pauloartdraw.market.domain.dto.AuthenticationRequestDto;
import com.panda.pauloartdraw.market.domain.dto.AuthenticationResponseDto;
import com.panda.pauloartdraw.market.domain.dto.ClientDto;
import com.panda.pauloartdraw.market.domain.repository.DomainClientRepository;
import com.panda.pauloartdraw.market.web.controller.AuthController;
import com.panda.pauloartdraw.market.web.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private DomainClientRepository clientRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private ClientService clientService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static Logger LOG = LoggerFactory.getLogger(AuthController.class);

    public ResponseEntity<AuthenticationResponseDto> createToken(AuthenticationRequestDto request) {
        LOG.info(request.getEmail());
        try {
            UserDetails userDetails = clientService.loadUserByUsername(request.getEmail());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            String token = jwtUtil.generateToken(userDetails);
            String rol = token != null ? String.valueOf(userDetails.getAuthorities()) : null;
            return new ResponseEntity<>(new AuthenticationResponseDto(token, rol), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(new AuthenticationResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOG.info(String.valueOf(e));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ClientDto saveAndFlush(ClientDto client) {
        client.setPassword(encoder.encode(client.getPassword()));
        return clientRepo.saveAndFlush(client);
    }

}
