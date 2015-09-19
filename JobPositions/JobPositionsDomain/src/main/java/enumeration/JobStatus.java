package enumeration;

public enum JobStatus {

	OPEN("OPEN"), CLOSED("CLOSED"), ON_HOLD("ON_HOLD");

	private String label;

	JobStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}


	


}



