package rs.ac.uns.ftn.wines.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private LocalDateTime creationDate;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	@ManyToOne
    @JoinColumn(name="group_id", nullable=true)
	private Group group;
	
	
	
	
	public Post() {}
	
	public Post( int id,String content,LocalDateTime creationDate,User user,Group group) {
		
		 this.id = id;
		 this.content = content;
		 this.creationDate = creationDate;
		 this.user = user;
		 this.group = group;
		
		 
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getContent() {
	    return content;
	  }

	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setContent(String content) {
	    this.content = content;
	  }

	public LocalDateTime getCreationDate() {
	    return creationDate;
	  }

	
    public void setCreationDated(LocalDateTime creationDate) {
	    this.creationDate = creationDate;
	  }

    public User getUser() {
	    return user;
	  }

	
    public void setUser(User user) {
	    this.user = user;
	  }
    

}
