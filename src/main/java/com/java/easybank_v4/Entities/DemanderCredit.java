package com.java.easybank_v4.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;






@Entity
@Table(name = "demandecredit")
@Getter
@Setter
public class DemanderCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Etat etat;


    private Double capitalEmprunte;
    private int nombreMensualite;

    private String remarques;

    @Column(name = "date_demande")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Ajoutez les annotations JPA appropriées pour les relations et les colonnes
}