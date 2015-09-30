package interfaces;

import javax.ejb.Local;

import entities.InterviewEntity;

@Local
public interface IInterview {
	
	public void saveInterview (InterviewEntity ent);

}
