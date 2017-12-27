package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.dao.bidRequestDao;
import neu.edu.dao.userDao;
import neu.edu.dao.serviceDao;

import neu.edu.entity.BidRecord;
import neu.edu.entity.StartupService;
import neu.edu.entity.User;
import neu.edu.controller.bid.bidReturn;
import neu.edu.controller.bid.createBid;
@Service
public class bidService {
	
	@Autowired
	private bidRequestDao bidRequestDao;
	
	@Autowired
	private userDao userDao;
	
	@Autowired
	private serviceDao serviceDao;
	
	@Transactional
	public boolean createBid(createBid createBid) {
		
		BidRecord bidRecord = new BidRecord();
		bidRecord.setBidAmount(createBid.getBidAmount());
		bidRecord.setBidEnddate(createBid.getBidEnddate());
		bidRecord.setBidRecordStatus("Active");
		bidRecord.setBidStartdate(createBid.getBidStartdate());
		bidRecord.setUser(userDao.findByuserUsername(createBid.getStartupName()));
		bidRecord.setStartupService(serviceDao.findOne(createBid.getServiceId()));
		bidRecord.setBidStatus(createBid.getBidStatus());
		
		bidRequestDao.save(bidRecord);
		
		return true;
	}

	public List<bidReturn> getAllBid(StartupService StartupService) {
		// TODO Auto-generated method stub
		return bidRequestDao.findByStartupService(StartupService).stream()
		.map(x -> {
				bidReturn temp = new bidReturn();
				temp.setBidAmount(x.getBidAmount());
				temp.setBidEnddate(x.getBidEnddate());
				temp.setBidStartdate(x.getBidStartdate());
				temp.setBidId(x.getBidId());
				temp.setBidStatus(x.getBidStatus());
				temp.setServiceId(x.getStartupService().getRequestId());
				temp.setStartupName(x.getUser().getUserUsername());
				return temp;
			}).collect(Collectors.toList());
	}
	
	public List<bidReturn> getAllBidWithUsername(User user) {
		// TODO Auto-generated method stub
		return bidRequestDao.findByUser(user).stream()
		.map(x -> {
				bidReturn temp = new bidReturn();
				temp.setBidAmount(x.getBidAmount());
				temp.setBidEnddate(x.getBidEnddate());
				temp.setBidStartdate(x.getBidStartdate());
				temp.setBidId(x.getBidId());
				temp.setBidStatus(x.getBidStatus());
				temp.setServiceId(x.getStartupService().getRequestId());
				temp.setStartupName(x.getUser().getUserUsername());
				return temp;
			}).collect(Collectors.toList());
	}

}
