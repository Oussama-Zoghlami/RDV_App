package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDVRepo extends JpaRepository <RDV, Integer> {
}
