package rs.ac.uns.ftn.wines.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.wines.domain.Group;

public class GroupDTO {
	private String name;
	private String description;
	
	public GroupDTO() {
		super();
	}
	
	public GroupDTO(Group group) {
		super();
		this.name = group.getName();
		this.description = group.getDescription();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
