package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("/Chambre")
@AllArgsConstructor
public class ChambreController {

    final IChambreService chambreService;

    @PostMapping("/add")
    Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addOrUpdateChambre(chambre);
    }

    @PutMapping("/update")
    Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.addOrUpdateChambre(chambre);
    }

    @DeleteMapping("/delete")
    void deleteChambre(@RequestParam Long id) {
        chambreService.deleteChambre(id);
    }

    @GetMapping("/findAll")
    List<Chambre> getAllChambres() {
        return chambreService.findAllChambres();
    }

    @GetMapping("/findById/{idChambre}")
    Chambre findByIdChambre(@PathVariable Long idChambre) {
        return chambreService.findChambre(idChambre);
    }

    @PostMapping("/add-chambre-and-reservations")
    Chambre addChambreAndReservations(@RequestBody Chambre chambre) {
        return chambreService.addChambreAndReservations(chambre);
    }

    @PutMapping("/assign-reservation-to-chambre/{idReservation}/{idChambre}")
    Reservation assignReservationToChambre(@PathVariable String idReservation,
                                           @PathVariable Long idChambre) {
        return chambreService.assignReservationToChambre(idReservation, idChambre);
    }

    @PutMapping("/cancel-reservation/{idReservation}")
    Reservation annulerReservation(@PathVariable String idReservation) {
        return chambreService.annulerReservation(idReservation);
    }
}