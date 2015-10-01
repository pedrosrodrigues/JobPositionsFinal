package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.JobEntity;

@Local
public interface IJobPosition {

	public void saveJob(JobEntity ent);

	public void updateJob(JobEntity ent);
	
	public void updateJobPosMan (JobEntity ent);

	public List<JobEntity> findAll();

	public JobEntity findById(Long id);

	public List<JobEntity> findAllOpen();
	
	public List<JobEntity> findResponsable (String email);

}
