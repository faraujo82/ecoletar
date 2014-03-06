package br.com.ecoletar.core.service;

import java.util.List;

import br.com.ecoletar.core.dao.EntidadeDao;
import br.com.ecoletar.core.model.Entidade;
import br.com.ecoletar.core.util.DaoFactory;

public class EntidadeService {
	
	private EntidadeDao entidadeDao;
	
	public EntidadeService(){
		this.entidadeDao = DaoFactory.criarEntidadeDao();
	}
	
	public Entidade carregar(Long codigo){
		return this.entidadeDao.carregar(codigo);
	}
	
	public void salvar(Entidade entidade) {
		if (entidade.getIdEntidade() == null || entidade.getIdEntidade() == 0) {
			this.entidadeDao.salvar(entidade);
		} else {
			this.entidadeDao.atualizar(entidade);
		}
	}
	
	public void excluir(Entidade entidade){
		this.entidadeDao.excluir(entidade);
	}
	
	public List<Entidade> listar(){
		return this.entidadeDao.listar();
	}
}
