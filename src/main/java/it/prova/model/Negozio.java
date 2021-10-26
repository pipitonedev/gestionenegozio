package it.prova.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "negozio")
public class Negozio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "ragionesociale")
	private String ragioneSociale;
	@Column(name = "partitaiva")
	private String partitaIva;
	@Column(name = "fatturato")
	private Integer fatturato;
	@Column(name = "dataapertura")
	private Date dataApertura;

	public Negozio() {

	}

	public Negozio(String ragioneSociale, String partitaIva, Integer fatturato, Date dataApertura) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.fatturato = fatturato;
		this.dataApertura = dataApertura;
	}

	public Negozio(String ragioneSociale, String partitaIva) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Integer getFatturato() {
		return fatturato;
	}

	public void setFatturato(Integer fatturato) {
		this.fatturato = fatturato;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

}
