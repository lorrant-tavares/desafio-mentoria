package com.desafio.mentoria.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void postTurma(Turma turma) {
        Optional<Turma> turmaOptional = turmaRepository.findById(turma.getTurmaId());
        turmaOptional.ifPresentOrElse(
                (turmaEncontrada) -> {
                    throw new RuntimeException("Turma já cadastrada"+turmaEncontrada.getTurmaId());},
                () -> turmaRepository.save(turma));
    }

    public void deleteTurma(Integer id) {
        if(!turmaRepository.existsById(id)){throw new IllegalArgumentException("Turma Inexistente");}
        turmaRepository.deleteById(id);
    }

    public void updateTurma(Integer id, Turma turma) {
        Turma turmaEncontrada =  turmaRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Turma não encontrada: "+id));
        if(campoValido(turma.getAno(), turmaEncontrada.getAno()))
            turmaEncontrada.setAno(turma.getAno());
        if(campoValido(turma.getMentor(), turmaEncontrada.getMentor()))
            turmaEncontrada.setMentor(turma.getMentor());
    }
    private boolean campoValido(String campoNovo, String campoEncontrado){
        return campoNovo.length() > 0 && !Objects.equals(campoEncontrado, campoNovo);
    }
}
