package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Universite;
import tn.esprit.tpfoyer.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/Universite")
@AllArgsConstructor
public class UniversiteController {

    final IUniversiteService universiteService;

    @PostMapping("/add")
    Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addOrUpdateUniversite(universite);
    }

    @PutMapping("/update")
    Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.addOrUpdateUniversite(universite);
    }

    @DeleteMapping("/delete")
    void deleteUniversite(@RequestParam Long id) {
        universiteService.deleteUniversite(id);
    }

    @GetMapping("/findAll")
    List<Universite> getAllUniversites() {
        return universiteService.findAllUniversites();
    }

    @GetMapping("/findById/{idUniversite}")
    Universite findByIdUniversite(@PathVariable Long idUniversite) {
        return universiteService.findUniversite(idUniversite);
    }
}