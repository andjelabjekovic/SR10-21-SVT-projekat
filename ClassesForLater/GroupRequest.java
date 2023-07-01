package rs.ac.uns.ftn.wines.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GroupRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private boolean approved;
	@Column(nullable = false)
	private LocalDateTime createdAt;
	@Column(nullable = false)
	private LocalDateTime at;
	@Column(nullable = false)
	private User userCreatedBy;
	@Column(nullable = false)
	private Group group;
	
	
	public GroupRequest() {}
	
	public GroupRequest(int id,boolean approved, LocalDateTime createdAt,LocalDateTime at, User userCreatedBy, Group group) {
		
		 this.id=id;	
		 this.approved = approved;
		 this.createdAt = createdAt;
		 this.at = at;
		 this.userCreatedBy = userCreatedBy;
		 this.group = group;
		 
		 
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getUserCreatedBy() {
		return userCreatedBy;
	}

	public void setUserCreatedBy(User userCreatedBy) {
		this.userCreatedBy = userCreatedBy;
	}


	public LocalDateTime getAt() {
		return at;
	}

	public void setAt(LocalDateTime at) {
		this.at = at;
	}

}
