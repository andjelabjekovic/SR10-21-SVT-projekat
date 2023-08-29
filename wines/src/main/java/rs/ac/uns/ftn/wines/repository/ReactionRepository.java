package rs.ac.uns.ftn.wines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.domain.Reaction;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Integer>{
	@Query("SELECT r FROM Reaction r WHERE r.post.id = ?1")
	List<Reaction> getAllReactionsForPost(Integer id);
	
	@Query("SELECT r FROM Reaction r WHERE r.post.id = ?1 and r.user.id = ?2")
	List<Reaction> getAllReactionsForPostAndUser(Integer postId, Integer userId);
	
	@Query("SELECT r FROM Reaction r WHERE r.comment.id = ?1 and r.user.id = ?2")
	List<Reaction> getAllReactionsForCommentAndUser(Integer commentId, Integer userId);
	
	@Query("SELECT r FROM Reaction r WHERE r.comment.id = ?1 ")
	List<Reaction> getAllReactionsForComment(Integer postId);
}
