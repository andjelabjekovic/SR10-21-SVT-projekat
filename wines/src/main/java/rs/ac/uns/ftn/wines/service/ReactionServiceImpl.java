package rs.ac.uns.ftn.wines.service;

import java.time.LocalDate;
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
import rs.ac.uns.ftn.wines.dto.ReactionDTO;
import rs.ac.uns.ftn.wines.repository.CommentRepository;
import rs.ac.uns.ftn.wines.repository.PostRepository;
import rs.ac.uns.ftn.wines.repository.ReactionRepository;
import rs.ac.uns.ftn.wines.repository.UserRepository;
import rs.ac.uns.ftn.wines.service.interfaces.ReactionService;

@Service
public class ReactionServiceImpl implements ReactionService {

	
	private ReactionRepository reactionRepository;
	private PostRepository postRepository;
	private CommentRepository commentRepository;
	private UserRepository userRepository;

	@Autowired
	public ReactionServiceImpl(ReactionRepository reactionRepository, PostRepository postRepository,
			CommentRepository commentRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
		this.reactionRepository = reactionRepository;
		this.commentRepository = commentRepository;
	}


	@Override
	public List<Reaction> getAll() {
		return reactionRepository.findAll();
	}

	@Override
	public Optional<Reaction> getById(int id) {
		return reactionRepository.findById(id);
	}

	@Override
	public Reaction save(Reaction reaction) {
		try {
			return reactionRepository.save(reaction);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public Reaction add(ReactionDTO dto) {
		LocalDate creationDate = LocalDate.now();
		int postId = dto.getPostId();
		Post post = null;
		if (postId != -1) {
			Optional<Post> postResponse = postRepository.findById(postId);
			post = postResponse.get();

		}
		int commentId = dto.getCommentId();
		Comment comment = null;
		if (commentId != -1) {
			Optional<Comment> commentResponse = commentRepository.findById(commentId);
			comment = commentResponse.get();
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Optional<User> userOpt = userRepository.findByUsername(username);
		if (userOpt.isEmpty()) {
			return null;
		}
		User user = userOpt.get();

		Reaction reaction = new Reaction(0, dto.getType(), creationDate, post, user, comment);
		reaction = reactionRepository.save(reaction);
		return reaction;
	}

}
