package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addOrUpdateBloc(Bloc bloc);
    void deleteBloc(Long idBloc);
    List<Bloc> findAllBlocs();
    Bloc findBloc(Long idBloc);

    Bloc addBlocAndFoyer(Bloc bloc);
    Bloc assignBlocToFoyer(Long idBloc, Long idFoyer);
    Bloc desaffecterBlocFromFoyer(Long idBloc);

    List<Bloc> findBlocsSansFoyer();
    List<Bloc> findBlocsByCapaciteGreaterThan(long capaciteBloc);
    List<Bloc> findBlocsByNomStartingWith(String prefix);
    List<Bloc> findBlocsByNomStartingWithAndCapaciteGreaterThan(String prefix, long capaciteBloc);
}