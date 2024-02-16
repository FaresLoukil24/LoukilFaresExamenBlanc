package com.example.loukilfaresexblanc.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLivre")
    private long id;
    private String nom;
}