package com.springboot.rendezvousapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medecin")
    private Integer idMed;
    @Column(name = "nom_medecin")
    private String nomMed;
    @Column(name = "cin_medecin")
    private Integer cinMed;
    @Column(name = "tel_medecin")
    private Integer telMed;
    @Column(name = "prix_consultation")
    private Integer prix;

    @Enumerated(EnumType.STRING)
    private Specialiste specialiste;


    @JsonIgnore
    @OneToMany(mappedBy = "medecin")
    private List<RDV> rdvs;

    @ManyToOne
    @JoinColumn(name = "clinique_id")
    private Clinique clinique;
}
