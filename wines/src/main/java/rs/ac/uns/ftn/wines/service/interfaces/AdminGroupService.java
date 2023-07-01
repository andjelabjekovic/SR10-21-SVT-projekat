package rs.ac.uns.ftn.wines.service.interfaces;

import java.util.List;
import java.util.Optional;

import rs.ac.uns.ftn.wines.domain.GroupAdmin;

public interface AdminGroupService {
	List<GroupAdmin> getAll();

	Optional<GroupAdmin> getById(int id);

	GroupAdmin save(GroupAdmin groupAdmin);

}
