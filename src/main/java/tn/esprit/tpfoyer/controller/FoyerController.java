package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/Foyer")
@AllArgsConstructor
public class FoyerController {

    final IFoyerService foyerService;

    @PostMapping("/add")
    Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @PutMapping("/update")
    Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @DeleteMapping("/delete")
    void deleteFoyer(@RequestParam Long id) {
        foyerService.deleteFoyer(id);
    }

    @GetMapping("/findAll")
    List<Foyer> getAllFoyers() {
        return foyerService.findAllFoyers();
    }

    @GetMapping("/findById/{idFoyer}")
    Foyer findByIdFoyer(@PathVariable Long idFoyer) {
        return foyerService.findFoyer(idFoyer);
    }
}