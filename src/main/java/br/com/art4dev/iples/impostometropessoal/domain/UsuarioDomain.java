package br.com.art4dev.iples.impostometropessoal.domain;

import java.util.List;

import br.com.art4dev.iples.impostometropessoal.model.Usuario;

public interface UsuarioDomain {
	
	Usuario save(Usuario usuario) throws Exception;
	
	List<Usuario> findAll();
	
	Usuario findById(Long fbid);
	
}