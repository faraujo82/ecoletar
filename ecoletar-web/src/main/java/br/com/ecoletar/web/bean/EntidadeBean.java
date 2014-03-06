package br.com.ecoletar.web.bean;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.ecoletar.core.model.Entidade;
import br.com.ecoletar.core.service.EntidadeService;

@ManagedBean(name="entidadeBean")
@RequestScoped
public class EntidadeBean {
	
	private Entidade entidade = new Entidade();
	private List<Entidade> lista;

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public String novo(){
		this.entidade = new Entidade();
		this.entidade.setColeta(false);
		this.entidade.setSegmento(null);
		return "entidade"; 
	}
	
	public String salvar(){
		EntidadeService entidadeService = new EntidadeService();
		this.entidade.setDataCadastro(new Timestamp(System.currentTimeMillis()));
		entidadeService.salvar(entidade);
		return "entidadeSucesso";
	}
		
	public List<Entidade> getLista() {
		if (this.lista ==null){
			EntidadeService entidadeService = new EntidadeService();
			this.lista = entidadeService.listar();
		}		
		return this.lista;
	}

	public void setLista(List<Entidade> lista) {
		this.lista = lista;
	}
	
}
