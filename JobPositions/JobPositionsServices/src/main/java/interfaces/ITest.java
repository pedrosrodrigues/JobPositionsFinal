package interfaces;

import javax.ejb.Local;

import entities.TestEntity;

@Local
public interface ITest {

	public void save(TestEntity ent);

}
