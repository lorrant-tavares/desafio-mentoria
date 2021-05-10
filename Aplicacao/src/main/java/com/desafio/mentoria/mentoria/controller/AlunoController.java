package com.desafio.mentoria.mentoria.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.mentoria.mentoria.model.Aluno;
import com.desafio.mentoria.mentoria.model.AlunoResponse;
import com.desafio.mentoria.mentoria.model.AlunoRequest;
import com.desafio.mentoria.mentoria.model.MentoriaRequest;
import com.desafio.mentoria.mentoria.service.AlunoService;

import lombok.Getter;
import lombok.Setter;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private final AlunoService alunoService;
	
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	@GetMapping
	public List<AlunoResponse> findAll(){
		return alunoService.findAll();
	}
	
	@GetMapping("/{id}")
	public AlunoResponse detalhar(@PathVariable Long id) {
		return alunoService.findById(id);
	}
	
	@PostMapping
	@Transactional
	 public ResponseEntity<AlunoRequest> cadastrar(@Validated @RequestBody AlunoRequest alunoRequest){
		 final long id = alunoService.cadastrar(alunoRequest);
		 final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/aluno/{id}").build(id);

		 return ResponseEntity.created(location).build();
	}
	
	 @PutMapping("/{id}")
	 public ResponseEntity<AlunoRequest> update(@PathVariable final Long id, @Validated @RequestBody AlunoRequest alunoRequest){
	        alunoService.update(alunoRequest, id);

	        return ResponseEntity.noContent().build();
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> deleteById(@PathVariable final Long id) {
	        alunoService.deleteById(id);

	        return ResponseEntity.noContent().build();
	}	


}
