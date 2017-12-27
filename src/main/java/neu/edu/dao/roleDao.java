package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Role;

public interface roleDao extends JpaRepository<Role, Integer>{
	public List<Role> findByroleName(String roleName);
}
