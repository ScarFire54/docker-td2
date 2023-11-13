package org.polytech.covid.service;

import org.polytech.covid.exception.EmailUsedException;
import org.polytech.covid.model.CentreVaccination;
import org.polytech.covid.model.Utilisateur;
import org.polytech.covid.repo.CentreVaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreVaccinationService {

    @Autowired
    CentreVaccinationRepository centreVaccinationRepository;

    @Autowired
    UtilisateurService utilisateurService;

    public CentreVaccination saveCentre(CentreVaccination centre){
        return centreVaccinationRepository.save(centre);
    }

    public List<CentreVaccination> findAllCenter(){
        return centreVaccinationRepository.findAll();
    }

    public void deleteCentre(Long id){
        if(centreVaccinationRepository.findById(id).isPresent())
            centreVaccinationRepository.delete(centreVaccinationRepository.findById(id).get());
    }

    public List<CentreVaccination> searchCentreVaccination(String search){
        search = "%" + search.replace(" ", "%") + "%";
        return centreVaccinationRepository.searchCenter(search);
    }

    public CentreVaccination addUserToCenter(Long idUser, Long idCenter){
        Utilisateur utilisateur = utilisateurService.getUserById(idUser);
        CentreVaccination centreVaccination = centreVaccinationRepository.findById(idCenter).orElse(null);

        utilisateur.setCentreVaccination(centreVaccination);
        if(centreVaccination == null) return null;
        centreVaccination.addUser(utilisateur);
        saveCentre(centreVaccination);
        return centreVaccination;
    }
}
