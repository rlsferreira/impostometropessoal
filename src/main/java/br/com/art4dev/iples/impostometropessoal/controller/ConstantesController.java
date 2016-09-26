package br.com.art4dev.iples.impostometropessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.art4dev.iples.impostometropessoal.domain.ConstanteDomain;
import br.com.art4dev.iples.impostometropessoal.model.Constante;

@RestController
@RequestMapping("/api")
public class ConstantesController {

	@Autowired
	private ConstanteDomain	constanteDomain;

	
    @RequestMapping(value = "/constantes/findAll", method = RequestMethod.GET)
	public List<Constante> findConstantesAll() {
		return constanteDomain.findAll();
	}
	
    @RequestMapping(value = "/constantes/criar", method = RequestMethod.GET)
	public List<Constante> criar() {
    	
    	Constante a = new Constante();
    	a.setId(1L);
    	a.setNome("INFLACAO");
    	a.setValor("10");
        constanteDomain.save(a);
        
    	Constante b = new Constante();
    	b.setId(2L);
    	b.setNome(ConstanteDomain.IMPOSTOS_TOTAL_SEGUNDO);
    	b.setValor("23500");
        constanteDomain.save(b);
        
    	Constante c = new Constante();
    	c.setId(3L);
    	c.setNome(ConstanteDomain.IMPOSTOS_FEDERAIS);
    	c.setValor("68.47");
        constanteDomain.save(c);
        
    	Constante d = new Constante();
    	d.setId(4L);
    	d.setNome(ConstanteDomain.IMPOSTOS_ESTADUAIS);
    	d.setValor("25.35");
        constanteDomain.save(d);
        
    	Constante e = new Constante();
    	e.setId(5L);
    	e.setNome(ConstanteDomain.IMPOSTOS_MUNICIPAIS);
    	e.setValor("6.19");
        constanteDomain.save(e);
        
    	return this.findConstantesAll();
	}
	

}
