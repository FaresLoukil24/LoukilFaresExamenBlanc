package com.example.loukilfaresexblanc.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private long id;
    String nomClient;
    String prenomClient;
    String adresseClient;
    @Column(unique = true)
    long cin;
    @ManyToMany
    List<Magasin>magasins=new ArrayList<>();

}
