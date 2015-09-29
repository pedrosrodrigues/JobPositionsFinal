package backingbeans;

import java.io.Serializable;

public class Questions implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String questions;
	
	public Questions() {
		
	}

	public Questions(String questions) {
		super();
		this.questions = questions;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

}
