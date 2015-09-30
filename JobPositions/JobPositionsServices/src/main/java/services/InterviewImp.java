package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.InterviewDAO;
import entities.InterviewEntity;
import interfaces.IInterview;

@Stateless
public class InterviewImp implements IInterview {
	
	@Inject
	private InterviewDAO id;

	@Override
	public boolean saveInterview(InterviewEntity ent) {
		id.saveInterview(ent);
		return false;
		
	}

}
