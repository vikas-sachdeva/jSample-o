package jsample.model;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class Data {

	@HeaderParam("Content-Type")
	private String contentType;

	@PathParam(value = "name")
	private String name;

	@QueryParam("role")
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
