package br.com.ecoletar.core.util;

import br.com.ecoletar.core.dao.EntidadeDao;
import br.com.ecoletar.core.dao.implementation.EntidadeDaoHibernate;

public class DaoFactory {
	
	public static EntidadeDao criarEntidadeDao(){
		EntidadeDaoHibernate entidadeDao = new EntidadeDaoHibernate();
		entidadeDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return entidadeDao;
	}
	
}
