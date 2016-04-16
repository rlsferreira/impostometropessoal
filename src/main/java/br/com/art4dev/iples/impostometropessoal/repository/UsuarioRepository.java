package br.com.art4dev.iples.impostometropessoal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.art4dev.iples.impostometropessoal.model.Usuario;

public interface UsuarioRepository  extends MongoRepository<Usuario, Long> {

    public Usuario findById(Long id);
    public List<Usuario> findByNome(String nome);


}
