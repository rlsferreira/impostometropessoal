package br.com.art4dev.iples.impostometropessoal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1678927219803427533L;
	
	@Id
	private Long	          id;
	
	private String	          fbId;
	private String	          nome;
	private boolean	          postar;
	private String	          comentario;
	
	private int	              nextDay;
	private int	              nextHour;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosValorTotalImoveis;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosValorTotalVeiculos;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosAluguel;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosFinanciamentoImovel;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosFinanciamentoVeiculo;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosSupermercado;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosConcessionarias;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosSaude;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosTransporte;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosVestuario;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosEducacao;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      impostosOutros;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      totalRendaTrabalho;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      totalInssTrabalho;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      totalIRTrabalho;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      totalBurocraciaTrabalho;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
	private BigDecimal	      totalTributosEmpresaTrabalho;
	
	@JsonFormat(shape = JsonFormat.Shape.SCALAR)
	private BigDecimal	      totalPerdaInflacaoPorAno;
	
	@JsonFormat(shape = JsonFormat.Shape.SCALAR)
	private BigDecimal	      valorTotalImpostosTrabalho;

	@JsonFormat(shape = JsonFormat.Shape.SCALAR)
	private BigDecimal	      porcentagemImpostosTrabalho;

	@JsonFormat(shape = JsonFormat.Shape.SCALAR)
	private BigDecimal	      valorTotalGastosMensais;

	@JsonFormat(shape = JsonFormat.Shape.SCALAR)
	private BigDecimal	      valorTotalImpostosSobreGastosMensais;

	@JsonFormat(shape = JsonFormat.Shape.SCALAR)
	private BigDecimal	      porcentagemImpostosTotalSobreRenda;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date	          dataEntrada;
	
	
	
	public String getFbId() {
		return fbId;
	}
	
	public void setFbId(String fbid) {
		this.fbId = fbid;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isPostar() {
		return postar;
	}
	
	public void setPostar(boolean postar) {
		this.postar = postar;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public int getNextDay() {
		return nextDay;
	}
	
	public void setNextDay(int nextDay) {
		this.nextDay = nextDay;
	}
	
	public int getNextHour() {
		return nextHour;
	}
	
	public void setNextHour(int nextHour) {
		this.nextHour = nextHour;
	}
	
	public BigDecimal getImpostosValorTotalImoveis() {
		return impostosValorTotalImoveis;
	}
	
	public void setImpostosValorTotalImoveis(BigDecimal impostosValorTotalImoveis) {
		this.impostosValorTotalImoveis = impostosValorTotalImoveis;
	}
	
	public BigDecimal getImpostosValorTotalVeiculos() {
		return impostosValorTotalVeiculos;
	}
	
	public void setImpostosValorTotalVeiculos(BigDecimal impostosValorTotalVeiculos) {
		this.impostosValorTotalVeiculos = impostosValorTotalVeiculos;
	}
	
	public BigDecimal getImpostosAluguel() {
		return impostosAluguel;
	}
	
	public void setImpostosAluguel(BigDecimal impostosAluguel) {
		this.impostosAluguel = impostosAluguel;
	}
	
	public BigDecimal getImpostosFinanciamentoImovel() {
		return impostosFinanciamentoImovel;
	}
	
	public void setImpostosFinanciamentoImovel(BigDecimal impostosFinanciamentoImovel) {
		this.impostosFinanciamentoImovel = impostosFinanciamentoImovel;
	}
	
	public BigDecimal getImpostosFinanciamentoVeiculo() {
		return impostosFinanciamentoVeiculo;
	}
	
	public void setImpostosFinanciamentoVeiculo(BigDecimal impostosFinanciamentoVeiculo) {
		this.impostosFinanciamentoVeiculo = impostosFinanciamentoVeiculo;
	}
	
	public BigDecimal getImpostosSupermercado() {
		return impostosSupermercado;
	}
	
	public void setImpostosSupermercado(BigDecimal impostosSupermercado) {
		this.impostosSupermercado = impostosSupermercado;
	}
	
	public BigDecimal getImpostosConcessionarias() {
		return impostosConcessionarias;
	}
	
	public void setImpostosConcessionarias(BigDecimal impostosConcessionarias) {
		this.impostosConcessionarias = impostosConcessionarias;
	}
	
	public BigDecimal getImpostosSaude() {
		return impostosSaude;
	}
	
	public void setImpostosSaude(BigDecimal impostosSaude) {
		this.impostosSaude = impostosSaude;
	}
	
	public BigDecimal getImpostosTransporte() {
		return impostosTransporte;
	}
	
	public void setImpostosTransporte(BigDecimal impostosTransporte) {
		this.impostosTransporte = impostosTransporte;
	}
	
	public BigDecimal getImpostosVestuario() {
		return impostosVestuario;
	}
	
	public void setImpostosVestuario(BigDecimal impostosVestuario) {
		this.impostosVestuario = impostosVestuario;
	}
	
	public BigDecimal getImpostosEducacao() {
		return impostosEducacao;
	}
	
	public void setImpostosEducacao(BigDecimal impostosEducacao) {
		this.impostosEducacao = impostosEducacao;
	}
	
	public BigDecimal getImpostosOutros() {
		return impostosOutros;
	}
	
	public void setImpostosOutros(BigDecimal impostosOutros) {
		this.impostosOutros = impostosOutros;
	}
	
	public BigDecimal getTotalRendaTrabalho() {
		return totalRendaTrabalho;
	}
	
	public void setTotalRendaTrabalho(BigDecimal totalRendaTrabalho) {
		this.totalRendaTrabalho = totalRendaTrabalho;
	}
	
	public BigDecimal getTotalInssTrabalho() {
		return totalInssTrabalho;
	}
	
	public void setTotalInssTrabalho(BigDecimal totalInssTrabalho) {
		this.totalInssTrabalho = totalInssTrabalho;
	}
	
	public BigDecimal getTotalIRTrabalho() {
		return totalIRTrabalho;
	}
	
	public void setTotalIRTrabalho(BigDecimal totalIRTrabalho) {
		this.totalIRTrabalho = totalIRTrabalho;
	}
	
	public BigDecimal getTotalBurocraciaTrabalho() {
		return totalBurocraciaTrabalho;
	}
	
	public void setTotalBurocraciaTrabalho(BigDecimal totalBurocraciaTrabalho) {
		this.totalBurocraciaTrabalho = totalBurocraciaTrabalho;
	}
	
	public BigDecimal getTotalTributosEmpresaTrabalho() {
		return totalTributosEmpresaTrabalho;
	}
	
	public void setTotalTributosEmpresaTrabalho(BigDecimal totalTributosEmpresaTrabalho) {
		this.totalTributosEmpresaTrabalho = totalTributosEmpresaTrabalho;
	}
	
	public BigDecimal getTotalPerdaInflacaoPorAno() {
		return totalPerdaInflacaoPorAno;
	}
	
	public void setTotalPerdaInflacaoPorAno(BigDecimal totalPerdaInflacaoPorAno) {
		this.totalPerdaInflacaoPorAno = totalPerdaInflacaoPorAno;
	}
	
	public BigDecimal getValorTotalImpostosTrabalho() {
		return valorTotalImpostosTrabalho;
	}

	public void setValorTotalImpostosTrabalho(BigDecimal valorTotalImpostosTrabalho) {
		this.valorTotalImpostosTrabalho = valorTotalImpostosTrabalho;
	}

	public BigDecimal getPorcentagemImpostosTrabalho() {
		return porcentagemImpostosTrabalho;
	}

	public void setPorcentagemImpostosTrabalho(BigDecimal porcentagemImpostosTrabalho) {
		this.porcentagemImpostosTrabalho = porcentagemImpostosTrabalho;
	}

	public BigDecimal getValorTotalGastosMensais() {
		return valorTotalGastosMensais;
	}

	public void setValorTotalGastosMensais(BigDecimal valorTotalGastosMensais) {
		this.valorTotalGastosMensais = valorTotalGastosMensais;
	}

	public BigDecimal getValorTotalImpostosSobreGastosMensais() {
		return valorTotalImpostosSobreGastosMensais;
	}

	public void setValorTotalImpostosSobreGastosMensais(BigDecimal valorTotalImpostosSobreGastosMensais) {
		this.valorTotalImpostosSobreGastosMensais = valorTotalImpostosSobreGastosMensais;
	}

	public BigDecimal getPorcentagemImpostosTotalSobreRenda() {
		return porcentagemImpostosTotalSobreRenda;
	}

	public void setPorcentagemImpostosTotalSobreRenda(BigDecimal porcentagemImpostosTotalSobreRenda) {
		this.porcentagemImpostosTotalSobreRenda = porcentagemImpostosTotalSobreRenda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	@Override
	public String toString() {
		return String
		        .format("Usuario [id=%s, fbId=%s, nome=%s, postar=%s, comentario=%s, nextDay=%s, nextHour=%s, impostosValorTotalImoveis=%s, impostosValorTotalVeiculos=%s, impostosAluguel=%s, impostosFinanciamentoImovel=%s, impostosFinanciamentoVeiculo=%s, impostosSupermercado=%s, impostosConcessionarias=%s, impostosSaude=%s, impostosTransporte=%s, impostosVestuario=%s, impostosEducacao=%s, impostosOutros=%s, totalRendaTrabalho=%s, totalInssTrabalho=%s, totalIRTrabalho=%s, totalBurocraciaTrabalho=%s, totalTributosEmpresaTrabalho=%s, totalPerdaInflacaoPorAno=%s, dataEntrada=%s]",
		                id, fbId, nome, postar, comentario, nextDay, nextHour, impostosValorTotalImoveis,
		                impostosValorTotalVeiculos, impostosAluguel, impostosFinanciamentoImovel, impostosFinanciamentoVeiculo,
		                impostosSupermercado, impostosConcessionarias, impostosSaude, impostosTransporte, impostosVestuario,
		                impostosEducacao, impostosOutros, totalRendaTrabalho, totalInssTrabalho, totalIRTrabalho,
		                totalBurocraciaTrabalho, totalTributosEmpresaTrabalho, totalPerdaInflacaoPorAno, dataEntrada);
	}
	
}
