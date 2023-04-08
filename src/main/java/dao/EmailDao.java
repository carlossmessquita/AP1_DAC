package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Email;
import util.JPAUtil;

// Interage com o DB emaildac p/ inserir, remover e editar registros, dentre outras ações.
public class EmailDao {
	
	public static void salvar(Email e) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Email e) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Email> listar(Email e) {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select e from Email e");
		List<Email> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	public static void excluir(Email e) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		e = em.find(Email.class, e.getId());
		em.remove(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Integer contarEmails() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select count(e) from Email e");
		Integer quantidadeEmails = (Integer) q.getSingleResult();
		return quantidadeEmails;
	}	

}