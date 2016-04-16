package br.com.art4dev.iples.impostometropessoal.model;

public enum ImpostosFixos {

	
	SOBRE_IMOVEIS(0.01f, 0.015f),
	SOBRE_VEICULOS(0.025f, 0.035f),
	
	SOBRE_ALUGUEL(0.10f, 0.15f),
	SOBRE_FINANCIAMENTO_IMOVEIS(0.20f, 0.30f),
	SOBRE_FINANCIAMENTO_VEICULOS(0.20f, 0.40f),
	SOBRE_SUPERMERCADO(0.20f, 0.30f),
	SOBRE_CONCESSIONARIAS(0.30f, 0.50f),
	SOBRE_SAUDE(0.20f, 0.30f),
	SOBRE_TRANSPORTES(0.20f, 0.40f),
	SOBRE_VESTUARIO(0.20f, 0.40f),
	SOBRE_EDUCACAO(0.10f, 0.30f),
	SOBRE_OUTROS(0.20f, 0.30f);
	
	
	private float valorPercentualMin;
	private float valorPercentualMax;
	
	ImpostosFixos(float valorPercentualMin, float valorPercentualMax) {
		 this.valorPercentualMin = valorPercentualMin;
		 this.valorPercentualMax = valorPercentualMax;
    }

    public float getValorPercentualMin() {
        return valorPercentualMin;
    }	
	
    public float getValorPercentualMax() {
        return valorPercentualMax;
    }	
	
	
	
	
}
