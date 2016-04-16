package br.com.art4dev.iples.impostometropessoal.model;

public enum TipoRenda {

	
	FUNCIONARIO_INICIATIVA_PRIVADA(1),
	FUNCIONARIO_PUBLICO(2),
	PROFISSIONAL_LIBERAL(3),
	PROFISSIONAL_INFORMAL(4),
	APOSENTADO(5);
	
	private int codigo;
	
	TipoRenda(int codigo) {
		 this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }	
	
	
	
	
}
