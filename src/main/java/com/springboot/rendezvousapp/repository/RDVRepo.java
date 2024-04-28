package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RDVRepo extends JpaRepository <RDV, Integer> {
    List<RDV> findByPatient_IdPat(Integer patientId);
    List<RDV> findByMedecin_IdMed(Integer medecinId);

    @Query("SELECT r FROM RDV r WHERE r.patient.cinPat = :cinPatient AND r.medecin.cinMed = :cinMedecin")
    Optional<RDV> findRDVCommun(@Param("cinPatient") Integer cinPatient, @Param("cinMedecin") Integer cinMedecin);


}
