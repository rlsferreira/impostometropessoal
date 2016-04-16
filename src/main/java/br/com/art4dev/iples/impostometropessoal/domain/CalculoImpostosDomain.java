package br.com.art4dev.iples.impostometropessoal.domain;

import java.util.List;

import br.com.art4dev.iples.impostometropessoal.model.TabelaImpostos;
import br.com.art4dev.iples.impostometropessoal.model.Usuario;

public interface CalculoImpostosDomain {

	/**
	 * 
	 * @param usuario
	 * @param tabelaImpostos
	 * @return
	 * @throws Exception
	 */
	public abstract Usuario executaCalculosParaUsuario(TabelaImpostos tabelaImpostos)
			throws Exception;

	public abstract Usuario save(Long id, String nome,
			String comentario, boolean postar, Usuario usuario)
			throws Exception;

	public abstract List<Usuario> getAllUsuarios();

	public abstract Usuario getUsuarioById(Long fbid);

}