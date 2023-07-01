package rs.ac.uns.ftn.wines.dto;

import rs.ac.uns.ftn.wines.domain.User;

public class RegistrationDTO {
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String displayName;
	private String description;

	public RegistrationDTO() {
		super();
	}

	public RegistrationDTO(String username, String password, String email, String firstName, String lastName,
			String displayName, String description) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.description = description;
	}
	public RegistrationDTO(User user) {
		super();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.displayName = user.getDisplayName();
		this.description = user.getDescription();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
