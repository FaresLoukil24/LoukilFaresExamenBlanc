package com.example.loukilfaresexblanc.repositories;

import com.example.loukilfaresexblanc.entites.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepository extends JpaRepository<Magasin,Integer> {
    Magasin findMagasinByNomMagasin(String nomMagasin);
}
