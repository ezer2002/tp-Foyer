package tn.esprit.tpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;

    String nomUniversite;
    String adresse;

    @OneToOne
    @ToString.Exclude
    @JsonIgnore
    Foyer foyer;
}