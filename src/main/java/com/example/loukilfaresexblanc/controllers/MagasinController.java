package com.example.loukilfaresexblanc.controllers;

import com.example.loukilfaresexblanc.entites.Client;
import com.example.loukilfaresexblanc.entites.Magasin;
import com.example.loukilfaresexblanc.services.IServices;
import com.example.loukilfaresexblanc.services.Services;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("magasin")
@AllArgsConstructor
public class MagasinController {
    IServices services;
    @PostMapping("add")
    public ResponseEntity<Magasin> ajouterMagasin(@RequestBody Magasin magasin) {
        Magasin savedMagasin = services.ajouterMagasinEtPersonnels(magasin);
        return new ResponseEntity<>(savedMagasin, HttpStatus.CREATED);
    }

}
