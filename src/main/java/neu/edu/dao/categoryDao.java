package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Category;

public interface categoryDao extends JpaRepository<Category, Integer>{
	
	public Category findBycategoryName(String name);

}
