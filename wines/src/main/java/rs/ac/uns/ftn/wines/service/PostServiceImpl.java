package rs.ac.uns.ftn.wines.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.wines.domain.Group;
import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.domain.User;
import rs.ac.uns.ftn.wines.dto.PostDTO;
import rs.ac.uns.ftn.wines.repository.GroupRepository;
import rs.ac.uns.ftn.wines.repository.PostRepository;
import rs.ac.uns.ftn.wines.repository.UserRepository;
import rs.ac.uns.ftn.wines.service.interfaces.PostService;

@Service
public class PostServiceImpl implements PostService {

	private GroupRepository groupRepository;
	private PostRepository postRepository;
	private UserRepository userRepository;

	@Autowired
	public PostServiceImpl(PostRepository postRepository, GroupRepository groupRepository,
			UserRepository userRepository) {
		this.postRepository = postRepository;
		this.groupRepository = groupRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Post> getAll() {
		return postRepository.findAll();
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

}
