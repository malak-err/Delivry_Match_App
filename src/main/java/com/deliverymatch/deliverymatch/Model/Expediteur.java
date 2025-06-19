package com.deliverymatch.deliverymatch.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Expediteur extends User {
    @OneToMany
    private List<Demande> demandes;

    public Expediteur() {
        this.setRole(Role.EXPEDITEUR);
    }
}