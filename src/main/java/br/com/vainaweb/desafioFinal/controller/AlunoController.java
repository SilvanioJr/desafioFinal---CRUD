package br.com.vainaweb.desafioFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.desafioFinal.DTO.DadosAluno;
import br.com.vainaweb.desafioFinal.DTO.DadosAtualizados;
import br.com.vainaweb.desafioFinal.model.AlunoModel;
import br.com.vainaweb.desafioFinal.repository.AlunoRepository;
import br.com.vainaweb.desafioFinal.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno-teste")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public List<AlunoModel> encontrarAlunos(){
		return service.encontrarAlunos();
	}
	
	@GetMapping("/{id}")
	public Optional<AlunoModel> encontrarUmAlunoPorId(@PathVariable Long id){
		var c = service.encontrarUmAluno(id);
		return c;
	}
	
	@PostMapping
	public ResponseEntity<String> cadastrarColaborador(@RequestBody DadosAluno dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dados));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizados dados) {
		var aluno = repository.getReferenceById(id);
		aluno.atualizarInfo(dados);
		repository.save(aluno);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deletado com sucesso!";
	}
	

}

