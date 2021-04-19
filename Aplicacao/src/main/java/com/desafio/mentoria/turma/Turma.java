package com.desafio.mentoria.turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Turma {

    private Integer turmaId;
    private String ano;
    private String mentor;


    public Turma (){}

    public Turma(String ano,  String mentor) {
        this.ano = ano;
        this.mentor = mentor;
    }

    public Integer getTurmaId() {return turmaId;}

    public String getAno() {return ano;}

    public void setAno(String ano) {this.ano = ano;}

    public String getMentor() {return mentor;}

    public void setMentor(String mentor) { this.mentor = mentor;}

    @Override
    public String toString() {
        return "Turma: " + ano + " mentor: "+mentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(ano, turma.ano) && Objects.equals(mentor, turma.mentor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, mentor);
    }
}
