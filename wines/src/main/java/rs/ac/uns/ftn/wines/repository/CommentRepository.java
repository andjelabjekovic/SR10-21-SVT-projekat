package rs.ac.uns.ftn.wines.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.wines.domain.Comment;
import rs.ac.uns.ftn.wines.domain.Post;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

	@Modifying
	@Query("delete from Comment c where c.post.id=?1")
	void deleteAllCommentsDoPost(Integer id);
	
	@Query("select c from Comment c where c.post.id=?1")
	List<Comment> getAllCommentsForPost(Integer id);
}