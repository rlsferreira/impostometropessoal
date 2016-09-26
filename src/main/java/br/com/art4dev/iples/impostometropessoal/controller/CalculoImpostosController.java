package br.com.art4dev.iples.impostometropessoal.controller;

import javax.ws.rs.PathParam;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.art4dev.iples.impostometropessoal.domain.CalculoImpostosDomain;
import br.com.art4dev.iples.impostometropessoal.domain.ConstanteDomain;
import br.com.art4dev.iples.impostometropessoal.domain.UsuarioDomain;
import br.com.art4dev.iples.impostometropessoal.domain.tabela.TabelaImpostos;
import br.com.art4dev.iples.impostometropessoal.domain.trabalho.ContratoTrabalho;
import br.com.art4dev.iples.impostometropessoal.model.Renda;
import br.com.art4dev.iples.impostometropessoal.model.TipoRenda;
import br.com.art4dev.iples.impostometropessoal.model.Usuario;
import br.com.art4dev.iples.impostometropessoal.to.ParametrosCalculoImpostoIndividual;

@RestController
@RequestMapping("/api/calculo")
public class CalculoImpostosController {
	
	@Autowired
	private CalculoImpostosDomain	calculoImpostosDomain;
	
	@Autowired
	private UsuarioDomain	usuarioDomain;
	
	@Autowired
	private ConstanteDomain constanteDomain;
	
    private Log log = LogFactory.getLog(CalculoImpostosController.class);

	@RequestMapping(value = "/calculo/{id}", method = RequestMethod.GET)
	public Usuario getUsuario(@PathVariable("id") long id) {
		return usuarioDomain.findById(id);
	}
	
	@RequestMapping(value = "/impostos", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Usuario> calcular(@RequestBody ParametrosCalculoImpostoIndividual parametros, UriComponentsBuilder ucBuilder) {
		
		TabelaImpostos tabelaImpostos = new TabelaImpostos();
		
		ContratoTrabalho contrato = null;
        try {
	        contrato = TipoRenda.getTipoRendaByCodigo(parametros.getIndTipoRenda()).getContratoTrabalho().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        	log.error(e);
            return new ResponseEntity<Usuario>(HttpStatus.CONFLICT);
        }
		
		Renda renda = new Renda();
		renda.setDependentes(parametros.getNumDependentes());
		renda.setRenda(parametros.getVlrRendaMensal());
		contrato.setRenda(renda);
		tabelaImpostos.addContratoTrabalho(contrato);

		tabelaImpostos.setValorTotalImoveis(parametros.getVlrTotalImoveis());
		tabelaImpostos.setValorTotalVeiculos(parametros.getVlrTotalVeiculos());
		
		tabelaImpostos.setFinanciamentoImovel(parametros.getVlrMensalFinanciamentoImoveis());
		tabelaImpostos.setFinanciamentoVeiculo(parametros.getVlrMensalFinanciamentoVeiculos());
		tabelaImpostos.setAluguel(parametros.getVlrMensalAluguel());
		tabelaImpostos.setSupermercado(parametros.getVlrMensalSupermercado());
		tabelaImpostos.setSaude(parametros.getVlrMensalSaude());
		tabelaImpostos.setConcessionarias(parametros.getVlrMensalConcessionarias());
		tabelaImpostos.setEducacao(parametros.getVlrMensalEducacao());
		tabelaImpostos.setTransporte(parametros.getVlrMensalTransporte());
		tabelaImpostos.setVestuario(parametros.getVlrMensalVestuario());
		tabelaImpostos.setOutros(parametros.getVlrMensalOutros());

		tabelaImpostos.setPercentualImpostosParaGovernoFederal(NumberUtils.toFloat(constanteDomain.getConstante(ConstanteDomain.IMPOSTOS_FEDERAIS).getValor()));
		tabelaImpostos.setPercentualImpostosParaGovernoEstadual(NumberUtils.toFloat(constanteDomain.getConstante(ConstanteDomain.IMPOSTOS_ESTADUAIS).getValor()));
		tabelaImpostos.setPercentualImpostosParaGovernoMunicipal(NumberUtils.toFloat(constanteDomain.getConstante(ConstanteDomain.IMPOSTOS_MUNICIPAIS).getValor()));
		
		Usuario usuario = new Usuario();
		usuario.setComentario(parametros.getComentario());
		usuario.setNome(parametros.getNome());
		usuario.setPostar(parametros.isPostar());

		try {
			usuario = calculoImpostosDomain.executaCalculosParaUsuario(tabelaImpostos);
	        usuario = usuarioDomain.save(usuario);
        } catch (Exception e) {
        	e.printStackTrace();;
        	log.error(e);
        }
		
	    //HttpHeaders headers = new HttpHeaders();
	    //headers.setLocation(ucBuilder.path("/calculo/{id}").buildAndExpand(usuario.getId()).toUri());
	    //headers.setLocation(ucBuilder.path("/api/calculo/{id}").buildAndExpand(usuario.getId()).toUri());
	    return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);		
	}
	
	public void deleteUsuario(@PathParam("id") Long id) {
	}
	
}
