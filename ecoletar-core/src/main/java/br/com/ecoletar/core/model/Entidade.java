package br.com.ecoletar.core.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "entidade")
public class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identidade")
	private Long idEntidade;

	@ManyToMany
	@JoinTable(name = "entidade_segmento", joinColumns = { @JoinColumn(name = "identidade") }, inverseJoinColumns = { @JoinColumn(name = "idsegmento") })
	private Set<Segmento> segmento = new HashSet<Segmento>();


	@Column(name = "nome", length = 70)
	private String nome;

	@Column(name = "telefone", length = 50)
	private String telefone;

	@Column(name = "fax", length=70)
    private String fax;
	
	@Column(name = "contato", length = 50)
	private String contato;

	@Column(name = "coleta")
	private boolean coleta = false;

	@Column(name = "observacao", length = 500)
	private String observacao;

	@Column(name = "email", length=70)
    private String email;

	@Column(name = "website", length=70)
    private String website;
	
	// latitude
	// longitude

	@Column(name = "datacadastro")
	private Timestamp dataCadastro;

	public Long getIdEntidade() {
		return idEntidade;
	}

	public void setIdEntidade(Long idEntidade) {
		this.idEntidade = idEntidade;
	}

	public Set<Segmento> getSegmento() {
		return segmento;
	}

	public void setSegmento(Set<Segmento> segmento) {
		this.segmento = segmento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public boolean isColeta() {
		return coleta;
	}

	public void setColeta(boolean coleta) {
		this.coleta = coleta;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
