package com.desafio.mentoria.mentoria.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access =  AccessLevel.PRIVATE)
public class TurmaRespose {

    private Integer turmaId;
    private String ano;
    private String mentorId;

    public static TurmaRespose toDTO (Turma turma){
        return new TurmaRespose(turma.getTurmaId(),turma.getAno(),turma.getMentorId());
    }


}
