package rs.ac.uns.ftn.wines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.wines.domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>{

}
