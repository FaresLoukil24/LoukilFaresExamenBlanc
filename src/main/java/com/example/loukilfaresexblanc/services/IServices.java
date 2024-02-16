package com.example.loukilfaresexblanc.services;

import com.example.loukilfaresexblanc.entites.CarteFid;
import com.example.loukilfaresexblanc.entites.Client;
import com.example.loukilfaresexblanc.entites.Magasin;

import java.util.List;

public interface IServices {
Client ajouterClient(Client c);
Magasin ajouterMagasinEtPersonnels(Magasin magasin);
void affecterClientAMagasin(int idClient,int idMagasin);
void ajouterCarteEtAffecterClient(CarteFid carteFid,long cin);
long effectuerOperation(String typeOperation,long numCarte,int montant);
List<Client> afficherClients(String nomMagasin);
void totaleSolder();
}
