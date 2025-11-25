package com.tricol.service;

import com.tricol.model.Fournisseur;
import com.tricol.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public List<Fournisseur> getAllFournisseursSorted() {
        return fournisseurRepository.findAllByOrderBySocieteAsc();
    }

    @Override
    public Optional<Fournisseur> getFournisseurById(Long id) {
        return fournisseurRepository.findById(id);
    }

    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        if (fournisseurRepository.findByEmail(fournisseur.getEmail()).isPresent()) {
            throw new RuntimeException("Un fournisseur avec cet email existe déjà");
        }

        if (fournisseurRepository.findByIce(fournisseur.getIce()).isPresent()) {
            throw new RuntimeException("Un fournisseur avec cet ICE existe déjà");
        }

        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur) {
        Fournisseur existingFournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé avec l'ID: " + id));

        if (!existingFournisseur.getEmail().equals(fournisseur.getEmail())) {
            if (fournisseurRepository.findByEmail(fournisseur.getEmail()).isPresent()) {
                throw new RuntimeException("Un fournisseur avec cet email existe déjà");
            }
        }

        if (!existingFournisseur.getIce().equals(fournisseur.getIce())) {
            if (fournisseurRepository.findByIce(fournisseur.getIce()).isPresent()) {
                throw new RuntimeException("Un fournisseur avec cet ICE existe déjà");
            }
        }

        existingFournisseur.setSociete(fournisseur.getSociete());
        existingFournisseur.setAdresse(fournisseur.getAdresse());
        existingFournisseur.setContact(fournisseur.getContact());
        existingFournisseur.setEmail(fournisseur.getEmail());
        existingFournisseur.setTelephone(fournisseur.getTelephone());
        existingFournisseur.setVille(fournisseur.getVille());
        existingFournisseur.setIce(fournisseur.getIce());

        return fournisseurRepository.save(existingFournisseur);
    }

    @Override
    public void deleteFournisseur(Long id) {
        if (!fournisseurRepository.existsById(id)) {
            throw new RuntimeException("Fournisseur non trouvé avec l'ID: " + id);
        }
        fournisseurRepository.deleteById(id);
    }

    @Override
    public List<Fournisseur> searchBySociete(String societe) {
        return fournisseurRepository.findBySocieteContainingIgnoreCase(societe);
    }

    @Override
    public List<Fournisseur> findByVille(String ville) {
        return fournisseurRepository.findByVilleIgnoreCase(ville);
    }

    @Override
    public List<Integer> getFournisseurEndByGmail() {
        return getAllFournisseurs().stream().filter(f->f.getEmail().endsWith("@gmail.com")).
                map(f->f.getSociete().length()).toList();
    }

    @Override
    public boolean existsByIce(String ice) {
        return fournisseurRepository.findByIce(ice).isPresent();
    }


}
