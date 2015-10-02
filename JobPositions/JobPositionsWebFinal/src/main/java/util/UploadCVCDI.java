package util;

import interfaces.ICandidate;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import backingbeans.SystemUser;

@Named
@RequestScoped
public class UploadCVCDI {

	@Inject
	private UploadFile uploadFile;

	@Inject
	private SystemUser su;
	@Inject
	private ICandidate ic;

	private UploadedFile file;

	public void uploadCV(FileUploadEvent event) {
		this.file = event.getFile();
		this.uploadFile.uploadFile(
				this.file,
				UploadFile.FOLDER_USER_CV,
				su.getUserlogado().getId()
						+ ic.findByEmail(su.getUserlogado().getEmail())
								.getFirstname()
						+ ic.findByEmail(su.getUserlogado().getEmail())
								.getLastname() + "CV",
				UploadFile.DOCUMENT_EXTENSION_PDF);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("CV updated!"));
	}

	public void uploadML(FileUploadEvent event) {
		this.file = event.getFile();
		this.uploadFile.uploadFile(
				this.file,
				UploadFile.FOLDER_USER_CV,
				su.getUserlogado().getId()
						+ ic.findByEmail(su.getUserlogado().getEmail())
								.getFirstname()
						+ ic.findByEmail(su.getUserlogado().getEmail())
								.getLastname() + "ML",
				UploadFile.DOCUMENT_EXTENSION_PDF);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("CV updated!"));
	}

}
