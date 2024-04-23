package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.Medecin;
import com.springboot.rendezvousapp.entities.Role;
import com.springboot.rendezvousapp.entities.Specialiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MedecinRepo extends JpaRepository <Medecin, Integer> {
    Medecin findByCinMedecin(Integer cin);
    List<Medecin> findBySpecialiste(@Param("specialiste") Specialiste specialiste);
}
