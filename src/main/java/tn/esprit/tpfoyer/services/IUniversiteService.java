package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Universite;
import java.util.List;

public interface IUniversiteService {
    Universite addOrUpdateUniversite(Universite universite);
    void deleteUniversite(Long idUniversite);
    List<Universite> findAllUniversites();
    Universite findUniversite(Long idUniversite);
}