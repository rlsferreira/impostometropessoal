package br.com.art4dev.iples.impostometropessoal.controller;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.art4dev.iples.impostometropessoal.domain.CalculoImpostosDomain;
import br.com.art4dev.iples.impostometropessoal.domain.ContratoTrabalho;
import br.com.art4dev.iples.impostometropessoal.domain.ContratoTrabalhoCLT;
import br.com.art4dev.iples.impostometropessoal.domain.ContratoTrabalhoLiberalFormal;
import br.com.art4dev.iples.impostometropessoal.model.Renda;
import br.com.art4dev.iples.impostometropessoal.model.TabelaImpostos;
import br.com.art4dev.iples.impostometropessoal.model.Usuario;

@RestController
public class CalculoImpostos {
	
	@Autowired
	private CalculoImpostosDomain	calculoImpostosDomain;
	
	@RequestMapping(value = "/calculo/{id}", method = RequestMethod.GET)
	public Usuario getUsuario(@PathVariable("id") long id) {
		return calculoImpostosDomain.getUsuarioById(id);
	}

	
	@RequestMapping(value = "/calcular/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Usuario calcular(@PathVariable("id") long id, UriComponentsBuilder ucBuilder) {
		
		TabelaImpostos tabelaImpostos = new TabelaImpostos();
		ContratoTrabalho contrato = new ContratoTrabalhoLiberalFormal();
		Renda renda = new Renda();
		renda.setDependentes(2);
		renda.setRenda(10000);
		contrato.setRenda(renda);
		tabelaImpostos.addContratoTrabalho(contrato);

		tabelaImpostos.setValorTotalImoveis(0);
		tabelaImpostos.setValorTotalVeiculos(15000);
		
		tabelaImpostos.setFinanciamentoImovel(0);
		tabelaImpostos.setFinanciamentoVeiculo(0);
		tabelaImpostos.setAluguel(1700);
		tabelaImpostos.setSupermercado(1000);
		tabelaImpostos.setSaude(300);
		tabelaImpostos.setConcessionarias(500);
		tabelaImpostos.setEducacao(2300);
		tabelaImpostos.setTransporte(400);
		tabelaImpostos.setVestuario(50);
		tabelaImpostos.setOutros(2000);
		
		Usuario usuario = new Usuario();
		try {
			usuario = calculoImpostosDomain.executaCalculosParaUsuario(tabelaImpostos);
	        usuario = calculoImpostosDomain.save(22L, "Medio", "Classe média sofre", false, usuario);
        } catch (Exception e) {
        	System.out.println(System.getenv("OPENSHIFT_MONGODB_DB_HOST"));
        System.out.println(System.getenv("OPENSHIFT_MONGODB_DB_PORT"));
        System.out.println(System.getenv("OPENSHIFT_MONGODB_DB_USERNAME"));
        System.out.println(System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD"));
	        e.printStackTrace();
        }
		
		return usuario;
	}
	
	
	@RequestMapping(value = "/user/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void> impostos(@RequestBody TabelaImpostos tabelaImpostos, UriComponentsBuilder ucBuilder) {
		
		/*
		 * if (getFloatParameter(request, "trabalhador.rendaclt") > 0) {
		 * ContratoTrabalho contrato = new ContratoTrabalhoCLT(); Renda renda =
		 * new Renda(); renda.setDependentes(getIntParameter(request,
		 * "trabalhador.dependentes"));
		 * renda.setRenda(getFloatParameter(request, "trabalhador.rendaclt"));
		 * contrato.setRenda(renda);
		 * tabelaImpostos.addContratoTrabalho(contrato); }
		 * 
		 * if (getFloatParameter(request, "trabalhador.beneficios") > 0) {
		 * ContratoTrabalho contrato = new ContratoTrabalhoBeneficios(); Renda
		 * renda = new Renda(); renda.setDependentes(getIntParameter(request,
		 * "trabalhador.dependentes"));
		 * renda.setRenda(getFloatParameter(request, "trabalhador.beneficios"));
		 * contrato.setRenda(renda);
		 * tabelaImpostos.addContratoTrabalho(contrato); }
		 * 
		 * if (getFloatParameter(request, "trabalhador.rendaliberal") > 0) {
		 * ContratoTrabalho contrato = new ContratoTrabalhoLiberalFormal();
		 * Renda renda = new Renda();
		 * renda.setDependentes(getIntParameter(request,
		 * "trabalhador.dependentes"));
		 * renda.setRenda(getFloatParameter(request,
		 * "trabalhador.rendaliberal")); contrato.setRenda(renda);
		 * tabelaImpostos.addContratoTrabalho(contrato); }
		 * 
		 * if (getFloatParameter(request, "trabalhador.rendainformal") > 0) {
		 * ContratoTrabalho contrato = new ContratoTrabalhoLiberalInformal();
		 * Renda renda = new Renda();
		 * renda.setDependentes(getIntParameter(request,
		 * "trabalhador.dependentes"));
		 * renda.setRenda(getFloatParameter(request,
		 * "trabalhador.rendainformal")); contrato.setRenda(renda);
		 * tabelaImpostos.addContratoTrabalho(contrato); }
		 * 
		 * if (getFloatParameter(request, "trabalhador.aposentadoria") > 0) {
		 * ContratoTrabalho contrato = new ContratoTrabalhoAposentadoria();
		 * Renda renda = new Renda();
		 * renda.setDependentes(getIntParameter(request,
		 * "trabalhador.dependentes"));
		 * renda.setRenda(getFloatParameter(request,
		 * "trabalhador.aposentadoria")); contrato.setRenda(renda);
		 * tabelaImpostos.addContratoTrabalho(contrato); }
		 * 
		 * tabelaImpostos.setValorTotalImoveis(getFloatParameter(request,
		 * "tabelaimposto.totalimoveis"));
		 * tabelaImpostos.setValorTotalVeiculos(getFloatParameter(request,
		 * "tabelaimposto.totalveiculos"));
		 * 
		 * tabelaImpostos.setFinanciamentoImovel(getFloatParameter(request,
		 * "tabelaimposto.financiamentoimoveis"));
		 * tabelaImpostos.setFinanciamentoVeiculo(getFloatParameter(request,
		 * "tabelaimposto.financiamentoveiculos"));
		 * tabelaImpostos.setAluguel(getFloatParameter(request,
		 * "tabelaimposto.aluguel"));
		 * tabelaImpostos.setSupermercado(getFloatParameter(request,
		 * "tabelaimposto.supermercado"));
		 * tabelaImpostos.setSaude(getFloatParameter(request,
		 * "tabelaimposto.saude"));
		 * tabelaImpostos.setConcessionarias(getFloatParameter(request,
		 * "tabelaimposto.concessionarias"));
		 * tabelaImpostos.setEducacao(getFloatParameter(request,
		 * "tabelaimposto.educacao"));
		 * tabelaImpostos.setTransporte(getFloatParameter(request,
		 * "tabelaimposto.transporte"));
		 * tabelaImpostos.setVestuario(getFloatParameter(request,
		 * "tabelaimposto.vestuario"));
		 * tabelaImpostos.setOutros(getFloatParameter(request,
		 * "tabelaimposto.outros"));
		 */
		
		Usuario usuario;
		try {
			usuario = calculoImpostosDomain.executaCalculosParaUsuario(tabelaImpostos);
			calculoImpostosDomain.save(1L, "teste", "", false, usuario);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/calculo/{id}").buildAndExpand(usuario.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
	
	public void deleteUsuario(@PathParam("id") Long id) {
	}
	
}
