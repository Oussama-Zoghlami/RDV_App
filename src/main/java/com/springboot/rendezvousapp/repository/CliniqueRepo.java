package com.springboot.rendezvousapp.repository;

import com.springboot.rendezvousapp.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CliniqueRepo extends JpaRepository <Clinique, Integer> {
}
