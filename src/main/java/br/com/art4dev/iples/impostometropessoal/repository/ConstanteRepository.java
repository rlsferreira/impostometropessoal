package br.com.art4dev.iples.impostometropessoal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.art4dev.iples.impostometropessoal.model.Constante;

public interface ConstanteRepository extends MongoRepository<Constante, Long> {
	
	public Constante findById(Long id);
	
	public Constante findByNome(String nome);
	
}
