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
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMagasin")
    long id;
    String nomMagasin;
    String adresseMagasin;
    String contactMagasin;
    @OneToOne
    Personnel personnel;
    @OneToMany(mappedBy = "magasins")
    List<Personnel> caissiers=new ArrayList<>();
    @ManyToMany(mappedBy = "magasins")
    List<Client> clients=new ArrayList<>();

}

