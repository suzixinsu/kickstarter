package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.User;

@Repository
public interface userDao extends JpaRepository<User, Integer>{
	
	User findByuserUsername(String userName);
}
