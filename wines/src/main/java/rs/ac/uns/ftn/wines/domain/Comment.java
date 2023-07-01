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
import javax.persistence.Table;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String text;
	@Column(nullable = false)
	private LocalDate timestap;
	@Column(nullable = false)
	private boolean isDeleted;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	@ManyToOne
    @JoinColumn(name="post_id", nullable=false)
	private Post post;

	public Comment() {
	}

	public Comment(int id, String text, LocalDate timestap, boolean isDeleted, User user, Post post) {

		this.id = id;
		this.text = text;
		this.timestap = timestap;
		this.isDeleted = isDeleted;
		this.user = user;
		this.post = post;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTimestap() {
		return timestap;
	}

	public void setTimestap(LocalDate timestap) {
		this.timestap = timestap;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getTimestep() {
		return timestap;
	}

	public void setTimestep(LocalDate timestap) {
		this.timestap = timestap;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
