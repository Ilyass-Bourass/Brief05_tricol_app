package com.tricol.repository;

import com.tricol.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {


    List<Fournisseur> findBySociete(String societe);

    // Recherche par ville
    List<Fournisseur> findByVille(String ville);

    // Recherche par email
    Optional<Fournisseur> findByEmail(String email);

    // Recherche par ICE
    Optional<Fournisseur> findByIce(String ice);

    // Recherche par société contenant un texte (LIKE %texte%)
    List<Fournisseur> findBySocieteContainingIgnoreCase(String societe);

    // Tri par nom de société
    List<Fournisseur> findAllByOrderBySocieteAsc();
}

