package rs.ac.uns.ftn.wines.service.interfaces;

import java.util.List;
import java.util.Optional;

import rs.ac.uns.ftn.wines.domain.GroupAdmin;
import rs.ac.uns.ftn.wines.domain.Reaction;
import rs.ac.uns.ftn.wines.dto.ReactionDTO;



public interface ReactionService {
	List<Reaction> getAll();
	Reaction add(ReactionDTO dto);

	Optional<Reaction> getById(int id);

	Reaction save(Reaction reaction);

}
