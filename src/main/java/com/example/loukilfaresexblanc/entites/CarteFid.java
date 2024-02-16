package com.example.loukilfaresexblanc.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarteFid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarteFid")
    long id;
    @Column(unique = true)
    long numeroCarte;
    long solde;
    LocalDate dateCreation;
    @OneToOne
    Client client;
}
