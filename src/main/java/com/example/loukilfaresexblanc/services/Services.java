package com.example.loukilfaresexblanc.services;

import com.example.loukilfaresexblanc.entites.CarteFid;
import com.example.loukilfaresexblanc.entites.Client;
import com.example.loukilfaresexblanc.entites.Magasin;
import com.example.loukilfaresexblanc.entites.Personnel;
import com.example.loukilfaresexblanc.repositories.CarteFidRepository;
import com.example.loukilfaresexblanc.repositories.ClientRepository;
import com.example.loukilfaresexblanc.repositories.MagasinRepository;
import com.example.loukilfaresexblanc.repositories.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class Services implements IServices {
    ClientRepository clientRepository;
    MagasinRepository magasinRepository;
    PersonnelRepository personnelRepository;
    CarteFidRepository carteFidRepository;
    @Override
    public Client ajouterClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Magasin ajouterMagasinEtPersonnels(Magasin magasin) {
        return magasinRepository.save(magasin);
    }

    @Override
    public void affecterClientAMagasin(int idClient, int idMagasin) {
        Client client = clientRepository.findById(idClient).get();
        Magasin magasin = magasinRepository.findById(idMagasin).get();
        client.getMagasins().add(magasin);
        clientRepository.save(client);
    }

    @Override
    public void ajouterCarteEtAffecterClient(CarteFid carteFid, long cin) {
        carteFid.setSolde(0);
        carteFid.setDateCreation(LocalDate.now());
        CarteFid carte = carteFidRepository.save(carteFid);
        Client client = clientRepository.findByCin(cin);
        client.setCarteFid(carte);
        clientRepository.save(client);
    }

    @Override
    public long effectuerOperation(String typeOperation, long numCarte, int montant) {
        CarteFid carteFid = carteFidRepository.findByNumeroCarte(numCarte);
        long ancienSolde = carteFid.getSolde();
        long nouveauMontant=0;
        if(typeOperation.equals("+")){
            nouveauMontant = ancienSolde+montant;
            carteFid.setSolde(nouveauMontant);
            carteFidRepository.save(carteFid);
            return nouveauMontant;
        }else if (typeOperation.equals("-")){
            nouveauMontant = ancienSolde-montant;
            carteFid.setSolde(nouveauMontant);
            carteFidRepository.save(carteFid);
            return nouveauMontant;
        }
        return nouveauMontant;
    }
    @Override
    public List<Client> afficherClients(String nomMagasin) {
        Magasin magasin = magasinRepository.findMagasinByNomMagasin(nomMagasin);
        return magasin.getClients();
    }

    @Override
    public void totaleSolder() {

    }
}