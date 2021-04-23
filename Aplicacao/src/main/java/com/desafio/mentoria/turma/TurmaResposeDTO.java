package com.desafio.mentoria.turma;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access =  AccessLevel.PRIVATE)
public class TurmaResposeDTO {

    private Integer turmaId;
    private String ano;
    private String mentorId;

    public static TurmaResposeDTO toDTO (Turma turma){
        return new TurmaResposeDTO(turma.getTurmaId(),turma.getAno(),turma.getMentorId());
    }


}
