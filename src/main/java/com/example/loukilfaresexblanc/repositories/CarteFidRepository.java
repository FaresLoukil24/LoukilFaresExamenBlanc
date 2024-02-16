package com.example.loukilfaresexblanc.repositories;

import com.example.loukilfaresexblanc.entites.CarteFid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteFidRepository extends JpaRepository<CarteFid,Long> {
    CarteFid findByNumeroCarte(long numCarte);
}
