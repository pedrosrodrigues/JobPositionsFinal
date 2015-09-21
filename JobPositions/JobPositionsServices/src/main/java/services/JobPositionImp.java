package services;

import java.util.List;

import interfaces.IJobPosition;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.JobDAO;
import entities.JobEntity;

@Stateless
public class JobPositionImp implements IJobPosition{

	@Inject
	private JobDAO job;

	@Override
	public void saveJob(JobEntity jobentity) {
		// verifica se pode gravar
		// se puder grava na bd
		job.save(jobentity);
	}

	@Override
	public List<JobEntity> findAll() {		
		return job.findAll();
	}

	@Override
	public void updateJob(JobEntity ent) {
		job.update(ent);
	}

	@Override
	public JobEntity findById(Long id) {
		return job.findById(id);		
	}

}
