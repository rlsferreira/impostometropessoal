package br.com.art4dev.iples.impostometropessoal.to;

public class ParametrosCalculoImpostoIndividual {
	
	private int   indTipoRenda;
	private float vlrRendaMensal;
	private float vlrDesembolsoPensaoAlimenticia;
	private int   numDependentes;
	
	private float vlrTotalImoveis;
	private float vlrTotalVeiculos;
	private float vlrMensalFinanciamentoImoveis;
	private float vlrMensalFinanciamentoVeiculos;
	private float vlrMensalAluguel;
	private float vlrMensalSupermercado;
	private float vlrMensalSaude;
	private float vlrMensalConcessionarias;
	private float vlrMensalEducacao;
	private float vlrMensalTransporte;
	private float vlrMensalVestuario;
	private float vlrMensalOutros;

	private String nome;
	private String comentario;
	private boolean postar;
	
	public int getIndTipoRenda() {
		return indTipoRenda;
	}
	public void setIndTipoRenda(int indTipoRenda) {
		this.indTipoRenda = indTipoRenda;
	}
	public float getVlrRendaMensal() {
		return vlrRendaMensal;
	}
	public void setVlrRendaMensal(float vlrRendaMensal) {
		this.vlrRendaMensal = vlrRendaMensal;
	}
	public float getVlrDesembolsoPensaoAlimenticia() {
		return vlrDesembolsoPensaoAlimenticia;
	}
	public void setVlrDesembolsoPensaoAlimenticia(float vlrDesembolsoPensaoAlimenticia) {
		this.vlrDesembolsoPensaoAlimenticia = vlrDesembolsoPensaoAlimenticia;
	}
	public int getNumDependentes() {
		return numDependentes;
	}
	public void setNumDependentes(int numDependentes) {
		this.numDependentes = numDependentes;
	}
	public float getVlrTotalImoveis() {
		return vlrTotalImoveis;
	}
	public void setVlrTotalImoveis(float vlrTotalImoveis) {
		this.vlrTotalImoveis = vlrTotalImoveis;
	}
	public float getVlrTotalVeiculos() {
		return vlrTotalVeiculos;
	}
	public void setVlrTotalVeiculos(float vlrTotalVeiculos) {
		this.vlrTotalVeiculos = vlrTotalVeiculos;
	}
	public float getVlrMensalFinanciamentoImoveis() {
		return vlrMensalFinanciamentoImoveis;
	}
	public void setVlrMensalFinanciamentoImoveis(float vlrMensalFinanciamentoImoveis) {
		this.vlrMensalFinanciamentoImoveis = vlrMensalFinanciamentoImoveis;
	}
	public float getVlrMensalFinanciamentoVeiculos() {
		return vlrMensalFinanciamentoVeiculos;
	}
	public void setVlrMensalFinanciamentoVeiculos(float vlrMensalFinanciamentoVeiculos) {
		this.vlrMensalFinanciamentoVeiculos = vlrMensalFinanciamentoVeiculos;
	}
	public float getVlrMensalAluguel() {
		return vlrMensalAluguel;
	}
	public void setVlrMensalAluguel(float vlrMensalAluguel) {
		this.vlrMensalAluguel = vlrMensalAluguel;
	}
	public float getVlrMensalSupermercado() {
		return vlrMensalSupermercado;
	}
	public void setVlrMensalSupermercado(float vlrMensalSupermercado) {
		this.vlrMensalSupermercado = vlrMensalSupermercado;
	}
	public float getVlrMensalSaude() {
		return vlrMensalSaude;
	}
	public void setVlrMensalSaude(float vlrMensalSaude) {
		this.vlrMensalSaude = vlrMensalSaude;
	}
	public float getVlrMensalConcessionarias() {
		return vlrMensalConcessionarias;
	}
	public void setVlrMensalConcessionarias(float vlrMensalConcessionarias) {
		this.vlrMensalConcessionarias = vlrMensalConcessionarias;
	}
	public float getVlrMensalEducacao() {
		return vlrMensalEducacao;
	}
	public void setVlrMensalEducacao(float vlrMensalEducacao) {
		this.vlrMensalEducacao = vlrMensalEducacao;
	}
	public float getVlrMensalTransporte() {
		return vlrMensalTransporte;
	}
	public void setVlrMensalTransporte(float vlrMensalTransporte) {
		this.vlrMensalTransporte = vlrMensalTransporte;
	}
	public float getVlrMensalVestuario() {
		return vlrMensalVestuario;
	}
	public void setVlrMensalVestuario(float vlrMensalVestuario) {
		this.vlrMensalVestuario = vlrMensalVestuario;
	}
	public float getVlrMensalOutros() {
		return vlrMensalOutros;
	}
	public void setVlrMensalOutros(float vlrMensalOutros) {
		this.vlrMensalOutros = vlrMensalOutros;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public boolean isPostar() {
		return postar;
	}
	public void setPostar(boolean postar) {
		this.postar = postar;
	}

	@Override
    public String toString() {
	    return String
	            .format("ParametrosCalculoImpostoIndividual [indTipoRenda=%s, vlrRendaMensal=%s, vlrDesembolsoPensaoAlimenticia=%s, numDependentes=%s, vlrTotalImoveis=%s, vlrTotalVeiculos=%s, vlrMensalFinanciamentoImoveis=%s, vlrMensalFinanciamentoVeiculos=%s, vlrMensalAluguel=%s, vlrMensalSupermercado=%s, vlrMensalSaude=%s, vlrMensalConcessionarias=%s, vlrMensalEducacao=%s, vlrMensalTransporte=%s, vlrMensalVestuario=%s, vlrMensalOutros=%s, nome=%s, comentario=%s, postar=%s]",
	                    indTipoRenda, vlrRendaMensal, vlrDesembolsoPensaoAlimenticia, numDependentes, vlrTotalImoveis,
	                    vlrTotalVeiculos, vlrMensalFinanciamentoImoveis, vlrMensalFinanciamentoVeiculos, vlrMensalAluguel,
	                    vlrMensalSupermercado, vlrMensalSaude, vlrMensalConcessionarias, vlrMensalEducacao, vlrMensalTransporte,
	                    vlrMensalVestuario, vlrMensalOutros, nome, comentario, postar);
    }

}
