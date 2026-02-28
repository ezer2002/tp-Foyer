package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
@AllArgsConstructor
public class EtudiantController {

    final IEtudiantService etudiantService;

    @PostMapping("/add")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @PutMapping("/update")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @DeleteMapping("/delete")
    void deleteEtudiant(@RequestParam Long id) {
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/findAll")
    List<Etudiant> getAllEtudiants() {
        return etudiantService.findAllEtudiants();
    }

    @GetMapping("/findById/{idEtudiant}")
    Etudiant findByIdEtudiant(@PathVariable Long idEtudiant) {
        return etudiantService.findEtudiant(idEtudiant);
    }
}