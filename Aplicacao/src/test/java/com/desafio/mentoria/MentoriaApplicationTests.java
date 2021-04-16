package com.desafio.mentoria;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.mentoria.aluno.Aluno;

@SpringBootTest
class MentoriaApplicationTests {

	@Test
	void contextLoads() {
	}
	
	//Aluno alunos = new Aluno("Clayton", "2201", "031.132.155-01", "02/08/1987");
	
	public static void main(String[] args) {
		Aluno alunos = new Aluno("Clayton", "2201", "031.132.155-01", "02/08/1987");
		
		System.out.println(alunos);
	}
	

}
