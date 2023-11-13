package org.polytech.covid.controller;

import org.polytech.covid.model.CentreVaccination;
import org.polytech.covid.service.CentreVaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/center")
public class CentreVaccinationController {

    @Autowired
    CentreVaccinationService centreVaccinationService;

    @PostMapping(value = "/save")
    public CentreVaccination saveCenter(@RequestBody CentreVaccination center){
        return centreVaccinationService.saveCentre(center);
    }

    @GetMapping(value = "/addUser")
    public CentreVaccination addUser(@RequestParam Long idUser, @RequestParam Long idCenter){
        return centreVaccinationService.addUserToCenter(idUser, idCenter);
    }

    @GetMapping(value = "/")
    public List<CentreVaccination> getAllCenter(){
        return centreVaccinationService.findAllCenter();
    }

    @GetMapping(value = "/search")
    public List<CentreVaccination> getCenterBySearch(@RequestParam String search){
        return centreVaccinationService.searchCentreVaccination(search);
    }

    @DeleteMapping(value = "/delete")
    public void deleteCenter(@RequestParam Long id){
        centreVaccinationService.deleteCentre(id);
    }
}
