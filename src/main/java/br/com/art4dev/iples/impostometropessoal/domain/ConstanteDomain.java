package br.com.art4dev.iples.impostometropessoal.domain;

import java.util.List;

import br.com.art4dev.iples.impostometropessoal.model.Constante;

public interface ConstanteDomain {
	
	static final String IMPOSTOS_ESTADUAIS = "IMPOSTOS_ESTADUAIS";
	static final String IMPOSTOS_FEDERAIS = "IMPOSTOS_FEDERAIS";
	static final String IMPOSTOS_TOTAL_SEGUNDO = "IMPOSTOS_TOTAL_SEGUNDO";
    static final String IMPOSTOS_MUNICIPAIS = "IMPOSTOS_MUNICIPAIS";
	
	Constante getConstante(String name);

	List<Constante> findAll();

	Constante save(Constante constante);
	
}