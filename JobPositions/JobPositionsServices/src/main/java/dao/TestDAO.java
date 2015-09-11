package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class TestDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

}
