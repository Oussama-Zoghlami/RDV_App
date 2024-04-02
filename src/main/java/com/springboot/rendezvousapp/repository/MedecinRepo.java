package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MedecinRepo extends JpaRepository <Medecin, Integer> {
}
