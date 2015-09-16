package enumeration;

public enum JobStatus {
	
	OPEN, CLOSED, ON_HOLD;
	
	private String jobStatus;

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	
	

}
