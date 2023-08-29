package rs.ac.uns.ftn.wines.dto;

import java.time.LocalDate;

import rs.ac.uns.ftn.wines.domain.Comment;

public class CommentDTO {
	private int id;
	private String text;
	private String creationDate;
	private String userDisplayName;
	private int likesNumber;
	private int dislikesNumber;
	private int heartsNumber;

	public CommentDTO() {
		super();
	}

	public CommentDTO(Comment comment) {
		super();
		this.id = comment.getId();
		this.text = comment.getText();
		this.creationDate = comment.getTimestap().toString();
		this.userDisplayName = comment.getUser().getDisplayName();
	}

	public int getLikesNumber() {
		return likesNumber;
	}

	public void setLikesNumber(int likesNumber) {
		this.likesNumber = likesNumber;
	}

	public int getDislikesNumber() {
		return dislikesNumber;
	}

	public void setDislikesNumber(int dislikesNumber) {
		this.dislikesNumber = dislikesNumber;
	}

	public int getHeartsNumber() {
		return heartsNumber;
	}

	public void setHeartsNumber(int heartsNumber) {
		this.heartsNumber = heartsNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
