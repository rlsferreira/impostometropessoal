package br.com.art4dev.iples.impostometropessoal.domain;

import br.com.art4dev.iples.impostometropessoal.model.Range;
import br.com.art4dev.iples.impostometropessoal.model.Renda;

public class ContratoTrabalhoCLT implements ContratoTrabalho {


	private Renda renda = new Renda();
	
	private Range rangeInss = new Range(TETO_INSS_INICIATIVA_PRIVADA);
	private Range rangeIR = new Range(0.275f);
	private Range rangeDeducoesIR = new Range(756.53f);
	
	private boolean isCalculoEfetuado = false;
	
	public ContratoTrabalhoCLT() {
		setUp();
	}
	
	@Override
	public void setUp() {
		rangeInss.add(1174.86f, 0.08f);
		rangeInss.add(1958.10f, 0.09f);
		rangeInss.add(3916.20f, 0.11f);

		rangeIR.add(1637.11f, 0);
		rangeIR.add(2453.50f, 0.075f);
		rangeIR.add(3271.38f, 0.225f);
		rangeIR.add(4087.65f, 0.275f);

		rangeDeducoesIR.add(1637.11f, 0);
		rangeDeducoesIR.add(2453.50f, 122.78f);
		rangeDeducoesIR.add(3271.38f, 306.80f);
		rangeDeducoesIR.add(4087.65f, 552.15f);
	
	}

	@Override
	public void realizaCalculos() {

		this.renda.setValorINSS(this.renda.getRenda() * rangeInss.getFator(this.renda.getRenda()));
		if(this.renda.getValorINSS() > TETO_INSS_INICIATIVA_PRIVADA) {
			this.renda.setValorINSS(TETO_INSS_INICIATIVA_PRIVADA);
		}

		float valorBaseCalculoIR = (this.renda.getRenda() - this.renda.getValorINSS() - (DESCONTO_IR_POR_DEPENDENTE * this.renda.getDependentes()) - this.renda.getPensaoAlimenticia()) * rangeIR.getFator(this.renda.getRenda());
		this.renda.setValorIR(valorBaseCalculoIR - rangeDeducoesIR.getFator(renda.getRenda()));

		if(this.renda.getValorIR() < 0) {
			this.renda.setValorIR(0);
		}
		
		this.renda.setValorTributosEmpresa(this.renda.getRenda() * FATOR_TRIBUTOS_EMPRESA_INICIATIVA_PRIVADA);
		this.renda.setValorBurocraciaEmpresa(this.renda.getRenda() * FATOR_BUROCRACIA_EMPRESA_INICIATIVA_PRIVADA);
		
		isCalculoEfetuado = true;
		
	}

	@Override
	public void setRenda(Renda renda) {
		this.renda = renda;
	}

	@Override
	public Renda getRenda() {
		return this.renda;
	}


}
