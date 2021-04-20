package com.desafio.mentoria.turma;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table
public class Turma {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "turma_id", updatable = false)
    private Integer turmaId;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private String mentorId;


    public Turma (){}

    public Turma(String ano,  String mentorId) {
        this.ano = ano;
        this.mentorId = mentorId;
    }

    public Integer getTurmaId() {return turmaId;}

    public String getAno() {return ano;}

    public void setAno(String ano) {this.ano = ano;}

    public String getMentorId() {return mentorId;}

    public void setMentorId(String mentorId) { this.mentorId = mentorId;}

    @Override
    public String toString() {
        return "Turma: " + ano + " mentor: "+ mentorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(ano, turma.ano) && Objects.equals(mentorId, turma.mentorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, mentorId);
    }
}
