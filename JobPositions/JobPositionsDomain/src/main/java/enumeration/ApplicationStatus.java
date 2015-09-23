package enumeration;

public enum ApplicationStatus {
	
	NEW("NEW"), OPEN("OPEN"), CLOSED("CLOSED"), ON_HOLD("ON_HOLD");

	private String label;

	ApplicationStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}


	

}
