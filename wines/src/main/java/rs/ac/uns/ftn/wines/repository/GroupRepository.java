package rs.ac.uns.ftn.wines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.wines.domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>{

	@Query(value = "SELECT g.* FROM groups g, group_admin ga  WHERE ga.user_id = ?1 and ga.group_id = g.id", nativeQuery = true)
	List<Group> getAllGroupsForUser(Integer id);
}
