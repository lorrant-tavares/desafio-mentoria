package com.desafio.mentoria.mentoria.controller;

import com.desafio.mentoria.mentoria.model.MentoriaRequest;
import com.desafio.mentoria.mentoria.model.MentoriaResponse;
import com.desafio.mentoria.mentoria.service.MentoriaService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mentoria")
public class MentoriaController {
    private final MentoriaService mentoriaService;

    public MentoriaController(MentoriaService mentoriaService) {
        this.mentoriaService = mentoriaService;
    }

    @GetMapping
    public List<MentoriaResponse> findAll(){
        return mentoriaService.findAll();
    }

    @GetMapping("/{id}")
    public MentoriaResponse findById(@PathVariable final Long id){
        return mentoriaService.findById(id);
    }

    @PostMapping
    public HttpEntity<?> create(@Validated @RequestBody MentoriaRequest mentoriaRequest){
        final Long id = mentoriaService.create(mentoriaRequest);
        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/mentoria/{id}").build(id);

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable final Long id, @Validated @RequestBody MentoriaRequest mentoriaRequest){
        mentoriaService.update(mentoriaRequest, id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable final Long id) {
        mentoriaService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
