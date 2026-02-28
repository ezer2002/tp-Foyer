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
}