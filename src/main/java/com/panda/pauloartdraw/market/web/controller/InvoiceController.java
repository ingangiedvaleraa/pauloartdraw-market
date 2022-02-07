package com.panda.pauloartdraw.market.web.controller;

import com.panda.pauloartdraw.market.domain.dto.InvoiceDto;
import com.panda.pauloartdraw.market.domain.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping()
    public ResponseEntity<List<InvoiceDto>> getAll() {
        return new ResponseEntity<>(invoiceService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<InvoiceDto>> getByClient(@PathVariable("clientId") String clientId) {
        return invoiceService.getAllByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<InvoiceDto> save(@RequestBody InvoiceDto purchase) {
        return new ResponseEntity<>(invoiceService.save(purchase), HttpStatus.CREATED);
    }
}
