package com.desafio.mentoria.turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Turma {

    private String ano;

    //depois vai ser injetado pelo spring
    private List<String> alunos = new ArrayList<>(0);

    private String mentor;

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public Turma(String ano, List<String> alunos, String mentor) {
        this.ano = ano;
        this.alunos = alunos;
        this.mentor = mentor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public List<String> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma: " + ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(ano, turma.ano) && Objects.equals(alunos, turma.alunos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, alunos);
    }
}
