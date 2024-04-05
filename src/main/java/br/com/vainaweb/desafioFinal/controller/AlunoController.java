package br.com.vainaweb.desafioFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.desafioFinal.DTO.DadosAluno;
import br.com.vainaweb.desafioFinal.model.AlunoModel;
import br.com.vainaweb.desafioFinal.service.AlunoService;

@RestController
@RequestMapping("/aluno-teste")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
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
	public String cadastrarColaborador(@RequestBody DadosAluno dados) {
		service.cadastrar(dados);
		return "OK";
	}

}

