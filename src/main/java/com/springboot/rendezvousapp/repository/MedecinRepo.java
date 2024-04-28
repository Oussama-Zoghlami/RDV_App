package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface MedecinRepo extends JpaRepository <Medecin, Integer> {
    @Query("SELECT m FROM Medecin m WHERE m.specialite=:specialite ")
    List<Medecin> getMedecinBySpecialite(@Param("specialite") Specialite specialite);

    Medecin findByNomMed(String nomDuMedecin);
    Medecin findByCinMed(Integer cinMedecin);
    Optional<Medecin> findById(Integer id);


}
