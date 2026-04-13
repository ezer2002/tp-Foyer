package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.repositories.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    private final BlocRepository blocRepository;
    private final FoyerRepository foyerRepository;

    @Override
    public Bloc addOrUpdateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public List<Bloc> findAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public Bloc addBlocAndFoyer(Bloc bloc) {
        if (bloc.getFoyer() == null) {
            throw new RuntimeException("Le foyer est obligatoire pour cette opération");
        }

        Foyer savedFoyer = foyerRepository.save(bloc.getFoyer());
        bloc.setFoyer(savedFoyer);

        return blocRepository.save(bloc);
    }

    @Override
    public Bloc assignBlocToFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable"));

        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer introuvable"));

        bloc.setFoyer(foyer);
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc desaffecterBlocFromFoyer(Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable"));

        bloc.setFoyer(null);
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> findBlocsSansFoyer() {
        return blocRepository.findByFoyerIsNull();
    }

    @Override
    public List<Bloc> findBlocsByCapaciteGreaterThan(long capaciteBloc) {
        return blocRepository.findByCapaciteBlocGreaterThan(capaciteBloc);
    }

    @Override
    public List<Bloc> findBlocsByNomStartingWith(String prefix) {
        return blocRepository.findByNomBlocStartingWith(prefix);
    }

    @Override
    public List<Bloc> findBlocsByNomStartingWithAndCapaciteGreaterThan(String prefix, long capaciteBloc) {
        return blocRepository.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(prefix, capaciteBloc);
    }
}