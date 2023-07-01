package rs.ac.uns.ftn.wines.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FriendRequest {
	
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
	private User userFrom;
	@Column(nullable = false)
	private User userFor;
	
	public FriendRequest() {}
	
	public FriendRequest(int id,boolean approved, LocalDateTime createdAt,LocalDateTime at, User userFrom,User userFor) {
		
		 this.id=id;	
		 this.approved = approved;
		 this.createdAt = createdAt;
		 this.at = at;
		 this.userFrom = userFrom;
		 this.userFor = userFor;
		 
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

	public User getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}

	public User getUserFor() {
		return userFor;
	}

	public void setUserFor(User userFor) {
		this.userFor = userFor;
	}

	public LocalDateTime getAt() {
		return at;
	}

	public void setAt(LocalDateTime at) {
		this.at = at;
	}


}
