package neu.edu.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.IdeaOption;
import neu.edu.entity.Idea;

public interface ideaoptionDao extends JpaRepository<IdeaOption, Integer>{
	public List<IdeaOption> findByIdea(Idea id);
}
