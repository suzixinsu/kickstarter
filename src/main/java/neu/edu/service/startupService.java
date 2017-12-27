package neu.edu.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.startup.startupCreation;
import neu.edu.controller.user.userCreation;

import neu.edu.dao.categoryDao;
import neu.edu.dao.userDao;
import neu.edu.dao.startupDao;

import neu.edu.entity.Category;
import neu.edu.entity.Startup;
import neu.edu.entity.User;

@Service
public class startupService {
	
	@Autowired
	private userService userService;
	
	@Autowired
	private userDao userDao;
	
	@Autowired
	private categoryDao categoryDao;
	
	@Autowired
	private startupDao startupDao;
	
	@Transactional
	public boolean creatStartup(startupCreation startupCreation) {
		// TODO Auto-generated method stub
		userCreation userCreation = startupCreation.getUsercreation();
		userCreation.setRoleId(4);
		if(userService.creatUser(userCreation)==false)
			return false;
		Category category = categoryDao.findOne(startupCreation.getCategoryId());
		if(category==null)
			return false;
		
		User user = userDao.findByuserUsername(userCreation.getUserUsername());
		
		Startup startup = new Startup();
		
		startup.setStartupName(startupCreation.getStartupName());
		startup.setStartupDescription(startupCreation.getStartupDescription());
		startup.setUser(user);
		startup.setCategory(category);
		startup.setUser(user);
		
		startupDao.save(startup);
		
		return true;
	}


}
