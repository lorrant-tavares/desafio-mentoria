package com.desafio.mentoria.mentoria.repository;

import com.desafio.mentoria.mentoria.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoriaRepository extends JpaRepository<Mentoria, Long> {
}
