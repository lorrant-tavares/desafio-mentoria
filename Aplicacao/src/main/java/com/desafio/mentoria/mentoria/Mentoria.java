package com.desafio.mentoria.mentoria;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Mentoria {

    private Long id;

    private Date data;

    private String aluno;

    private String mentor;

    private String conteudo;

    public Mentoria() {}

    public Mentoria(Long id, Date data, String aluno, String conteudo) {
        this.id = id;
        this.data = data;
        this.aluno = aluno;
        this.mentor = aluno;//Mudar para aluno.mentor quando a classe aluno e mentor existir
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
        this.mentor = aluno; //Mudar para aluno.mentor quando tiver classe aluno e mentor
    }

    public String getMentor() {
        return mentor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "id=" + id +
                ", data=" + data +
                ", aluno='" + aluno + '\'' +
                ", mentor='" + mentor + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
