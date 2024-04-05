package br.com.vainaweb.desafioFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.desafioFinal.DTO.DadosAluno;
import br.com.vainaweb.desafioFinal.model.AlunoModel;
import br.com.vainaweb.desafioFinal.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<AlunoModel> encontrarAlunos(){
		return repository.findAll();
	}
	
	public Optional<AlunoModel> encontrarUmAluno(Long id){
		return repository.findById(id);
	}
	
	public String cadastrar(DadosAluno dados) {
		
		var aluno = repository.findByCpf(dados.cpf());
		
		if(aluno.isPresent()) {
			return "CPF já cadastrado!";
		} else {
			repository.save(new AlunoModel(dados));
			return "Cadastro efetuado com sucesso!";
		}
		
		
	}
	
}
