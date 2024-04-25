package com.springboot.rendezvousapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rdv")
    private Integer idRDV;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateRDV;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm")

    private LocalTime heureRdv;
    private String nomDuPatient;
    private String nomDuMedecin;

    @Enumerated(EnumType.STRING)
    private EtatRDV etatRDV;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;
    @Enumerated(EnumType.STRING)
    private  PaiementRDV paiementRDV;

}
