package com.desafio.mentoria.mentoria.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentoriaResponse {

    private Long id;

    private String data;

    private String aluno;

    private String mentor;

    private String conteudo;

    private String criadoEm;

    private String atualizadoEm;
}
