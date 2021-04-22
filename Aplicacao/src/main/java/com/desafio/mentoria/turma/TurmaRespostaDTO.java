package com.desafio.mentoria.turma;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access =  AccessLevel.PRIVATE)
public class TurmaRespostaDTO {

    private Integer turmaId;
    private String ano;
    private String mentorId;

    public static TurmaRespostaDTO toDTO (Turma turma){
        return new TurmaRespostaDTO(turma.getTurmaId(),turma.getAno(),turma.getMentorId());
    }


}
