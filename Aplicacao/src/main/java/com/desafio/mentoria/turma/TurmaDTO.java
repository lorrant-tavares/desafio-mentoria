package com.desafio.mentoria.turma;

import lombok.Getter;

@Getter
public class TurmaDTO {
    private String ano;
    private String mentorId;

    public Turma transformaParaObjeto(){
        return new Turma(ano, mentorId);
    }

}
