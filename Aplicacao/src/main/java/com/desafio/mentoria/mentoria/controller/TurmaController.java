package com.desafio.mentoria.mentoria.controller;

import com.desafio.mentoria.mentoria.model.Turma;
import com.desafio.mentoria.mentoria.model.TurmaRequest;
import com.desafio.mentoria.mentoria.model.TurmaResponse;
import com.desafio.mentoria.mentoria.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/mentoria/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;


    public TurmaController (TurmaService turmaService){this.turmaService = turmaService;}

    @GetMapping
    public List<TurmaResponse> getTurmas (){return turmaService.getTurmas();}

    @GetMapping(value = "/{id}")
    public TurmaResponse getTurma (@PathVariable("id") Integer id){return turmaService.getTurma(id);}

    @PostMapping
    public ResponseEntity<TurmaResponse> postTurma (@RequestBody TurmaRequest turmaRequest){
        TurmaResponse turmaResponse = turmaService.postTurma(turmaRequest);
        return new ResponseEntity<>(turmaResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTurma(@PathVariable("id") Integer id ){turmaService.deleteTurma(id);}

    @PutMapping(value = "/{id}")
    public ResponseEntity<TurmaResponse> updateTurma(@PathVariable("id") Integer id,
                                                     @RequestBody Turma turma){
        turmaService.updateTurma(id, turma);
        TurmaResponse turmaResponse = turmaService.getTurma(id);
        return new ResponseEntity<>(turmaResponse, HttpStatus.ACCEPTED);
    }


}

