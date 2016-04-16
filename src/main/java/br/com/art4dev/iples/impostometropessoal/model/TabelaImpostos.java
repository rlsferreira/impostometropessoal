package br.com.art4dev.iples.impostometropessoal.model;

import br.com.art4dev.iples.impostometropessoal.domain.ContratoTrabalho;

public class TabelaImpostos implements java.io.Serializable {
	
	private ContratoTrabalho[]	contratoTrabalho;
	private float	           totalRendaTrabalho;
	private float	           totalInssTrabalho;
	private float	           totalIRTrabalho;
	private float	           totalBurocraciaTrabalho;
	private float	           totalTributosEmpresaTrabalho;
	
	private float	           valorTotalImoveis;
	private float	           valorTotalVeiculos;
	
	private float	           aluguel;
	private float	           financiamentoImovel;
	private float	           financiamentoVeiculo;
	private float	           supermercado;
	private float	           concessionarias;
	private float	           saude;
	private float	           transporte;
	private float	           vestuario;
	private float	           educacao;
	private float	           outros;
	
	private float	           impostosValorTotalImoveis;
	private float	           impostosValorTotalVeiculos;
	
	private float	           impostosAluguel;
	private float	           impostosFinanciamentoImovel;
	private float	           impostosFinanciamentoVeiculo;
	private float	           impostosSupermercado;
	private float	           impostosConcessionarias;
	private float	           impostosSaude;
	private float	           impostosTransporte;
	private float	           impostosVestuario;
	private float	           impostosEducacao;
	private float	           impostosOutros;
	private float	           totalInflacao;
	
	private float	           valorTotalImpostosTrabalho;
	private float	           porcentagemImpostosTrabalho;
	private float	           valorTotalGastosMensais;
	private float	           valorTotalImpostosSobreGastosMensais;
	private float	           porcentagemImpostosTotalSobreRenda;
	
	private Range	           rangeFatorCompensacao	= new Range(100);
	
	public TabelaImpostos() {
		
		rangeFatorCompensacao.add(500f, 0.30f);
		rangeFatorCompensacao.add(1500f, 0.45f);
		rangeFatorCompensacao.add(2500f, 0.50f);
		rangeFatorCompensacao.add(4000f, 0.53f);
		rangeFatorCompensacao.add(6000f, 0.60f);
		rangeFatorCompensacao.add(8000f, 0.70f);
		rangeFatorCompensacao.add(12000f, 0.80f);
		rangeFatorCompensacao.add(1700f, 0.88f);
		rangeFatorCompensacao.add(25000f, 0.92f);
		rangeFatorCompensacao.add(50000f, 0.95f);
		
	}
	
	private void processaContratosTrabalho() {
		
		this.totalRendaTrabalho = 0;
		this.totalInssTrabalho = 0;
		this.totalIRTrabalho = 0;
		this.totalBurocraciaTrabalho = 0;
		this.totalTributosEmpresaTrabalho = 0;
		
		for (ContratoTrabalho contrato : contratoTrabalho) {
			contrato.realizaCalculos();
			this.totalRendaTrabalho += contrato.getRenda().getRenda();
			this.totalInssTrabalho += contrato.getRenda().getValorINSS();
			this.totalIRTrabalho += contrato.getRenda().getValorIR();
			this.totalBurocraciaTrabalho += contrato.getRenda().getValorBurocraciaEmpresa();
			this.totalTributosEmpresaTrabalho += contrato.getRenda().getValorTributosEmpresa();
		}
		
	}
	
	private void processaInflacao() {
		
		float totalInflacao = 0;
		for (int i = 0; i < Inflacao.MESES; i++) {
			totalInflacao += this.totalRendaTrabalho * Inflacao.TAXA_INFLACAO_ULTIMOS_12_MESES[i];
		}
		
		this.totalInflacao = totalInflacao;
		
	}
	
	public void calcula() {
		
		processaContratosTrabalho();
		processaInflacao();
		
		impostosAluguel = aluguel
		        * (ImpostosFixos.SOBRE_ALUGUEL.getValorPercentualMin() + (ImpostosFixos.SOBRE_ALUGUEL.getValorPercentualMax() - ImpostosFixos.SOBRE_ALUGUEL
		                .getValorPercentualMin()) * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosFinanciamentoImovel = financiamentoImovel
		        * (ImpostosFixos.SOBRE_FINANCIAMENTO_IMOVEIS.getValorPercentualMin() + (ImpostosFixos.SOBRE_FINANCIAMENTO_IMOVEIS
		                .getValorPercentualMax() - ImpostosFixos.SOBRE_FINANCIAMENTO_IMOVEIS.getValorPercentualMin())
		                * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosFinanciamentoVeiculo = financiamentoVeiculo
		        * (ImpostosFixos.SOBRE_FINANCIAMENTO_VEICULOS.getValorPercentualMin() + (ImpostosFixos.SOBRE_FINANCIAMENTO_VEICULOS
		                .getValorPercentualMax() - ImpostosFixos.SOBRE_FINANCIAMENTO_VEICULOS.getValorPercentualMin())
		                * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosSupermercado = supermercado
		        * (ImpostosFixos.SOBRE_SUPERMERCADO.getValorPercentualMin() + (ImpostosFixos.SOBRE_SUPERMERCADO
		                .getValorPercentualMax() - ImpostosFixos.SOBRE_SUPERMERCADO.getValorPercentualMin())
		                * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosConcessionarias = concessionarias
		        * (ImpostosFixos.SOBRE_CONCESSIONARIAS.getValorPercentualMin() + (ImpostosFixos.SOBRE_CONCESSIONARIAS
		                .getValorPercentualMax() - ImpostosFixos.SOBRE_CONCESSIONARIAS.getValorPercentualMin())
		                * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosSaude = saude
		        * (ImpostosFixos.SOBRE_SAUDE.getValorPercentualMin() + (ImpostosFixos.SOBRE_SAUDE.getValorPercentualMax() - ImpostosFixos.SOBRE_SAUDE
		                .getValorPercentualMin()) * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosTransporte = transporte
		        * (ImpostosFixos.SOBRE_TRANSPORTES.getValorPercentualMin() + (ImpostosFixos.SOBRE_TRANSPORTES
		                .getValorPercentualMax() - ImpostosFixos.SOBRE_TRANSPORTES.getValorPercentualMin())
		                * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosVestuario = vestuario
		        * (ImpostosFixos.SOBRE_VESTUARIO.getValorPercentualMin() + (ImpostosFixos.SOBRE_VESTUARIO.getValorPercentualMax() - ImpostosFixos.SOBRE_VESTUARIO
		                .getValorPercentualMin()) * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosEducacao = educacao
		        * (ImpostosFixos.SOBRE_EDUCACAO.getValorPercentualMin() + (ImpostosFixos.SOBRE_EDUCACAO.getValorPercentualMax() - ImpostosFixos.SOBRE_EDUCACAO
		                .getValorPercentualMin()) * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosOutros = outros
		        * (ImpostosFixos.SOBRE_OUTROS.getValorPercentualMin() + (ImpostosFixos.SOBRE_OUTROS.getValorPercentualMax() - ImpostosFixos.SOBRE_OUTROS
		                .getValorPercentualMin()) * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosValorTotalImoveis = valorTotalImoveis
		        * (ImpostosFixos.SOBRE_IMOVEIS.getValorPercentualMin() + (ImpostosFixos.SOBRE_IMOVEIS.getValorPercentualMax() - ImpostosFixos.SOBRE_IMOVEIS
		                .getValorPercentualMin()) * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		impostosValorTotalVeiculos = valorTotalVeiculos
		        * (ImpostosFixos.SOBRE_VEICULOS.getValorPercentualMin() + (ImpostosFixos.SOBRE_VEICULOS.getValorPercentualMax() - ImpostosFixos.SOBRE_VEICULOS
		                .getValorPercentualMin()) * rangeFatorCompensacao.getFator(totalRendaTrabalho));
		
		processaResumo();
		
	}
	
	private void processaResumo() {
		
		valorTotalImpostosTrabalho = totalInssTrabalho + totalIRTrabalho;
		
		porcentagemImpostosTrabalho = (totalInssTrabalho + totalIRTrabalho) / totalRendaTrabalho * 100;
		
		valorTotalGastosMensais = aluguel + concessionarias + educacao + financiamentoImovel + financiamentoVeiculo + outros
		        + saude + supermercado + transporte + vestuario;
		
		valorTotalImpostosSobreGastosMensais = impostosAluguel + impostosConcessionarias + impostosEducacao
		        + impostosFinanciamentoImovel + impostosFinanciamentoVeiculo + impostosOutros + impostosSaude
		        + impostosSupermercado + impostosTransporte + impostosVestuario;
		
		porcentagemImpostosTotalSobreRenda = (impostosAluguel + impostosConcessionarias + impostosEducacao
		        + impostosFinanciamentoImovel + impostosFinanciamentoVeiculo + impostosOutros + impostosSaude
		        + impostosSupermercado + impostosTransporte + impostosVestuario)
		        / totalRendaTrabalho;
		
	}
	
	public float getImpostosValorTotalImoveis() {
		return impostosValorTotalImoveis;
	}
	
	public float getImpostosValorTotalVeiculos() {
		return impostosValorTotalVeiculos;
	}
	
	public void setAluguel(float aluguel) {
		this.aluguel = aluguel;
	}
	
	public void setFinanciamentoImovel(float financiamentoImovel) {
		this.financiamentoImovel = financiamentoImovel;
	}
	
	public void setFinanciamentoVeiculo(float financiamentoVeiculo) {
		this.financiamentoVeiculo = financiamentoVeiculo;
	}
	
	public void setSupermercado(float supermercado) {
		this.supermercado = supermercado;
	}
	
	public void setConcessionarias(float concessionarias) {
		this.concessionarias = concessionarias;
	}
	
	public void setSaude(float saude) {
		this.saude = saude;
	}
	
	public void setTransporte(float transporte) {
		this.transporte = transporte;
	}
	
	public void setVestuario(float vestuario) {
		this.vestuario = vestuario;
	}
	
	public void setEducacao(float educacao) {
		this.educacao = educacao;
	}
	
	public void setOutros(float outros) {
		this.outros = outros;
	}
	
	public void setValorTotalImoveis(float valorTotalImoveis) {
		this.valorTotalImoveis = valorTotalImoveis;
	}
	
	public float getValorTotalImoveis() {
		return this.valorTotalImoveis;
	}
	
	public void setValorTotalVeiculos(float valorTotalVeiculos) {
		this.valorTotalVeiculos = valorTotalVeiculos;
	}
	
	public float getValorTotalVeiculos() {
		return this.valorTotalVeiculos;
	}
	
	public float getImpostosAluguel() {
		return impostosAluguel;
	}
	
	public float getImpostosFinanciamentoImovel() {
		return impostosFinanciamentoImovel;
	}
	
	public float getImpostosFinanciamentoVeiculo() {
		return impostosFinanciamentoVeiculo;
	}
	
	public float getImpostosSupermercado() {
		return impostosSupermercado;
	}
	
	public float getImpostosConcessionarias() {
		return impostosConcessionarias;
	}
	
	public float getImpostosSaude() {
		return impostosSaude;
	}
	
	public float getImpostosTransporte() {
		return impostosTransporte;
	}
	
	public float getImpostosVestuario() {
		return impostosVestuario;
	}
	
	public float getImpostosEducacao() {
		return impostosEducacao;
	}
	
	public float getImpostosOutros() {
		return impostosOutros;
	}
	
	public float getTotalRendaTrabalho() {
		return totalRendaTrabalho;
	}
	
	public float getTotalInssTrabalho() {
		return totalInssTrabalho;
	}
	
	public float getTotalIRTrabalho() {
		return totalIRTrabalho;
	}
	
	public float getTotalBurocraciaTrabalho() {
		return totalBurocraciaTrabalho;
	}
	
	public float getTotalTributosEmpresaTrabalho() {
		return totalTributosEmpresaTrabalho;
	}
	
	public float getTotalInflacao() {
		return totalInflacao;
	}
	
	public float getValorTotalImpostosTrabalho() {
		return valorTotalImpostosTrabalho;
	}
	
	public float getPorcentagemImpostosTrabalho() {
		return porcentagemImpostosTrabalho;
	}
	
	public float getValorTotalGastosMensais() {
		return valorTotalGastosMensais;
	}
	
	public float getValorTotalImpostosSobreGastosMensais() {
		return valorTotalImpostosSobreGastosMensais;
	}
	
	public float getPorcentagemImpostosTotalSobreRenda() {
		return porcentagemImpostosTotalSobreRenda;
	}
	
	public void addContratoTrabalho(ContratoTrabalho contrato) {
		
		if (this.contratoTrabalho == null) {
			this.contratoTrabalho = new ContratoTrabalho[1];
			this.contratoTrabalho[0] = contrato;
		} else {
			ContratoTrabalho[] novo = new ContratoTrabalho[this.contratoTrabalho.length + 1];
			System.arraycopy(this.contratoTrabalho, 0, novo, 0, this.contratoTrabalho.length);
			novo[novo.length - 1] = contrato;
			this.contratoTrabalho = novo;
		}
		
	}
	
	public ContratoTrabalho[] getContratosTrabalho() {
		return this.contratoTrabalho;
	}
	
}
