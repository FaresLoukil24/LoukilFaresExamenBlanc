package com.example.loukilfaresexblanc.controllers;

import com.example.loukilfaresexblanc.entites.Client;
import com.example.loukilfaresexblanc.services.IServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {
    IServices services;
    @PostMapping("add")
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client) {
        Client savedClient = services.ajouterClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
}
