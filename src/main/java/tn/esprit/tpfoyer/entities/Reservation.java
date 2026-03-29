package tn.esprit.tpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Reservation {

    @Id
    String idReservation;

    @Temporal(TemporalType.DATE)
    Date anneeUniversitaire;

    boolean estValide;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Chambre chambre;

    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    Set<Etudiant> etudiants = new HashSet<>();
}