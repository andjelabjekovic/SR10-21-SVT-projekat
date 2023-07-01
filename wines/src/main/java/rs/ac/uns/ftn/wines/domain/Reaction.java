package rs.ac.uns.ftn.wines.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import rs.ac.uns.ftn.wines.domain.enums.ReactionType;
@Entity
public class Reaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	@Column(nullable = false)
	private  ReactionType type;
	@Column(nullable = false)
	private LocalDate timestamp;
	@ManyToOne
    @JoinColumn(name="post_id", nullable=true)
	private Post post;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	@ManyToOne
    @JoinColumn(name="comment_id", nullable=true)
	private Comment comment;
	
	
	
	public Reaction() {}
	
	public Reaction(int id,ReactionType type,LocalDate timestamp,Post post,User user,  Comment comment) {
		 this.id = id;
		 this.type = type;
		 this.timestamp = timestamp;
		 this.post = post;
		 this.user = user;
		 this.comment = comment;
		
		 
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReactionType getType() {
		return type;
	}

	public void setType(ReactionType type) {
		this.type = type;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimesTamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
