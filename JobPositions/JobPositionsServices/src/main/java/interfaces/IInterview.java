package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.InterviewEntity;

@Local
public interface IInterview {

	public void saveInterview(InterviewEntity ent);

	public List<InterviewEntity> findMyInterviews(Long id);

	public List<InterviewEntity> findAll();

}
