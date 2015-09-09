package testemain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.TestEntity;

public class TesteOperacoesBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JP");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trx = em.getTransaction();

		trx.begin();

		TestEntity ent = new TestEntity();
		ent.setName("Filipa e Joao");
		ent.setNumber(23523);
		em.persist(ent);

		trx.commit();
	}

}
