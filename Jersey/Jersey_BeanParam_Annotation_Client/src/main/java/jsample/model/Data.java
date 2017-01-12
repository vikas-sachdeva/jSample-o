package jsample.model;

public class Data {

	private String contentType;

	private String name;

	private String role;

	private String displayName;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "Data [contentType=" + contentType + ", name=" + name + ", role=" + role + ", displayName=" + displayName
				+ "]";
	}

}
