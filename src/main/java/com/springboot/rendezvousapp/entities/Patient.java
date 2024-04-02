package com.springboot.rendezvousapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cin"})})
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Integer idPat;
    @Column(name = "nom_patient")
    private String nomPat;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @Column(name = "cin_patient")
    private Integer  cinPat;
    @Column(name = "telephone_patient")
    private Integer telPat;
    @Column(name = "email_patient")
    private String email;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<RDV> rdvs;

}
