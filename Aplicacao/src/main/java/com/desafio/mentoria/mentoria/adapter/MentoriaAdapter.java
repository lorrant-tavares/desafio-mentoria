package com.desafio.mentoria.mentoria.adapter;

import com.desafio.mentoria.mentoria.model.Mentoria;
import com.desafio.mentoria.mentoria.model.MentoriaRequest;
import com.desafio.mentoria.mentoria.model.MentoriaResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MentoriaAdapter {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MentoriaResponse mentoriaToMentoriaResponse(final Mentoria mentoria){
        final MentoriaResponse mentoriaResponse = new MentoriaResponse();

        mentoriaResponse.setId(mentoria.getId());
        mentoriaResponse.setData(mentoria.getData().format(dateFormatter));
        mentoriaResponse.setConteudo(mentoria.getConteudo());
        mentoriaResponse.setAluno(mentoriaResponse.getAluno());
        mentoriaResponse.setMentor(mentoriaResponse.getMentor());
        mentoriaResponse.setCriadoEm(mentoria.getCriadoEm().format(dateTimeFormatter));
        mentoriaResponse.setAtualizadoEm(mentoria.getAtualizadoEm().format(dateTimeFormatter));

        return mentoriaResponse;
    }

    public List<MentoriaResponse> mentoriaToMentoriaResponse(final List<Mentoria> mentorias){
        return mentorias.stream()
                .map(this::mentoriaToMentoriaResponse)
                .collect(Collectors.toList());
    }

    public Mentoria mentoriaRequestToMentoria(final MentoriaRequest mentoriaRequest){
        final Mentoria mentoria = new Mentoria();

        mentoria.setData(LocalDate.parse(mentoriaRequest.getData()));
        mentoria.setConteudo(mentoriaRequest.getConteudo());

        return mentoria;
    }

    public void updateMentoriaByMentoriaRequest(final Mentoria mentoria, final MentoriaRequest mentoriaRequest){

        mentoria.setData(LocalDate.parse(mentoriaRequest.getData()));
        mentoria.setConteudo(mentoriaRequest.getConteudo());
    }
}
