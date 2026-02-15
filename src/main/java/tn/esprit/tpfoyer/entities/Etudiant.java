package tn.esprit.tpfoyer.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEtudiant;

    String nomEt;
    String prenomEt;
    long cin;
    String ecole;
    Date dateNaissance;


    @ManyToMany(mappedBy = "etudiants")
    @ToString.Exclude
    Set<Reservation> reservations = new HashSet<>();
}
