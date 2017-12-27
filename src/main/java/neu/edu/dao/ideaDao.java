package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Category;
import neu.edu.entity.Idea;
import neu.edu.entity.User;

public interface ideaDao extends JpaRepository<Idea, Integer> {
	public List<Idea> findByCategory(Category category);
	public List<Idea> findByUser(User user);
}
