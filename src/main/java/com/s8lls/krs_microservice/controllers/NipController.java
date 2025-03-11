package com.s8lls.krs_microservice.controllers;

import com.s8lls.krs_microservice.entity.FirmResponse;
import com.s8lls.krs_microservice.repositories.NipRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NipController {

    private final NipRepository nipRepository;

    public NipController(NipRepository nipRepository) {
        this.nipRepository = nipRepository;
    }

    @GetMapping("/api/{nip}")
    public FirmResponse getFirmByNip(@PathVariable String nip) {
        return nipRepository.getFirmByNip(nip);
    }
}