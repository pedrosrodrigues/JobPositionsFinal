package util;

import java.util.Properties;

import javax.enterprise.context.RequestScoped;

import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class UploadFile {

	private static final Logger log = LoggerFactory.getLogger(UploadFile.class);

	public static final String FOLDER_CUSTOM_LOGOS = "customLogos";
	public static final String FOLDER_USER_CV = "userCV";
	public static final String FOLDER_SUBMISSION_CV = "submissionCV";
	public static final String FOLDER_SUBMISSION_MOTIVATION_LETTER = "submissionMotivationLetter";
	public static final String FOLDER_INTERVIEW_RESULT = "interviewResult";

	public static final String IMAGE_EXTENSION = ".jpg";
	public static final String DOCUMENT_EXTENSION_PDF = ".pdf";
	public static final String DOCUMENT_EXTENSION_WORD = ".doc";

	public void uploadFile(UploadedFile file, String folder, String idName,
			String extension) {
		Properties props = System.getProperties();

		try {
			file.write(props.getProperty("user.dir") + "\\" + folder + "\\"
					+ idName + extension);
			log.info("File " + file.getFileName() + " was saved on " + folder
					+ " with name " + idName + extension);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error writing " + file.getFileName() + " to " + folder
					+ " with new name " + idName + extension);
		}
	}

}
