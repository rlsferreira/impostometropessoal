package br.com.art4dev.iples.impostometropessoal.domain;

import br.com.art4dev.iples.impostometropessoal.domain.tabela.TabelaImpostos;
import br.com.art4dev.iples.impostometropessoal.model.Usuario;

public interface CalculoImpostosDomain {
	
	/**
	 * 
	 * @param usuario
	 * @param tabelaImpostos
	 * @return
	 * @throws Exception
	 */
	Usuario executaCalculosParaUsuario(TabelaImpostos tabelaImpostos) throws Exception;
	
}