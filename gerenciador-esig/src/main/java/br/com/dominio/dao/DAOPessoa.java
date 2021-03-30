package br.com.dominio.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.Gerenciamento.model.BasePessoa;

public class DAOPessoa<P extends BasePessoa>implements Serializable{
	 
		private static final long serialVersionUID = 1L;
		private static EntityManager manager = ConnectionFactory.getEntityManager();
		public P buscarIdPessoa(Class<P> clPessoa, Long idPessoa) {
			return manager.find(clPessoa, idPessoa);
		}
		
		public void salvarPessoa(P p) {
			try {
				manager.getTransaction().begin();
				
				if (p.getIdPessoa()==null) {
					manager.persist(p);
				}else {
					manager.merge(p);
				}
				
				manager.getTransaction().commit();
			} catch (Exception e) {
				manager.getTransaction().rollback();
			}
		}
		
		public void removerPessoa(Class<P>clPessoa, Long idPessoa) {
			P p = buscarIdPessoa(clPessoa, idPessoa);
			try {
				manager.getTransaction().begin();
				
				manager.remove(p);
				
				manager.getTransaction().commit();
			} catch (Exception e) {
				manager.getTransaction().rollback();
			}
			
		}
		
		@SuppressWarnings("unchecked")
		public List<P> buscarPessoa(String jpql){
			Query query = manager.createNamedQuery(jpql);
			return query.getResultList();
		}
	}
