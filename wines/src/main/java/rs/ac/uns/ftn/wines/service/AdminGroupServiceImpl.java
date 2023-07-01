package rs.ac.uns.ftn.wines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.wines.domain.GroupAdmin;
import rs.ac.uns.ftn.wines.repository.AdminGroupRepository;
import rs.ac.uns.ftn.wines.service.interfaces.AdminGroupService;

@Service
public class AdminGroupServiceImpl implements AdminGroupService {
	@Autowired
	AdminGroupRepository adminGroupRepository;

	@Override
	public List<GroupAdmin> getAll() {
		return adminGroupRepository.findAll();
	}

	@Override
	public Optional<GroupAdmin> getById(int id) {
		return adminGroupRepository.findById(id);
	}

	@Override
	public GroupAdmin save(GroupAdmin groupAdmin) {
		try {
			return adminGroupRepository.save(groupAdmin);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	
}
