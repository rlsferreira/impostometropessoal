package br.com.art4dev.iples.impostometropessoal.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

public class Configuration {

	@Produces
	@ApplicationScoped
	public MongoOperations mongoOperations() throws Exception {
		return new MongoTemplate(new MongoClient(), "impostometropessoal");
	}

}
