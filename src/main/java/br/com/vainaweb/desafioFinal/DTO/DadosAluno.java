package br.com.vainaweb.desafioFinal.DTO;

import br.com.vainaweb.desafioFinal.enums.Curso;

public record DadosAluno(String nome, String email, String cpf, String telefone, Curso curso) {
	
}
