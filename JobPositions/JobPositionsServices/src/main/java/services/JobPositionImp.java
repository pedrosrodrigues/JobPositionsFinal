package services;

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

}
