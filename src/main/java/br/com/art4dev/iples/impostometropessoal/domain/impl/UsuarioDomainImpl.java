package br.com.art4dev.iples.impostometropessoal.domain.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.art4dev.iples.impostometropessoal.domain.UsuarioDomain;
import br.com.art4dev.iples.impostometropessoal.model.Usuario;
import br.com.art4dev.iples.impostometropessoal.repository.UsuarioRepository;

@Service
public class UsuarioDomainImpl implements UsuarioDomain {
	
	@Autowired
	public UsuarioRepository	usuarioRepository;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.art4dev.iples.impostometropessoal.domain.CalculoImpostosDomain
	 * #getAllUsuarios()
	 */
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.art4dev.iples.impostometropessoal.domain.CalculoImpostosDomain
	 * #getUsuarioById(java.lang.String)
	 */
	@Override
	public Usuario findById(Long fbid) {
		return usuarioRepository.findById(fbid);
	}
	
	@Override
	public Usuario save(Usuario usuario) throws Exception {

		usuarioRepository.save(usuario);
		return usuario;

	}
}