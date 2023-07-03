package rs.ac.uns.ftn.wines.dto;

import java.time.format.DateTimeFormatter;

import rs.ac.uns.ftn.wines.domain.Group;
import rs.ac.uns.ftn.wines.domain.Post;

	public class GroupResponseDTO {
		private int id;
		private String name;
		private String description;
		private String creationDate;
	
	public GroupResponseDTO(int id, String name, String creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		
	}
	public GroupResponseDTO(Group group) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		this.id = group.getId();
		this.description = group.getDescription();
		this.name = group.getName();
		this.creationDate = group.getCreationDate().format(formatter);
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
}
