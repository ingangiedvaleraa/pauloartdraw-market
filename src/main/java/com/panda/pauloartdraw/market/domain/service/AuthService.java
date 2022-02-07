package com.panda.pauloartdraw.market.domain.service;

import com.panda.pauloartdraw.market.domain.dto.ClientDto;
import com.panda.pauloartdraw.market.domain.repository.DomainClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private DomainClientRepository clientRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public ClientDto save(ClientDto client) {
        client.setPassword(encoder.encode(client.getPassword()));
        return clientRepo.save(client);
    }

}
