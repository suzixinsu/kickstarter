package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.PurchaseRecord;
import neu.edu.entity.User;

public interface purchaseRecordDao extends JpaRepository<PurchaseRecord, Integer> {
	public List<PurchaseRecord> findByuser(User user);
}
