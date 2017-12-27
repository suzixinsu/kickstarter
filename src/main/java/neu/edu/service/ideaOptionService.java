package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.dao.ideaDao;
import neu.edu.dao.ideaoptionDao;
import neu.edu.dao.purchaseRecordDao;
import neu.edu.dao.userDao;
import neu.edu.entity.Idea;
import neu.edu.entity.IdeaOption;
import neu.edu.entity.PurchaseRecord;
import neu.edu.entity.User;
import neu.edu.controller.ideaOption.*;

@Service
public class ideaOptionService {
	
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
	public boolean createIdeaOption(ideaoptionCreation ideaCreation) {
		
		Idea idea = ideaDao.findOne(ideaCreation.getIdeaId());
		
		IdeaOption ideaOption = new IdeaOption();
		if(idea==null)
			return false;
		ideaOption.setIdea(idea);
		ideaOption.setOptionDescription(ideaCreation.getOptionDescription());
		ideaOption.setOptionBoughtAmount(ideaCreation.getOptionBoughtAmount());
		ideaOption.setOptionMaxAmount(ideaCreation.getOptionMaxAmount());
		ideaOption.setOptionPrice(ideaCreation.getOptionPrice());
		
		ideaOptionDao.save(ideaOption);
		
		ideaDao.save(idea);
		
		return true;
		
	}
	
	@Transactional
	public boolean updateIdeaOption(ideaoptionWhole ideaCreation) {
		
		IdeaOption ideaOption = ideaOptionDao.findOne(ideaCreation.getOptionId());
		
		
		if(ideaOption==null)
			return false;
		
		ideaOption.setOptionDescription(ideaCreation.getOptionDescription());
		ideaOption.setOptionBoughtAmount(ideaCreation.getOptionBoughtAmount());
		ideaOption.setOptionMaxAmount(ideaCreation.getOptionMaxAmount());
		ideaOption.setOptionPrice(ideaCreation.getOptionPrice());
		
		ideaOptionDao.save(ideaOption);
		
		return true;
	}
	
	@Transactional
	public List<ideaoptionWhole> findOption(Integer ideaId) {
		// TODO Auto-generated method stub
		
		Idea idea = ideaDao.findOne(ideaId);
		
		return ideaOptionDao.findByIdea(idea).stream()
			   .map(x -> {
				   ideaoptionWhole temp = new ideaoptionWhole();
			temp.setOptionId(x.getOptionId());
			temp.setOptionDescription(x.getOptionDescription());
			temp.setOptionBoughtAmount(x.getOptionBoughtAmount());
			temp.setOptionMaxAmount(x.getOptionMaxAmount());
			temp.setOptionPrice(x.getOptionPrice());
			return temp;
		}).collect(Collectors.toList());
	}
	
	
	
	
	@Transactional
	public boolean deleteOption(Integer optionId) {
		// TODO Auto-generated method stub
		IdeaOption toBeDeleted = ideaOptionDao.findOne(optionId);
		if (toBeDeleted.getOptionBoughtAmount()> 0) {
			return false;
		} else {
			ideaOptionDao.delete(toBeDeleted);
		}
		return true;
	}
}
