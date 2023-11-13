package org.polytech.covid.controller;

import org.polytech.covid.exception.EmailUsedException;
import org.polytech.covid.exception.UserNotFoundException;
import org.polytech.covid.model.Utilisateur;
import org.polytech.covid.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;

    @PostMapping(value = "/save")
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur user) throws EmailUsedException {
        return utilisateurService.saveUser(user);
    }

    @GetMapping(value = "/")
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurService.getAllUser();
    }

    @DeleteMapping(value = "/delete")
    public void deleteUserByMail(@RequestParam String email) throws UserNotFoundException {
        utilisateurService.deleteUser(email);
    }
}
