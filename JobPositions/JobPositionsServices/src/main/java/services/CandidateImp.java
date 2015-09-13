package services;

import interfaces.ICandidate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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

		// Encriptação da password do utilizador!
		try {
			candidateentity.setPassword(passEncript(candidateentity
					.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cd.save(candidateentity);
	}

	public static String passEncript(String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String securedPassword = "";

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());

			byte byteData[] = md.digest();
			byte[] data2 = Base64.getEncoder().encode(byteData);
			securedPassword = new String(data2);
			return securedPassword;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return securedPassword;
	}
}
