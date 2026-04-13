package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre addOrUpdateChambre(Chambre chambre);
    void deleteChambre(Long idChambre);
    List<Chambre> findAllChambres();
    Chambre findChambre(Long idChambre);

    Chambre addChambreAndReservations(Chambre chambre);
    Reservation assignReservationToChambre(String idReservation, Long idChambre);
    Reservation annulerReservation(String idReservation);

    List<Chambre> findChambresByType(TypeChambre typeC);
    Chambre findChambreByNumero(long numeroChambre);
}