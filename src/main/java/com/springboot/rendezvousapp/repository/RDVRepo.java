package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RDVRepo extends JpaRepository <RDV, Integer> {
    List<RDV> findByPatient_IdPat(Integer patientId);
    List<RDV> findByMedecin_IdMed(Integer medecinId);


}
