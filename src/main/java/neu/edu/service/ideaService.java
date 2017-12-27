package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.idea.ideaCreation;
import neu.edu.dao.ideaDao;
import neu.edu.dao.userDao;
import neu.edu.entity.Category;
import neu.edu.entity.Idea;
import neu.edu.entity.User;
import neu.edu.dao.categoryDao;

@Service
public class ideaService {
	
	@Autowired
	private ideaDao ideaDao;
	
	@Autowired
	private userDao userDao;
	
	@Autowired
	private categoryDao categoryDao;
	
	@Autowired
	private userService userService;
	
	@Transactional
	public boolean createIdea(ideaCreation ideaCreation, String Username) {
		
		User user = userService.findUserByUserName(Username);
		
		Category category = categoryDao.findBycategoryName(ideaCreation.getCategory());
		
		Idea idea = new Idea();
		if(category==null || idea==null)
			return false;
		idea.setCategory(category);
		idea.setIdeaDescription(ideaCreation.getIdeaDesc());
		idea.setIdeaEnddate(ideaCreation.getIdeaEnddate());
		idea.setIdeaGatheredAmount(ideaCreation.getIdeaGatheredAmount());
		idea.setIdeaTargeramount(ideaCreation.getIdeaTargeramount());
		idea.setIdeaName(ideaCreation.getIdeaName());
		idea.setIdeaStartdate(ideaCreation.getIdeaStartdate());
		idea.setIdeaStatus("active");
		idea.setUser(user);
		
		ideaDao.save(idea);
		
		return true;
		
	}
	
	@Transactional
	public List<ideaCreation> findAll() {
		// TODO Auto-generated method stub

		return ideaDao.findAll().stream()
			   .map(x -> {
			ideaCreation temp = new ideaCreation();
			temp.setIdeaName(x.getIdeaName());
			temp.setStatus(x.getIdeaStatus());
			temp.setIdeaEnddate(x.getIdeaEnddate());
			temp.setIdeaStartdate(x.getIdeaStartdate());
			temp.setCategory(x.getCategory().getCategoryName());
			temp.setIdeaTargeramount(x.getIdeaTargeramount());
			temp.setIdeaGatheredAmount(x.getIdeaGatheredAmount());
			temp.setIdeaDesc(x.getIdeaDescription());
			temp.setIdeaId(x.getIdeaId());
			System.out.println(temp.getIdeaStartdate());
			return temp;
		}).collect(Collectors.toList());
	}

	@Transactional
	public boolean updateIdea(Integer ideaId, ideaCreation ideaCreation) {
		// TODO Auto-generated method stub
		
		Idea idea = ideaDao.findOne(ideaId);
		idea.setIdeaName(ideaCreation.getIdeaName());
		idea.setCategory(categoryDao.findBycategoryName(ideaCreation.getCategory()));
		idea.setIdeaDescription(ideaCreation.getIdeaDesc());
		idea.setIdeaStartdate(ideaCreation.getIdeaStartdate());
		idea.setIdeaEnddate(ideaCreation.getIdeaEnddate());
		idea.setIdeaTargeramount(ideaCreation.getIdeaTargeramount());
		idea.setIdeaGatheredAmount(ideaCreation.getIdeaGatheredAmount());
		idea.setUser(userDao.findOne(ideaCreation.getUser()));
		idea.setIdeaStatus(ideaCreation.getStatus());
		
		ideaDao.save(idea);
		
		return true;
	}

	@Transactional
	public boolean deleteRole(Integer ideaId) {
		// TODO Auto-generated method stub
		Idea toBeDeleted = ideaDao.findOne(ideaId);
		if (toBeDeleted.getIdeaOptions().size() > 0) {
			return false;
		} else {
			ideaDao.delete(toBeDeleted);
		}
		return true;
	}

	public List<ideaCreation> findByUsername(User user) {
		// TODO Auto-generated method stub
		return ideaDao.findByUser(user).stream()
				   .map(x -> {
				ideaCreation temp = new ideaCreation();
				temp.setIdeaName(x.getIdeaName());
				temp.setStatus(x.getIdeaStatus());
				temp.setIdeaEnddate(x.getIdeaEnddate());
				temp.setIdeaStartdate(x.getIdeaStartdate());
				temp.setCategory(x.getCategory().getCategoryName());
				temp.setIdeaTargeramount(x.getIdeaTargeramount());
				temp.setIdeaGatheredAmount(x.getIdeaGatheredAmount());
				temp.setIdeaDesc(x.getIdeaDescription());
				temp.setIdeaId(x.getIdeaId());
				System.out.println(temp.getIdeaStartdate());
				return temp;
			}).collect(Collectors.toList());
	}
	
	public List<ideaCreation> findByUserCategory(Category category) {
		// TODO Auto-generated method stub
		return ideaDao.findByCategory(category).stream()
				   .map(x -> {
				ideaCreation temp = new ideaCreation();
				temp.setIdeaName(x.getIdeaName());
				temp.setStatus(x.getIdeaStatus());
				temp.setIdeaEnddate(x.getIdeaEnddate());
				temp.setIdeaStartdate(x.getIdeaStartdate());
				temp.setCategory(x.getCategory().getCategoryName());
				temp.setIdeaTargeramount(x.getIdeaTargeramount());
				temp.setIdeaGatheredAmount(x.getIdeaGatheredAmount());
				temp.setIdeaDesc(x.getIdeaDescription());
				temp.setIdeaId(x.getIdeaId());
				System.out.println(temp.getIdeaStartdate());
				return temp;
			}).collect(Collectors.toList());
	}
	
	public List<ideaCreation> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return ideaDao.findByCategory(category).stream()
				   .map(x -> {
				ideaCreation temp = new ideaCreation();
				temp.setIdeaName(x.getIdeaName());
				temp.setStatus(x.getIdeaStatus());
				temp.setIdeaEnddate(x.getIdeaEnddate());
				temp.setIdeaStartdate(x.getIdeaStartdate());
				temp.setCategory(x.getCategory().getCategoryName());
				temp.setIdeaTargeramount(x.getIdeaTargeramount());
				temp.setIdeaGatheredAmount(x.getIdeaGatheredAmount());
				temp.setIdeaDesc(x.getIdeaDescription());
				temp.setIdeaId(x.getIdeaId());
				System.out.println(temp.getIdeaStartdate());
				return temp;
			}).collect(Collectors.toList());
	}
}
