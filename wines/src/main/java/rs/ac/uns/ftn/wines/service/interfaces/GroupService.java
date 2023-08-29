package rs.ac.uns.ftn.wines.service.interfaces;

import java.util.List;
import java.util.Optional;

import rs.ac.uns.ftn.wines.domain.Group;
import rs.ac.uns.ftn.wines.domain.GroupAdmin;
import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.dto.GroupDTO;

import rs.ac.uns.ftn.wines.dto.UpdateGroupDTO;


public interface GroupService {
	List<Group> getAll();

	Optional<Group> getById(int id);

	Group save(Group group);
	
	Group add(GroupDTO dto);
	
	Group update(UpdateGroupDTO dto);
	
	List<Group> getAllForLogged();
}

