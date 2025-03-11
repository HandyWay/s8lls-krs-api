package com.s8lls.krs_microservice.controllers;

import com.s8lls.krs_microservice.entity.FirmResponse;
import com.s8lls.krs_microservice.services.NipService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NipController {

    private final NipService nipService;

    public NipController(NipService nipService) {
        this.nipService = nipService;
    }

    @GetMapping(value ="/{nip}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FirmResponse getFirmByNip(@PathVariable String nip) {
        return nipService.getFirmByNip(nip);
    }

}