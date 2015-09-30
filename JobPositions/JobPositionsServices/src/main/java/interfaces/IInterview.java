package interfaces;

import javax.ejb.Local;

import entities.InterviewEntity;

@Local
public interface IInterview {
	
	public boolean saveInterview (InterviewEntity ent);

}
