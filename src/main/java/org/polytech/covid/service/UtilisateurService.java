package org.polytech.covid.service;

import org.apache.catalina.User;
import org.polytech.covid.exception.EmailUsedException;
import org.polytech.covid.exception.UserNotFoundException;
import org.polytech.covid.model.Utilisateur;
import org.polytech.covid.repo.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository userRepository;

    public Utilisateur saveUser(Utilisateur utilisateur) throws EmailUsedException {
        if(userRepository.findByUserMail(utilisateur.getUserMail()).isPresent())
            throw new EmailUsedException();
        return userRepository.save(utilisateur);
    }

    public void deleteUser(String userMail) throws UserNotFoundException {
        if(userRepository.findByUserMail(userMail).isEmpty())
            throw new UserNotFoundException();
        userRepository.delete(userRepository.findByUserMail(userMail).get());
    }

    public List<Utilisateur> getAllUser(){
        return userRepository.findAll();
    }

    public Utilisateur getUserById(Long id){
        Optional<Utilisateur> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
