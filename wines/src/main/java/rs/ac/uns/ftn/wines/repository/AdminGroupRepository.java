package rs.ac.uns.ftn.wines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.wines.domain.GroupAdmin;

@Repository
public interface AdminGroupRepository extends JpaRepository<GroupAdmin, Integer>{

}
