package com.s8lls.krs_microservice.services;
import com.s8lls.krs_microservice.entity.FirmResponse;
import com.s8lls.krs_microservice.repositories.NipRepository;
import org.springframework.stereotype.Service;

import org.springframework.http.ResponseEntity;


@Service
public class NipService {

    private final NipRepository nipRepository;

    public NipService(NipRepository nipRepository) {
        this.nipRepository = nipRepository;
    }

    public FirmResponse getFirmByNip(String nip) {
        try {
            ResponseEntity<FirmResponse> response = nipRepository.fetchFirmByNip(nip);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody();
            } else {
                throw new RuntimeException("Błąd: otrzymano niepoprawny status " + response.getStatusCode());
            }
        } catch (Exception e) {
            return new FirmResponse();
        }
    }
}

