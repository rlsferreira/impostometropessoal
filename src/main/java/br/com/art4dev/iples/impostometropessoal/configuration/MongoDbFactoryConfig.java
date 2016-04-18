package br.com.art4dev.iples.impostometropessoal.configuration;

import org.springframework.data.mongodb.MongoDbFactory;

public interface MongoDbFactoryConfig {
	
	MongoDbFactory mongoDbFactory() throws Exception;
}
