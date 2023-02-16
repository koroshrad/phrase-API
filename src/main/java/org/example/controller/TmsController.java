package org.example.controller;

import org.example.entity.LoginResponse;
import org.example.entity.Project;
import org.example.entity.TmsAccount;
import org.example.repo.LoginResponseRepository;
import org.example.repo.TmsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TmsController {

    @Value("$(api.key)")
    private String apiKey;
    @Autowired
    TmsAccountRepository tmsAccountRepository;

    @Autowired
    LoginResponseRepository loginResponseRepo;



    @PostMapping("/login")
    public LoginResponse login(@RequestBody TmsAccount request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TmsAccount> entity = new HttpEntity<>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        LoginResponse response = restTemplate.postForObject(
                "https://cloud.memsource.com/web/oauth/token", entity, LoginResponse.class);

        loginResponseRepo.save(response);
        return response;
    }


    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects(@RequestHeader("Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<List<Project>> typeRef = new ParameterizedTypeReference<List<Project>>() {};
        ResponseEntity<List<Project>> response = restTemplate.exchange("https://cloud.memsource.com/web/api/v3/listProjects",
                HttpMethod.GET, entity, typeRef);

        List<Project> projects = response.getBody();
        return ResponseEntity.ok(projects);
    }



}
