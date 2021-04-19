package com.desafio.mentoria.turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository  extends JpaRepository<Turma, Integer> {
}
