package com.tricol.service;

import com.tricol.model.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurService {

    // Récupérer tous les fournisseurs
    List<Fournisseur> getAllFournisseurs();

    // Récupérer tous les fournisseurs triés par nom
    List<Fournisseur> getAllFournisseursSorted();

    // Récupérer un fournisseur par ID
    Optional<Fournisseur> getFournisseurById(Long id);

    // Créer un nouveau fournisseur
    Fournisseur createFournisseur(Fournisseur fournisseur);

    // Mettre à jour un fournisseur
    Fournisseur updateFournisseur(Long id, Fournisseur fournisseur);

    // Supprimer un fournisseur
    void deleteFournisseur(Long id);

    // Rechercher par société
    List<Fournisseur> searchBySociete(String societe);

    // Rechercher par ville
    List<Fournisseur> findByVille(String ville);

    // Vérifier si email existe
    boolean existsByEmail(String email);

    // Vérifier si ICE existe
    boolean existsByIce(String ice);
}
