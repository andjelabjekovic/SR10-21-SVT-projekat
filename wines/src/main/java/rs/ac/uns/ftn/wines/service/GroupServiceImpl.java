package rs.ac.uns.ftn.wines.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.wines.domain.Group;
import rs.ac.uns.ftn.wines.domain.GroupAdmin;
import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.domain.User;
import rs.ac.uns.ftn.wines.dto.GroupDTO;
import rs.ac.uns.ftn.wines.dto.PostDTO;
import rs.ac.uns.ftn.wines.repository.AdminGroupRepository;
import rs.ac.uns.ftn.wines.repository.GroupRepository;
import rs.ac.uns.ftn.wines.repository.UserRepository;
import rs.ac.uns.ftn.wines.service.interfaces.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdminGroupRepository adminGroupRepository;

	@Override
	public List<Group> getAll() {
		return groupRepository.findAll();
	}

	@Override
	public Optional<Group> getById(int id) {
		return groupRepository.findById(id);
	}

	@Override
	public Group save(Group group) {
		try {
			return groupRepository.save(group);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public Group add(GroupDTO dto) {
		LocalDateTime creationDate = LocalDateTime.now();

		
		Group group = new Group(0, dto.getName(), dto.getDescription(), creationDate, false, "");
		group = this.groupRepository.save(group);
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Optional<User> userOpt = userRepository.findByUsername(username);
		if (userOpt.isEmpty()) {
			return null;
		}
		User user = userOpt.get();
		
		GroupAdmin groupAdmin = new GroupAdmin(0, user, group);
		adminGroupRepository.save(groupAdmin);
		return group;
	}

}
