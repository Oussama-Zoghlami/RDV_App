package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MedecinRepo extends JpaRepository <Medecin, Integer> {

    List<Medecin> findBySpecialite(@Param("specialite") Specialite specialite);

    Medecin findByNomMed(String nomDuMedecin);
    Medecin findByCinMed(Integer cinMedecin);


}
