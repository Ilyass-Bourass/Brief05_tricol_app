package com.tricol.controller;

import com.tricol.model.Fournisseur;
import com.tricol.service.FournisseurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/v1/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;
    private String test;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService ,String test) {
        this.fournisseurService = fournisseurService;
        this.test = test;
    }


    // ========== ENDPOINT DE TEST SIMPLE ==========
    @GetMapping("/test")
    public Map<String, Object> testEndpoint() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "L'API fonctionne correctement ✅");
        response.put("timestamp", System.currentTimeMillis());
        response.put("status", "OK");
        response.put("totalFournisseurs", fournisseurService.getAllFournisseurs().size());
        return response;
    }

    @GetMapping
    public List<Fournisseur> getAllFournisseurs(
            @RequestParam(required = false) String sort) {
        if ("nom".equalsIgnoreCase(sort)) {
            return fournisseurService.getAllFournisseursSorted();
        }
        return fournisseurService.getAllFournisseurs();
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseurById(@PathVariable Long id) {
        return fournisseurService.getFournisseurById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Fournisseur non trouvé avec l'ID: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fournisseur createFournisseur(@Valid @RequestBody Fournisseur fournisseur) {
        try {
            return fournisseurService.createFournisseur(fournisseur);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(
            @PathVariable Long id,
            @Valid @RequestBody Fournisseur fournisseur) {
        try {
            return fournisseurService.updateFournisseur(id, fournisseur);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteFournisseur(@PathVariable Long id) {
        try {
            fournisseurService.deleteFournisseur(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Fournisseur supprimé avec succès");
            response.put("status", "success");
            return response;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/search")
    public List<Fournisseur> searchBySociete(@RequestParam String societe) {
        return fournisseurService.searchBySociete(societe);
    }

    @GetMapping("/ville/{ville}")
    public List<Fournisseur> getFournisseursByVille(@PathVariable String ville) {
        return fournisseurService.findByVille(ville);
    }

    @GetMapping("/testString")
    public List<Integer> getFournisseurByEmail() {
        return fournisseurService.getFournisseurEndByGmail();
    }
}


