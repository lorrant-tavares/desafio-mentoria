package com.desafio.mentoria.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/mentoria/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;


    public TurmaController (TurmaService turmaService){this.turmaService = turmaService;}

    @GetMapping
    public List<Turma> getTurmas (){return turmaService.getTurmas();}

    @GetMapping(value = "{id}")
    public Turma getTurma (@PathVariable("id") Integer id){return turmaService.getTurma(id);}

    @PostMapping
    public void postTurma (@RequestBody Turma turma){
        turmaService.postTurma();
    }

    @DeleteMapping(value = "{id}")
    public void deleteTurma(@PathVariable("id") Integer id ){turmaService.deleteTurma(id);}

    @PutMapping(value = "{id}")
    public void updateTurma(@PathVariable("id") Integer id,
                            @RequestBody Turma turma)
    {turmaService.updateTurma(id, turma);}


}

