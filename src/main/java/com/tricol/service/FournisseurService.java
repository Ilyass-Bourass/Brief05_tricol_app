package com.tricol.service;

import com.tricol.model.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurService {

    List<Fournisseur> getAllFournisseurs();

    List<Fournisseur> getAllFournisseursSorted();

    Optional<Fournisseur> getFournisseurById(Long id);

    Fournisseur createFournisseur(Fournisseur fournisseur);

    Fournisseur updateFournisseur(Long id, Fournisseur fournisseur);

    void deleteFournisseur(Long id);

    List<Fournisseur> searchBySociete(String societe);

    List<Fournisseur> findByVille(String ville);
    List<Integer> getFournisseurEndByGmail();


   // boolean existsByEmail(String email);

    boolean existsByIce(String ice);
}
