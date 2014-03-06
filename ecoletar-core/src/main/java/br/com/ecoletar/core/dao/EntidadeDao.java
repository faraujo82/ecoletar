package br.com.ecoletar.core.dao;

import java.util.List;

import br.com.ecoletar.core.model.Entidade;

public interface EntidadeDao {
	
	public void salvar(Entidade entidade);
	public void atualizar(Entidade entidade);
	public void excluir(Entidade entidade);
	public Entidade carregar(Long codigo);
	public List<Entidade> listar();
	
}
