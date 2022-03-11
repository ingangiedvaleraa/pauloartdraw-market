package com.panda.pauloartdraw.market.web.controller;

import com.panda.pauloartdraw.market.domain.dto.ClientDto;
import com.panda.pauloartdraw.market.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }
}
