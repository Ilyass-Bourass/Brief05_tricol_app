package com.tricol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "fournisseurs")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La société est obligatoire")
    @Column(nullable = false)
    private String societe;

    @NotBlank(message = "L'adresse est obligatoire")
    @Column(nullable = false)
    private String adresse;

    @NotBlank(message = "Le contact est obligatoire")
    @Column(nullable = false)
    private String contact;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format email invalide")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Le téléphone est obligatoire")
    @Pattern(regexp = "^0[5-7][0-9]{8}$", message = "Format téléphone invalide (ex: 0612345678)")
    @Column(nullable = false)
    private String telephone;

    @NotBlank(message = "La ville est obligatoire")
    @Column(nullable = false)
    private String ville;

    @NotBlank(message = "L'ICE est obligatoire")
    @Pattern(regexp = "^[0-9]{15}$", message = "ICE doit contenir 15 chiffres")
    @Column(nullable = false, unique = true, length = 15)
    private String ice;

    public Fournisseur() {
    }

    public Fournisseur(String societe, String adresse, String contact, String email,
                       String telephone, String ville, String ice) {
        this.societe = societe;
        this.adresse = adresse;
        this.contact = contact;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.ice = ice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", societe='" + societe + '\'' +
                ", adresse='" + adresse + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", ville='" + ville + '\'' +
                ", ice='" + ice + '\'' +
                '}';
    }
}

