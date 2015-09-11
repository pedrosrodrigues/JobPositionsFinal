package services;

import interfaces.ITest;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.TestDAO;
import entities.TestEntity;

@Stateless
public class TestImplementation implements ITest {

	@Inject
	private TestDAO td;

	@Override
	public void save(TestEntity ent) {
		// verifica se pode salvar

		// se sim entao vamos gravar isto.

		td.save(ent);

	}

}
