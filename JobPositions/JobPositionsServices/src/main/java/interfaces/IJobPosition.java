package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.JobEntity;

@Local
public interface IJobPosition {

	public void saveJob(JobEntity ent);
	
	public void updateJob(JobEntity ent);

	public List<JobEntity> findAll();


}
