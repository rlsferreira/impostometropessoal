package br.com.art4dev.iples.impostometropessoal.configuration;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;

public class DevMongoDBFactoryConfig {
 
    /* (non-Javadoc)
     * @see com.openshift.notebook.core.config.MongoDbConfig#mongoDbFactory()
     */
    @SuppressWarnings("deprecation")
   // @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        Mongo mongo = new Mongo("localhost", 27017);
		String databaseName = "impostometropessoaldb";
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo,
                databaseName);
        return mongoDbFactory;
    }
 
}