package rs.ac.uns.ftn.wines.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.wines.domain.Post;

public class PostDTO {
	private String content;
	private int groupId;

	public PostDTO() {
		super();
	}

	public PostDTO(Post post) {
		super();
		this.content = post.getContent();
		this.groupId = post.getGroup().getId();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
