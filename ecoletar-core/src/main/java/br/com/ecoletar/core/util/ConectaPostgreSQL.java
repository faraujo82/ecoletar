package br.com.ecoletar.core.util;

import org.hibernate.Session;

public class ConectaPostgreSQL {
	public static void main(String[] args) {
		Session sessao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Conectou!");
		} finally {
			sessao.close();
		}
	}
}
