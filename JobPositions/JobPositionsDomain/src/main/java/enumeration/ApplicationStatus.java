package enumeration;

public enum ApplicationStatus {

	SUBMITTED("SUBMITTED"), INTERVIEWING("INTERVIEWING"), NEGOTIATION(
			"NEGOTIATION"), REJECTED("REJECTED"), HIRED("HIRED");

	private String label;

	ApplicationStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

}
