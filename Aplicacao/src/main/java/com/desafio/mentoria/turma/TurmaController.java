package com.desafio.mentoria.turma;

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
    public List<TurmaResposeDTO> getTurmas (){return turmaService.getTurmas();}

    @GetMapping(value = "/{id}")
    public TurmaResposeDTO getTurma (@PathVariable("id") Integer id){return turmaService.getTurma(id);}

    @PostMapping
    public ResponseEntity<TurmaResposeDTO> postTurma (@RequestBody TurmaDTO turmaDTO){
        Turma turma = turmaService.postTurma(turmaDTO.toObject());
        return new ResponseEntity<>(TurmaResposeDTO.toDTO(turma), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTurma(@PathVariable("id") Integer id ){turmaService.deleteTurma(id);}

    @PutMapping(value = "/{id}")
    public ResponseEntity<TurmaResposeDTO> updateTurma(@PathVariable("id") Integer id,
                                                       @RequestBody Turma turma){
        turmaService.updateTurma(id, turma);
        TurmaResposeDTO turmaResponse = turmaService.getTurma(id);
        return new ResponseEntity<>(turmaResponse, HttpStatus.ACCEPTED);
    }


}

