package com.desafio.mentoria.mentoria.adapter;

import com.desafio.mentoria.mentoria.model.Turma;
import com.desafio.mentoria.mentoria.model.TurmaRequest;
import com.desafio.mentoria.mentoria.model.TurmaResponse;
import org.springframework.stereotype.Component;

@Component
public class TurmaAdapter {


    public static Turma toObject(TurmaRequest turmaRequest){
        return new Turma(turmaRequest.getAno(),
                turmaRequest.getMentorId());
    }
    public static TurmaResponse toResponse(Turma turma){
        return new TurmaResponse(turma.getTurmaId(),turma.getAno(),turma.getMentorId());
    }
}
