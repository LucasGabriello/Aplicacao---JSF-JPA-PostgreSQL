package br.com.dominio.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.Gerenciamento.model.BaseTarefa;

public class DAOTarefa<T extends BaseTarefa>implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private static EntityManager manager = ConnectionFactory.getEntityManager();
	public T buscarIdTarefa(Class<T> clTarefa, Long idTarefa) {
		return manager.find(clTarefa, idTarefa);
	}
	
	public void salvarTarefa(T t) {
		try {
			manager.getTransaction().begin();
			
			if (t.getIdTarefa()==null) {
				manager.persist(t);
			}else {
				manager.merge(t);
			}
			
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	public void removerTarefa(Class<T>clTarefa, Long idTarefa) {
		T t = buscarIdTarefa(clTarefa, idTarefa);
		try {
			manager.getTransaction().begin();
			
			manager.remove(t);
			
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarTarefas(String jpql){
		Query query = manager.createNamedQuery(jpql);
		return query.getResultList();
	}
}
