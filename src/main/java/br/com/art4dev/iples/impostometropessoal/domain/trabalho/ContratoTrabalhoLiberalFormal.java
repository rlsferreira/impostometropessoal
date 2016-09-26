package br.com.art4dev.iples.impostometropessoal.domain.trabalho;

import br.com.art4dev.iples.impostometropessoal.model.Range;
import br.com.art4dev.iples.impostometropessoal.model.Renda;

public class ContratoTrabalhoLiberalFormal implements ContratoTrabalho {


	private Renda renda = new Renda();
	
	private Range rangeIR = new Range(0.0953f);
	
	private boolean isCalculoEfetuado = false;
	
	public ContratoTrabalhoLiberalFormal() {
		setUp();
	}
	
	@Override
	public void setUp() {

		rangeIR.add(1637.11f, 0.0953f);
		rangeIR.add(2453.50f, 0.0953f);
		rangeIR.add(3271.38f, 0.0953f);
		rangeIR.add(4087.65f, 0.0953f);

	
	}

	@Override
	public void realizaCalculos() {

		this.renda.setValorIR(this.renda.getRenda() * rangeIR.getFator(this.renda.getRenda()));

		if(this.renda.getValorIR() < 0) {
			this.renda.setValorIR(0);
		}
		
		this.renda.setValorTributosEmpresa(this.renda.getRenda() * FATOR_TRIBUTOS_PROFISSIONAL_LIBERAL);
		this.renda.setValorBurocraciaEmpresa(this.renda.getRenda() * FATOR_BUROCRACIA_PROFISSIONAL_LIBERAL);
		
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
