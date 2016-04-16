package br.com.art4dev.iples.impostometropessoal.model;

import java.util.TreeMap;

public class Range  implements java.io.Serializable {

	private TreeMap<Float, Float> rangeList;
	private float fatorMaximo = 0;

	public Range(float fatorMaximo) {
		rangeList = new TreeMap<Float, Float>(
				
		);
		this.fatorMaximo = fatorMaximo;
	}

	public void add(float valorAte, float fator) {
		rangeList.put(valorAte, fator);
	}

	public float getFator(float valor) {

		float valorAteProcurado = 0;
		for (Float valorRange : rangeList.descendingKeySet()) {
			if(valor <= valorRange) {
				valorAteProcurado = valorRange;
			} else {
				break;
			}
		}
		
		if(valor <= valorAteProcurado)
			return rangeList.get(valorAteProcurado); 
		else
			return fatorMaximo;
			

	}

}