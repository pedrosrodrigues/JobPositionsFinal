package services;

import interfaces.ICandidate;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CandidateDAO;
import entities.CandidateEntity;

@Stateless
public class CandidateImp implements ICandidate {

	@Inject
	private CandidateDAO cd;

	@Override
	public void saveCandidate(CandidateEntity candidateentity) {

		// verifica se pode gravar

		// se puder grava na bd

		cd.save(candidateentity);

	}
}
