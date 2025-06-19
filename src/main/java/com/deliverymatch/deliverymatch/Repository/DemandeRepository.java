package com.deliverymatch.deliverymatch.Repository;

import com.deliverymatch.deliverymatch.Model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByTrajetConducteurId(Long conducteurId);
}
