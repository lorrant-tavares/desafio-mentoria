package com.desafio.mentoria.mentoria.model;

import lombok.Getter;

@Getter
public class TurmaRequest {
    private String ano;
    private String mentorId;

    public Turma toObject(){
        return new Turma(ano, mentorId);
    }

}
