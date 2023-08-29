package rs.ac.uns.ftn.wines.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.wines.domain.Group;
import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.domain.Reaction;
import rs.ac.uns.ftn.wines.domain.User;
import rs.ac.uns.ftn.wines.domain.enums.ReactionType;
import rs.ac.uns.ftn.wines.dto.PostDTO;
import rs.ac.uns.ftn.wines.dto.PostResponseDTO;
import rs.ac.uns.ftn.wines.dto.UpdatePostDTO;
import rs.ac.uns.ftn.wines.repository.CommentRepository;
import rs.ac.uns.ftn.wines.repository.GroupRepository;
import rs.ac.uns.ftn.wines.repository.PostRepository;
import rs.ac.uns.ftn.wines.repository.ReactionRepository;
import rs.ac.uns.ftn.wines.repository.UserRepository;
import rs.ac.uns.ftn.wines.service.interfaces.PostService;

@Service
public class PostServiceImpl implements PostService {

	private GroupRepository groupRepository;
	private PostRepository postRepository;
	private UserRepository userRepository;
	private CommentRepository commentRepository;
	private ReactionRepository reactionRepository;

	@Autowired
	public PostServiceImpl(PostRepository postRepository, GroupRepository groupRepository,
			UserRepository userRepository, CommentRepository commentRepository, ReactionRepository reactionRepository) {
		this.postRepository = postRepository;
		this.groupRepository = groupRepository;
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
		this.reactionRepository = reactionRepository;
	}

	@Override
	public List<PostResponseDTO> getAll() {
		List<Post> posts = postRepository.findAll();
		ArrayList<PostResponseDTO> dtos = new ArrayList<PostResponseDTO>();
		for(Post post : posts) {
			dtos.add(new PostResponseDTO(post));
		}

		fillDtosWithLikesNumber(dtos);
		return dtos;
	}
	private void fillDtosWithLikesNumber(ArrayList<PostResponseDTO> dtos) {
		for(PostResponseDTO dto : dtos) {
			int postId = dto.getId();
			List<Reaction> reactions = reactionRepository.getAllReactionsForPost(postId);
			for(Reaction reaction : reactions) {
				if(reaction.getType() == ReactionType.LIKE) {
					dto.setLikesNumber(dto.getLikesNumber() + 1);
				}
				if(reaction.getType() == ReactionType.DISLIKE) {
					dto.setDislikesNumber(dto.getDislikesNumber() + 1);
				}
				if(reaction.getType() == ReactionType.HEART) {
					dto.setHeartsNumber(dto.getHeartsNumber() + 1);
				}
			}
			
		}
	}
	@Override
	public List<Post> getAllForLogged() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Optional<User> userOpt = userRepository.findByUsername(username);
		if (userOpt.isEmpty()) {
			return null;
		}
		User user = userOpt.get();
		
		return postRepository.getAllPostsForUser(user.getId());
	}

	@Override
	public Optional<Post> getById(int id) {
		return postRepository.findById(id);
	}

	@Override
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

	@Override
	public Post update(UpdatePostDTO dto) {
		Post post = postRepository.findById(dto.getId()).get();
		if(post == null) {
			return null;
		}
		post.setContent(dto.getContent());
		postRepository.save(post);
		return post;
	}
	@Override
	@Transactional
	public void delete(int id) {
		commentRepository.deleteAllCommentsDoPost(id);
		postRepository.deleteById(id);
	}

}
