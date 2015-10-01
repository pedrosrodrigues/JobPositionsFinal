package services;

import interfaces.IInterview;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.InterviewDAO;
import entities.InterviewEntity;

@Stateless
public class InterviewImp implements IInterview {

	@Inject
	private InterviewDAO idao;

	@Override
	public void saveInterview(InterviewEntity ent) {
		idao.saveInterview(ent);

	}

	@Override
	public List<InterviewEntity> findMyInterviews(Long id) {
		return idao.findMyInterviews(id);
	}

	@Override
	public List<InterviewEntity> findAll() {
		return idao.findAll();
	}

}
