package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.BidRecord;
import neu.edu.entity.StartupService;
import neu.edu.entity.User;

public interface bidRequestDao extends JpaRepository<BidRecord, Integer>{
	public List<BidRecord> findByStartupService(StartupService startupService);
	public List<BidRecord> findByUser(User user);
}
