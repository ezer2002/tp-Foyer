package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/Bloc")
@AllArgsConstructor
public class BlocController {

    final IBlocService blocService;

    @PostMapping("/add")
    Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addOrUpdateBloc(bloc);
    }

    @PutMapping("/update")
    Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.addOrUpdateBloc(bloc);
    }

    @DeleteMapping("/delete")
    void deleteBloc(@RequestParam Long id) {
        blocService.deleteBloc(id);
    }

    @GetMapping("/findAll")
    List<Bloc> getAllBlocs() {
        return blocService.findAllBlocs();
    }

    @GetMapping("/findById/{idBloc}")
    Bloc findByIdBloc(@PathVariable Long idBloc) {
        return blocService.findBloc(idBloc);
    }

    @PostMapping("/add-bloc-and-foyer")
    Bloc addBlocAndFoyer(@RequestBody Bloc bloc) {
        return blocService.addBlocAndFoyer(bloc);
    }

    @PutMapping("/assign-bloc-to-foyer/{idBloc}/{idFoyer}")
    Bloc assignBlocToFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        return blocService.assignBlocToFoyer(idBloc, idFoyer);
    }

    @PutMapping("/desaffect-bloc-from-foyer/{idBloc}")
    Bloc desaffectBlocFromFoyer(@PathVariable Long idBloc) {
        return blocService.desaffecterBlocFromFoyer(idBloc);
    }

    @GetMapping("/findBlocsSansFoyer")
    List<Bloc> findBlocsSansFoyer() {
        return blocService.findBlocsSansFoyer();
    }

    @GetMapping("/findByCapaciteGreaterThan/{capacite}")
    List<Bloc> findByCapaciteGreaterThan(@PathVariable long capacite) {
        return blocService.findBlocsByCapaciteGreaterThan(capacite);
    }

    @GetMapping("/findByNomStartingWith/{prefix}")
    List<Bloc> findByNomStartingWith(@PathVariable String prefix) {
        return blocService.findBlocsByNomStartingWith(prefix);
    }

    @GetMapping("/findByNomStartingWithAndCapaciteGreaterThan/{prefix}/{capacite}")
    List<Bloc> findByNomStartingWithAndCapaciteGreaterThan(@PathVariable String prefix,
                                                           @PathVariable long capacite) {
        return blocService.findBlocsByNomStartingWithAndCapaciteGreaterThan(prefix, capacite);
    }
}