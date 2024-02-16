package com.example.loukilfaresexblanc.repositories;

import com.example.loukilfaresexblanc.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByCin(long cin);

}
