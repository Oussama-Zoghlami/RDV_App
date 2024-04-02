package com.springboot.rendezvousapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Clinique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClinique;

    private Integer codeClinique;

    private String libelleClinique;

    @JsonIgnore
    @OneToMany(mappedBy = "clinique")
    private List<Medecin>medecins;

}
