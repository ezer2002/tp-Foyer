package tn.esprit.tpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer;

    String nomFoyer;
    long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    @ToString.Exclude
    @JsonIgnore
    Universite universite;

    @OneToMany(mappedBy = "foyer")
    @ToString.Exclude
    @JsonIgnore
    Set<Bloc> blocs = new HashSet<>();
}