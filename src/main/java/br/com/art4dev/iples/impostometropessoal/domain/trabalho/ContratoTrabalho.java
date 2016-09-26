package br.com.art4dev.iples.impostometropessoal.domain.trabalho;

import br.com.art4dev.iples.impostometropessoal.model.Renda;

public interface ContratoTrabalho {

	public float TETO_INSS_INICIATIVA_PRIVADA = 430.78f;
	public float DESCONTO_IR_POR_DEPENDENTE = 164.56f;
	public float FATOR_TRIBUTOS_EMPRESA_INICIATIVA_PRIVADA = 0.298f; // SAT+SALARIO_EDUCACAO+INSS+INCRA+SENAI+SESI+SEBRAE
	public float FATOR_TRIBUTOS_PROFISSIONAL_LIBERAL = 0.2f; // INSS
	public float FATOR_BUROCRACIA_EMPRESA_INICIATIVA_PRIVADA = 0.08f; // SAT+SALARIO_EDUCACAO+INSS+INCRA+SENAI+SESI+SEBRAE
	public float FATOR_BUROCRACIA_PROFISSIONAL_LIBERAL = 0.05f; // INSS
	public float FATOR_BUROCRACIA_PROFISSIONAL_LIBERAL_INFORMAL = 0.01f; // TODOS
																			// NOS
																			// TEMOS
																			// ALGUMA

	public void setUp();

	public void realizaCalculos();

	public void setRenda(Renda renda);

	public Renda getRenda();

}
