package com.desafio.mentoria.mentoria.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.desafio.mentoria.exception.ResourceNotFoundException;
import com.desafio.mentoria.mentoria.adapter.AlunoAdapter;
import com.desafio.mentoria.mentoria.adapter.MentoriaAdapter;
import com.desafio.mentoria.mentoria.model.Aluno;
import com.desafio.mentoria.mentoria.model.AlunoRequest;
import com.desafio.mentoria.mentoria.model.AlunoResponse;
import com.desafio.mentoria.mentoria.repository.AlunoRepository;
import com.desafio.mentoria.mentoria.repository.MentoriaRepository;

public class AlunoService {

	private final AlunoRepository alunoRepository;
	
	
    private final AlunoAdapter alunoAdapter;
    private final AlunoService alunoService;

    public AlunoService(AlunoRepository alunoRepository,
                           AlunoAdapter alunoAdapter,
                           AlunoService alunoService) {
        this.alunoRepository = alunoRepository;
        this.alunoAdapter = alunoAdapter;
		this.alunoService = alunoService;
       
    }

    @Transactional(readOnly = true)
    public List<AlunoResponse> findAll(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunoAdapter.alunoToAlunoResponse(alunos);
    }
    

    @Transactional(readOnly = true)
    public AlunoResponse findById(final Long id){
        return alunoRepository.findById(id)
                .map(alunoAdapter::alunoToAlunoResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrada."));
    }

    @Transactional
    public long cadastrar(final AlunoRequest alunoRequest){
        Aluno aluno = alunoAdapter.alunoRequestToAluno(alunoRequest);
        alunoRepository.save(aluno);
        return aluno.getId();
    }

    @Transactional
    public void update(final AlunoRequest alunoRequest, final Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrada."));

        alunoAdapter.updateAlunoByAlunoRequest(aluno, alunoRequest);
        alunoRepository.save(aluno);
    }

    @Transactional
    public void deleteById(final Long id){
        alunoRepository.deleteById(id);
 
	}

}
