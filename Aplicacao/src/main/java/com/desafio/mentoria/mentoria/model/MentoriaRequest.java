package com.desafio.mentoria.mentoria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentoriaRequest {

    private Long alunoid;

    private String data;

    private String conteudo;
}
