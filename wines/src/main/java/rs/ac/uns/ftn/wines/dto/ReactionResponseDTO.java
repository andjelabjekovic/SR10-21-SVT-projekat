package rs.ac.uns.ftn.wines.dto;

import rs.ac.uns.ftn.wines.domain.Reaction;

public class ReactionResponseDTO {
	private String type;
	private String date;
	private String userFullName;

	public ReactionResponseDTO() {

	}

	public ReactionResponseDTO(Reaction reaction) {
		this.type = reaction.getType().toString();
		this.date = reaction.getTimestamp().toString();
		this.userFullName = reaction.getUser().getFirstName() + " " + reaction.getUser().getLastName();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

}
