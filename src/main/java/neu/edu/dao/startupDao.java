package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Startup;

public interface startupDao extends JpaRepository<Startup, Integer>{
	
}
