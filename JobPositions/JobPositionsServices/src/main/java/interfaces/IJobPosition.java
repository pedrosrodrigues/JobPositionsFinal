package interfaces;

import javax.ejb.Local;

import entities.JobEntity;

@Local
public interface IJobPosition {

	public void saveJob(JobEntity ent);
}
