package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Idea;
import neu.edu.entity.StartupService;

public interface serviceDao extends JpaRepository<StartupService, Integer>{

	public List<StartupService> findByIdea(Idea idea);

}
