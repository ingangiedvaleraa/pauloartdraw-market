package com.panda.pauloartdraw.market.domain.service;

import com.panda.pauloartdraw.market.domain.dto.ClientDto;
import com.panda.pauloartdraw.market.domain.repository.DomainClientRepository;
import com.panda.pauloartdraw.market.web.controller.AuthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements UserDetailsService {

    @Autowired
    private DomainClientRepository clientRepo;

    private static Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ClientDto> client = Optional.ofNullable(clientRepo.getByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email not found: " + username)));
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(client.get().getRol().getRol()));
        LOG.info(client.get().getRol().getRol());
        UserDetails userDetails = new User(client.get().getEmail(), client.get().getPassword(), roles);
        return userDetails;
    }
}
