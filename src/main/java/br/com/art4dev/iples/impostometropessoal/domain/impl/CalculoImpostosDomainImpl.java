package br.com.art4dev.iples.impostometropessoal.domain.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.art4dev.iples.impostometropessoal.domain.CalculoImpostosDomain;
import br.com.art4dev.iples.impostometropessoal.domain.tabela.TabelaImpostos;
import br.com.art4dev.iples.impostometropessoal.model.Usuario;

@Service
public class CalculoImpostosDomainImpl implements CalculoImpostosDomain {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.art4dev.iples.impostometropessoal.domain.CalculoImpostosDomain
	 * #executaCalculosParaUsuario(java.lang.String, java.lang.String,
	 * java.lang.String, boolean,
	 * br.com.art4dev.iples.impostometropessoal.model.TabelaImpostos)
	 */
	@Override
	public Usuario executaCalculosParaUsuario(TabelaImpostos tabelaImpostos) throws Exception {
		
		tabelaImpostos.calcula();
		
		Usuario usuario = new Usuario();
		
		usuario.setTotalRendaTrabalho(new BigDecimal(tabelaImpostos.getTotalRendaTrabalho()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setTotalInssTrabalho(new BigDecimal(tabelaImpostos.getTotalInssTrabalho()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setTotalIRTrabalho(new BigDecimal(tabelaImpostos.getTotalIRTrabalho()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setTotalBurocraciaTrabalho(new BigDecimal(tabelaImpostos.getTotalBurocraciaTrabalho()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setTotalTributosEmpresaTrabalho(new BigDecimal(tabelaImpostos.getTotalTributosEmpresaTrabalho()).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		usuario.setImpostosValorTotalImoveis(new BigDecimal(tabelaImpostos.getImpostosValorTotalImoveis()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosValorTotalVeiculos(new BigDecimal(tabelaImpostos.getImpostosValorTotalVeiculos()).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		usuario.setImpostosAluguel(new BigDecimal(tabelaImpostos.getImpostosAluguel()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosFinanciamentoImovel(new BigDecimal(tabelaImpostos.getImpostosFinanciamentoImovel()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosFinanciamentoVeiculo(new BigDecimal(tabelaImpostos.getImpostosFinanciamentoVeiculo()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosSupermercado(new BigDecimal(tabelaImpostos.getImpostosSupermercado()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosConcessionarias(new BigDecimal(tabelaImpostos.getImpostosConcessionarias()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosSaude(new BigDecimal(tabelaImpostos.getImpostosSaude()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosTransporte(new BigDecimal(tabelaImpostos.getImpostosTransporte()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosVestuario(new BigDecimal(tabelaImpostos.getImpostosVestuario()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosEducacao(new BigDecimal(tabelaImpostos.getImpostosEducacao()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setImpostosOutros(new BigDecimal(tabelaImpostos.getImpostosOutros()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setTotalPerdaInflacaoPorAno(new BigDecimal(tabelaImpostos.getTotalInflacao()).setScale(2, BigDecimal.ROUND_HALF_UP));
		

		usuario.setValorTotalImpostosTrabalho(new BigDecimal(tabelaImpostos.getValorTotalImpostosTrabalho()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setPorcentagemImpostosTrabalho(new BigDecimal(tabelaImpostos.getPorcentagemImpostosTrabalho()).setScale(5, BigDecimal.ROUND_HALF_UP));
		usuario.setValorTotalGastosMensais(new BigDecimal(tabelaImpostos.getValorTotalGastosMensais()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setValorTotalImpostosSobreGastosMensais(new BigDecimal(tabelaImpostos.getValorTotalImpostosSobreGastosMensais()).setScale(2, BigDecimal.ROUND_HALF_UP));
		usuario.setPorcentagemImpostosTotalSobreRenda(new BigDecimal(tabelaImpostos.getPorcentagemImpostosTotalSobreRenda()).setScale(5, BigDecimal.ROUND_HALF_UP));

		usuario.setValorTotalImpostosPagos(new BigDecimal(tabelaImpostos.getValorTotalImpostosPagos()).setScale(5, BigDecimal.ROUND_HALF_UP));
		usuario.setValorImpostosParaGovernoEstadual(new BigDecimal(tabelaImpostos.getValorImpostosParaGovernoEstadual()).setScale(5, BigDecimal.ROUND_HALF_UP));
		usuario.setValorImpostosParaGovernoFederal(new BigDecimal(tabelaImpostos.getValorImpostosParaGovernoFederal()).setScale(5, BigDecimal.ROUND_HALF_UP));
		usuario.setValorImpostosParaGovernoMunicipal(new BigDecimal(tabelaImpostos.getValorImpostosParaGovernoMunicipal()).setScale(5, BigDecimal.ROUND_HALF_UP));

		
		usuario.setDataEntrada(new Date());
		
		return usuario;
	}
	
	
}
