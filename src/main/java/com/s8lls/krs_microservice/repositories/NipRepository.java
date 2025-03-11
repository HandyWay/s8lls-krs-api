package com.s8lls.krs_microservice.repositories;

import com.s8lls.krs_microservice.entity.FirmResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Repository
public class NipRepository {

    @Value("${nip24.api.url}")
    private String apiUrl;

    @Value("${nip24.api.id}")
    private String apiId;

    @Value("${nip24.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public NipRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<FirmResponse> fetchFirmByNip(String nip) {
        String url = apiUrl + "/get/status/nip/" + nip;

        String auth = apiId + ":" + apiKey;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + encodedAuth);
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(List.of(MediaType.APPLICATION_XML));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, FirmResponse.class);
    }
}
