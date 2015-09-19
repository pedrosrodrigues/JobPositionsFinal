package enumeration;

public enum RoleEntity {

	CANDIDATE, ADMINISTRATOR, INTERVIEWER, MANAGER;
	
	private String role;

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
