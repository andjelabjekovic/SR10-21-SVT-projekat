package rs.ac.uns.ftn.wines.dto;

import rs.ac.uns.ftn.wines.domain.Reaction;
import rs.ac.uns.ftn.wines.domain.enums.ReactionType;

public class ReactionDTO {

	private ReactionType type;
	private int postId;
	private int commentId;

	public ReactionDTO() {
		super();
	}

	public ReactionDTO(Reaction reaction) {
		super();
		this.type = reaction.getType();
		this.commentId = reaction.getComment().getId();
		this.postId = reaction.getPost().getId();
	}

	public ReactionType getType() {
		return type;
	}

	public void setType(ReactionType type) {
		this.type = type;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	
}
