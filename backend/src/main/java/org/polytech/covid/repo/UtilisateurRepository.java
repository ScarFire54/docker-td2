package org.polytech.covid.repo;

import jdk.jshell.execution.Util;
import org.polytech.covid.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    List<Utilisateur> findAllByRole(String role);

    Optional<Utilisateur> findByUserMail(String userMail);

    Optional<Utilisateur> findById(Long id);
}
