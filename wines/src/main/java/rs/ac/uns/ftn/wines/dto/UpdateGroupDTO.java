package rs.ac.uns.ftn.wines.dto;

import rs.ac.uns.ftn.wines.domain.Group;

public class UpdateGroupDTO {
	
	private int id;
	private String name;
	private String description;
	
	public UpdateGroupDTO() {
		super();
	}
	
	public UpdateGroupDTO(Group group) {
		super();
		this.id =group.getId() ;
		this.name = group.getName();
		this.description = group.getDescription();
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

}
