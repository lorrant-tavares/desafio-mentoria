package com.desafio.mentoria.aluno;


public class Aluno {
	
	private String nome;
	private String matricula;
	private String cpf;
	private String nascimento;
	
	
	public Aluno(String nome,  String matricula, String cpf, String nascimento) {
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.nascimento = nascimento;
		}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome( String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	 @Override
	    public String toString() {
	        return "Aluno: " + this.nome + "\n" + "Matricula:" + this.matricula + "\n" + "CPF: " + this.cpf + "\n" + "Data de Nascimento: " + this.nascimento;
	    }


}
