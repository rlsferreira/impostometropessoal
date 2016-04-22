package br.com.art4dev.iples.impostometropessoal.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Mongo;

@Configuration
//@Profile("dev")
public class OpenShiftMongoDBFactoryConfig implements MongoDbFactoryConfig {
 
    @SuppressWarnings("deprecation")
    @Override
    public MongoDbFactory mongoDbFactory() throws Exception {
 
    	String openshiftMongoDbHost = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
        int openshiftMongoDbPort = Integer.parseInt(System.getenv("OPENSHIFT_MONGODB_DB_PORT"));
        String username = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
        Mongo mongo = new Mongo(openshiftMongoDbHost, openshiftMongoDbPort);
        UserCredentials userCredentials = new UserCredentials(username,password);
        String databaseName = System.getenv("OPENSHIFT_APP_NAME");
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName, userCredentials);
        return mongoDbFactory;

    }
 
 	
}