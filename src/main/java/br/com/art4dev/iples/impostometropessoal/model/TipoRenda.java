package br.com.art4dev.iples.impostometropessoal.model;

import br.com.art4dev.iples.impostometropessoal.domain.trabalho.ContratoTrabalho;
import br.com.art4dev.iples.impostometropessoal.domain.trabalho.ContratoTrabalhoAposentadoria;
import br.com.art4dev.iples.impostometropessoal.domain.trabalho.ContratoTrabalhoBeneficios;
import br.com.art4dev.iples.impostometropessoal.domain.trabalho.ContratoTrabalhoCLT;
import br.com.art4dev.iples.impostometropessoal.domain.trabalho.ContratoTrabalhoLiberalFormal;
import br.com.art4dev.iples.impostometropessoal.domain.trabalho.ContratoTrabalhoLiberalInformal;

public enum TipoRenda {
	
	FUNCIONARIO_INICIATIVA_PRIVADA(1, ContratoTrabalhoCLT.class), FUNCIONARIO_PUBLICO(2, ContratoTrabalhoBeneficios.class), PROFISSIONAL_LIBERAL(
	        3, ContratoTrabalhoLiberalFormal.class), PROFISSIONAL_INFORMAL(4, ContratoTrabalhoLiberalInformal.class), APOSENTADO(
	        5, ContratoTrabalhoAposentadoria.class);
	
	private int	                              codigo;
	private Class<? extends ContratoTrabalho>	contratoTrabalho;
	
	TipoRenda(int codigo, Class<? extends ContratoTrabalho> contratoTrabalho) {
		this.codigo = codigo;
		this.setContratoTrabalho(contratoTrabalho);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public Class<? extends ContratoTrabalho> getContratoTrabalho() {
		return contratoTrabalho;
	}
	
	public void setContratoTrabalho(Class<? extends ContratoTrabalho> contratoTrabalho) {
		this.contratoTrabalho = contratoTrabalho;
	}
	
	public static TipoRenda getTipoRendaByCodigo(int codigo) {
		for (TipoRenda e : values()) {
			if (e.getCodigo() == codigo)
				return e;
		}
		return null;
	}
	
}
