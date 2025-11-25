package com.tricol.repository;

import com.tricol.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {


    List<Fournisseur> findBySociete(String societe);

    List<Fournisseur> findByVilleIgnoreCase(String ville);

    Optional<Fournisseur> findByEmail(String email);

    Optional<Fournisseur> findByIce(String ice);

    List<Fournisseur> findBySocieteContainingIgnoreCase(String societe);

    List<Fournisseur> findAllByOrderBySocieteAsc();
}

