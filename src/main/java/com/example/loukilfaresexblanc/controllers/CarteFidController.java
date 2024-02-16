package com.example.loukilfaresexblanc.controllers;

import com.example.loukilfaresexblanc.entites.Client;
import com.example.loukilfaresexblanc.services.Services;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class CarteFidController {
    Services services;
    @PostMapping("effectuerOperation")
    long effectuerOperation(@RequestParam String typeOperation, @RequestParam long numCarte, @RequestParam  int montant) {
        return services.effectuerOperation(typeOperation, numCarte, montant);
    }
    @PostMapping("affecterClientAMagasin")
    void affecterClientAMagasin(@RequestParam  int idClient,@RequestParam int idMagasin){
        services.affecterClientAMagasin(idClient,idMagasin);
    };
    @PostMapping("afficherClient")
    List<Client> afficherClients(@RequestParam  String nomMagasin){
        return services.afficherClients(nomMagasin);
    }
}
