package tn.esprit.tpfoyer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SchedulerService {

    // S'exécute toutes les 15 secondes entre 8h et 12h du lundi au vendredi.
    @Scheduled(cron = "*/15 * 8-11 * * MON-FRI")
    public void schedulerOne() {
        log.info("Scheduler 1 exécuté - toutes les 15s entre 8h-12h, Lun-Ven");
    }

    // S'exécute toutes les 10 minutes entre 9h et 17h50 les mardi et vendredi.
    @Scheduled(cron = "0 0/10 9-17 * * TUE,FRI")
    public void schedulerTwo() {
        log.info("Scheduler 2 exécuté - toutes les 10min entre 9h-17h50, Mar et Ven");
    }

    // S'exécute chaque lundi à 8h15 et 8h45.
    @Scheduled(cron = "0 15,45 8 * * MON")
    public void schedulerThree() {
        log.info("Scheduler 3 exécuté - chaque Lundi à 8h15 et 8h45");
    }
}