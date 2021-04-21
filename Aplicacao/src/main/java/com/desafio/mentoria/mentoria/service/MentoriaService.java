package com.desafio.mentoria.mentoria.service;

import com.desafio.mentoria.exception.ResourceNotFoundException;
import com.desafio.mentoria.mentoria.Mentoria;
import com.desafio.mentoria.mentoria.repository.MentoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MentoriaService {
    private final MentoriaRepository mentoriaRepository;

    public MentoriaService(MentoriaRepository mentoriaRepository) {
        this.mentoriaRepository = mentoriaRepository;
    }

    @Transactional(readOnly = true)
    public List<Mentoria> findAll(){
        return mentoriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Mentoria findById(final Long id){
        return mentoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentoria não encontrada."));
    }

    @Transactional //ELe não salva(Commita) se der algum erro
    public void create(final Mentoria mentoria){
        mentoriaRepository.save(mentoria);
    }

    @Transactional
    public void update(final Mentoria mentoria, final Long id){
        mentoria.setId(id);

        mentoriaRepository.save(mentoria);
    }

    @Transactional
    public void deleteById(final Long id){
        mentoriaRepository.deleteById(id);
    }
}
