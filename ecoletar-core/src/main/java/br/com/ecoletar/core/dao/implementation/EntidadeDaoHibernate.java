package br.com.ecoletar.core.dao.implementation;

import java.util.List;

import org.hibernate.Session;

import br.com.ecoletar.core.dao.EntidadeDao;
import br.com.ecoletar.core.model.Entidade;

public class EntidadeDaoHibernate implements EntidadeDao{
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Entidade entidade) {
		this.session.save(entidade);		
	}

	@Override
	public void atualizar(Entidade entidade) {
		this.session.update(entidade);		
	}

	@Override
	public void excluir(Entidade entidade) {
		this.session.delete(entidade);	
	}

	@Override
	public Entidade carregar(Long codigo) {
		return (Entidade) this.session.get(Entidade.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> listar() {
		return this.session.createCriteria(Entidade.class).list();
	}

}
