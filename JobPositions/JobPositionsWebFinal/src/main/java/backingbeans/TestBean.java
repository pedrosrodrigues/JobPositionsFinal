package backingbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.TestDAO;

@SessionScoped
@Named
public class TestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TestDAO td;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private String name;
	private int number;

	public void saveTest() {
		// TestEntity ent = new TestEntity(this.name, this.number);

		System.out.println("name: " + this.name + " number: " + this.number);

	}

}
