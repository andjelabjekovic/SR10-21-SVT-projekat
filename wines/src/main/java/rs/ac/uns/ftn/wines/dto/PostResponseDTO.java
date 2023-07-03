package rs.ac.uns.ftn.wines.dto;

import java.time.format.DateTimeFormatter;

import rs.ac.uns.ftn.wines.domain.Post;

public class PostResponseDTO {
	private int id;
	private String content;
	private String creationDate;
	private String userDisplayName;

	public PostResponseDTO(int id, String content, String creationDate, String userDisplayName) {
		super();
		this.id = id;
		this.content = content;
		this.creationDate = creationDate;
		this.userDisplayName = userDisplayName;
	}
	public PostResponseDTO(Post post) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		this.id = post.getId();
		this.content = post.getContent();
		this.creationDate = post.getCreationDate().format(formatter);
		this.userDisplayName = post.getUser().getDisplayName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

}
