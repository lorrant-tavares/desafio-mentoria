package com.desafio.mentoria.mentoria.repository;

import com.desafio.mentoria.mentoria.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository  extends JpaRepository<Turma, Integer> {
}
