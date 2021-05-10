package com.desafio.mentoria.mentoria.adapter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.desafio.mentoria.mentoria.model.Aluno;
import com.desafio.mentoria.mentoria.model.AlunoResponse;
import com.desafio.mentoria.mentoria.model.Mentoria;
import com.desafio.mentoria.mentoria.model.MentoriaRequest;
import com.desafio.mentoria.mentoria.model.AlunoRequest;

@Component
public class AlunoAdapter {
	
	public AlunoResponse alunoToAlunoResponse(Aluno aluno) {
		AlunoResponse alunoResponse = new AlunoResponse();
		
		alunoResponse.setId(aluno.getId());
        alunoResponse.setCpf(aluno.getCpf());
        alunoResponse.setNome(alunoResponse.getNome());
        alunoResponse.setMatricula(alunoResponse.getMatricula());
		return alunoResponse;
	}

	public List<AlunoResponse> alunoToAlunoResponse(List<Aluno> alunos) {
		return alunos.stream()
				.map(this::alunoToAlunoResponse)
				.collect(Collectors.toList());
	}
	public Aluno alunoRequestToAluno(AlunoRequest alunoRequest) {
		
		return null;
	}
}
