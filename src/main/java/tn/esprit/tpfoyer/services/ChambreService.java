package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.repositories.ChambreRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {

    private final ChambreRepository chambreRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public Chambre addOrUpdateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> findAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public Chambre addChambreAndReservations(Chambre chambre) {
        Chambre savedChambre = chambreRepository.save(chambre);

        Set<Reservation> reservations = chambre.getReservations();
        if (reservations != null && !reservations.isEmpty()) {
            reservations.forEach(reservation -> {
                reservation.setChambre(savedChambre);
                reservationRepository.save(reservation);
            });
            savedChambre.setReservations(reservations);
        }

        return savedChambre;
    }

    @Override
    public Reservation assignReservationToChambre(String idReservation, Long idChambre) {
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new RuntimeException("Reservation introuvable"));

        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new RuntimeException("Chambre introuvable"));

        reservation.setChambre(chambre);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation annulerReservation(String idReservation) {
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new RuntimeException("Reservation introuvable"));

        reservation.setChambre(null);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Chambre> findChambresByType(TypeChambre typeC) {
        return chambreRepository.findByTypeC(typeC);
    }

    @Override
    public Chambre findChambreByNumero(long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }
}