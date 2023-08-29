package rs.ac.uns.ftn.wines.dto;

public class CreationCommentDTO {
	private String text;
	private int postId;
	
	public CreationCommentDTO() {
		super();
	}

	public CreationCommentDTO(String text, int postId) {
		super();
		this.text = text;
		this.postId = postId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
	
}
