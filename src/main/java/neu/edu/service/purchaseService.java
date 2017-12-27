package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.idea.ideaCreation;
import neu.edu.controller.purchase.purchaseReturn;
import neu.edu.dao.ideaDao;
import neu.edu.dao.ideaoptionDao;
import neu.edu.dao.purchaseRecordDao;
import neu.edu.dao.userDao;
import neu.edu.entity.Idea;
import neu.edu.entity.IdeaOption;
import neu.edu.entity.PurchaseRecord;
import neu.edu.entity.User;

@Service
public class purchaseService {

	@Autowired
	private ideaDao ideaDao;

	@Autowired
	private ideaoptionDao ideaOptionDao;

	@Autowired
	private userDao userDao;

	@Autowired
	private purchaseRecordDao purchaseRecordDao;

	@Autowired
	private userService userService;

	@Transactional
	public boolean boughtOption(Integer OptionId, Integer amount, String userName) {

		IdeaOption ideaoption = ideaOptionDao.findOne(OptionId);
		Idea idea = ideaoption.getIdea();
		User user = userDao.findOne(userService.findByuserName(userName));

		int bought = ideaoption.getOptionBoughtAmount();
		int max = ideaoption.getOptionMaxAmount();

		if (idea == null || bought + amount > max)
			return false;

		ideaoption.setOptionBoughtAmount(ideaoption.getOptionBoughtAmount() + amount);

		ideaOptionDao.save(ideaoption);

		idea.setIdeaGatheredAmount(idea.getIdeaGatheredAmount() + ideaoption.getOptionPrice() * amount);

		ideaDao.save(idea);

		PurchaseRecord pr = new PurchaseRecord();
		pr.setPurchaseRecordAmount(amount);
		pr.setPurchaseRecordDate(new Date());
		pr.setIdeaOption(ideaoption);
		pr.setPurchaseRecordStatus("Waiting for complete");
		pr.setUser(user);
		purchaseRecordDao.save(pr);
		return true;
	}
	
	@Transactional
	public List<purchaseReturn> findByuserName(User user) {
		// TODO Auto-generated method stub

		return purchaseRecordDao.findByuser(user).stream()
			   .map(x -> {
				   purchaseReturn temp = new purchaseReturn();
				   temp.setIdeaOptionId(x.getIdeaOption().getOptionId());
				   temp.setIdeaOptionName(x.getIdeaOption().getOptionDescription());
				   temp.setIdeaName(x.getIdeaOption().getIdea().getIdeaName());
				   temp.setPurchaseRecordAmount(x.getPurchaseRecordAmount());
				   temp.setPurchaseRecordDate(x.getPurchaseRecordDate());
				   temp.setPurchaseRecordId(x.getPurchaseRecordId());
				   temp.setPurchaseRecordStatus(x.getPurchaseRecordStatus());
			return temp;
		}).collect(Collectors.toList());
	}
}
