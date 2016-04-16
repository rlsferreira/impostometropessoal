package br.com.art4dev.iples.impostometropessoal.model;

import java.io.Serializable;

public class Renda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7074564984519433479L;
	
	private int dependentes;
	private float valorINSS;
	private float valorIR;
	private float pensaoAlimenticia;
	private float renda;
	private float valorTributosEmpresa;
	private float valorBurocraciaEmpresa;
	
	public int getDependentes() {
		return dependentes;
	}
	public void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}
	public float getValorINSS() {
		return valorINSS;
	}
	public void setValorINSS(float valorINSS) {
		this.valorINSS = valorINSS;
	}
	public float getValorIR() {
		return valorIR;
	}
	public void setValorIR(float valorIR) {
		this.valorIR = valorIR;
	}
	public float getPensaoAlimenticia() {
		return pensaoAlimenticia;
	}
	public void setPensaoAlimenticia(float pensaoAlimenticia) {
		this.pensaoAlimenticia = pensaoAlimenticia;
	}
	public float getRenda() {
		return renda;
	}
	public void setRenda(float renda) {
		this.renda = renda;
	}
	public float getValorTributosEmpresa() {
		return valorTributosEmpresa;
	}
	public void setValorTributosEmpresa(float valorTributosEmpresa) {
		this.valorTributosEmpresa = valorTributosEmpresa;
	}
	public float getValorBurocraciaEmpresa() {
		return valorBurocraciaEmpresa;
	}
	public void setValorBurocraciaEmpresa(float valorBurocraciaEmpresa) {
		this.valorBurocraciaEmpresa = valorBurocraciaEmpresa;
	}	
	
	
	
	
}
