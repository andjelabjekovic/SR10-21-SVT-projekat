package rs.ac.uns.ftn.wines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.wines.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	@Query("SELECT p FROM Post p WHERE p.user.id = ?1")
	List<Post> getAllPostsForUser(Integer id);
}