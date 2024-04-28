package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.Clinique;
import com.springboot.rendezvousapp.entities.Patient;
import com.springboot.rendezvousapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CliniqueRepo extends JpaRepository <Clinique, Integer> {

    Optional<Clinique> findById(Integer idClinique);
    Optional<Clinique> findByCodeClinique(Integer codeClinique);
}
