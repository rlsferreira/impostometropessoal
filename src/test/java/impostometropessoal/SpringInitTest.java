package impostometropessoal;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.art4dev.iples.impostometropessoal.configuration.DevMongoDBFactoryConfig;
import br.com.art4dev.iples.impostometropessoal.configuration.MongoDbConfig;
import br.com.art4dev.iples.impostometropessoal.model.Usuario;
import br.com.art4dev.iples.impostometropessoal.repository.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DevMongoDBFactoryConfig.class,MongoDbConfig.class })
@ActiveProfiles("dev")
public class SpringInitTest {
	
	    @Inject
	    UsuarioRepository usuarioRepository;
	 
	    @Inject
	    MongoTemplate mongoTemplate;
	 
	    @Before
	    public void setup() {
	        mongoTemplate.dropCollection(Usuario.class);
	    }
	 
	    @Test
	    public void shouldSaveNotebookAndReturnCountAsOne() {
	    	usuarioRepository.save(new Usuario());
	        assertEquals(1, usuarioRepository.count());
	    }	
}
