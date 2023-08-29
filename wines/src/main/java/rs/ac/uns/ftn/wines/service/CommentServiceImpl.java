package rs.ac.uns.ftn.wines.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.wines.domain.Comment;
import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.domain.Reaction;
import rs.ac.uns.ftn.wines.domain.User;
import rs.ac.uns.ftn.wines.domain.enums.ReactionType;
import rs.ac.uns.ftn.wines.dto.CommentDTO;
import rs.ac.uns.ftn.wines.dto.CreationCommentDTO;
import rs.ac.uns.ftn.wines.repository.CommentRepository;
import rs.ac.uns.ftn.wines.repository.PostRepository;
import rs.ac.uns.ftn.wines.repository.ReactionRepository;
import rs.ac.uns.ftn.wines.repository.UserRepository;
import rs.ac.uns.ftn.wines.service.interfaces.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	CommentRepository commentRepository;
	private ReactionRepository reactionRepository;
	private PostRepository postRepository;
	private UserRepository userRepository;

	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository, ReactionRepository reactionRepository, PostRepository postRepository, UserRepository userRepository) {
		this.commentRepository = commentRepository;
		this.reactionRepository = reactionRepository;
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Comment> getAll() {
		return commentRepository.findAll();
	}

	@Override
	public Optional<Comment> getById(int id) {
		return commentRepository.findById(id);
	}

	@Override
	public Comment create(CreationCommentDTO dto) {
		LocalDate creationDate = LocalDate.now();
		int postId = dto.getPostId();
		Post post = postRepository.findById(postId).get();
		if(post == null) {
			return null;
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Optional<User> userOpt = userRepository.findByUsername(username);
		if (userOpt.isEmpty()) {
			return null;
		}
		User user = userOpt.get();
		
		Comment comment = new Comment(0, dto.getText(), creationDate, false, user, post);
		comment = this.commentRepository.save(comment);
		return comment;
	}
	
	/*	@Override
	public Post add(PostDTO dto) {
		LocalDateTime creationDate = LocalDateTime.now();
		int groupId = dto.getGroupId();
		Group group = null;
		if (groupId != -1) {
			Optional<Group> groupResponse = groupRepository.findById(groupId);
			group = groupResponse.get();
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Optional<User> userOpt = userRepository.findByUsername(username);
		if (userOpt.isEmpty()) {
			return null;
		}
		User user = userOpt.get();
		

		Post post = new Post(0, dto.getContent(), creationDate, user, group);
		post = this.postRepository.save(post);
		return post;
	}
*/
	

	private void fillDtosWithLikesNumber(ArrayList<CommentDTO> dtos) {
		for (CommentDTO dto : dtos) {
			int commentId = dto.getId();
			List<Reaction> reactions = reactionRepository.getAllReactionsForComment(commentId);
			for (Reaction reaction : reactions) {
				if (reaction.getType() == ReactionType.LIKE) {
					dto.setLikesNumber(dto.getLikesNumber() + 1);
				}
				if (reaction.getType() == ReactionType.DISLIKE) {
					dto.setDislikesNumber(dto.getDislikesNumber() + 1);
				}
				if (reaction.getType() == ReactionType.HEART) {
					dto.setHeartsNumber(dto.getHeartsNumber() + 1);
				}
			}

		}
	}

	@Override
	public List<CommentDTO> getAllForPost(int postId) {
		List<Comment> comments = commentRepository.getAllCommentsForPost(postId);
		ArrayList<CommentDTO> dtos = new ArrayList<CommentDTO>();
		for (Comment commet : comments) {
			dtos.add(new CommentDTO(commet));
		}
		fillDtosWithLikesNumber(dtos);
		return dtos;
	}
}
