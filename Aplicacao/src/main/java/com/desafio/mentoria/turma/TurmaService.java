package com.desafio.mentoria.turma;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    @Autowired
    public TurmaService (TurmaRepository turmaRepository){this.turmaRepository = turmaRepository;}

    public List<Turma> getTurmas() { return turmaRepository.findAll();}

    public Turma getTurma(int id) {
        return turmaRepository
                    .findById(id)
                    .orElseThrow(() -> new RuntimeException("Turma não encontrada: "+id));}

    public Turma postTurma(Turma turma) { return turmaRepository.save(turma); }

    public void deleteTurma(Integer id) {
        if(!turmaRepository.existsById(id)){throw new IllegalArgumentException("Turma Inexistente");}
        turmaRepository.deleteById(id);
    }

    @Transactional
    public void updateTurma(Integer id, Turma turma) {
        Turma turmaEncontrada =  turmaRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Turma não encontrada: "+id));
        updateSeValido(turma, turmaEncontrada);
    }

    private void updateSeValido(Turma turma, Turma turmaEncontrada) {
        if(campoValido(turma.getAno(), turmaEncontrada.getAno()))
            turmaEncontrada.setAno(turma.getAno());

        if(campoValido(turma.getMentorId(), turmaEncontrada.getMentorId()))
            turmaEncontrada.setMentorId(turma.getMentorId());
    }

    private boolean campoValido(String campoNovo, String campoEncontrado){
        return true;
        //return StringUtils.isEmpty(campoNovo) && !StringUtils.equals(campoNovo, campoEncontrado);
    }
}
