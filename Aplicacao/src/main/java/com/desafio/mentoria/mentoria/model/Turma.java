package com.desafio.mentoria.mentoria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "turmas")
@Getter @Setter @NoArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "turma_id", updatable = false)
    private Integer turmaId;

    @Column(nullable = false)
    private String ano;

    @Column(name = "mentor_id", nullable = false)
    private String mentorId;

    public Turma(String ano, String mentorId) {
        this.ano = ano;
        this.mentorId = mentorId;
    }
}
