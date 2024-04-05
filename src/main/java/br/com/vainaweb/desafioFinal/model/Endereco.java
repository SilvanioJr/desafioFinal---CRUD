package br.com.vainaweb.desafioFinal.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {

	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	private Integer numero; 
}
