package br.com.art4dev.iples.impostometropessoal.configuration;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.core.MongoTemplate;

@org.springframework.context.annotation.Configuration
@ImportResource("classpath:spring-data.xml")
public class MongoDbConfig {
	
	@Inject
	private MongoDbFactoryConfig	mongoDbFactoryConfig;
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactoryConfig.mongoDbFactory());
		return mongoTemplate;
	}
}