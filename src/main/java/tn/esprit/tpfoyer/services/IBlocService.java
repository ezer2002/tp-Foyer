package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Bloc;
import java.util.List;

public interface IBlocService {
    Bloc addOrUpdateBloc(Bloc bloc);
    void deleteBloc(Long idBloc);
    List<Bloc> findAllBlocs();
    Bloc findBloc(Long idBloc);
}