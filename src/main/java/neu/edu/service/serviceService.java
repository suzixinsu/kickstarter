package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.idea.ideaCreation;
import neu.edu.controller.ideaOption.ideaoptionWhole;
import neu.edu.controller.service.serviceCreation;
import neu.edu.controller.service.serviceReturn;
import neu.edu.dao.ideaDao;
import neu.edu.dao.serviceDao;
import neu.edu.entity.Idea;
import neu.edu.entity.StartupService;

@Service
public class serviceService {
	
	@Autowired
	private serviceDao serviceDao;
	
	@Autowired
	private ideaDao ideaDao;
	
	@Transactional
	public boolean createService(serviceCreation serviceCreation) {
		
		Idea idea = ideaDao.findOne(serviceCreation.getIdeaId());
		
		if(idea != null) {
		StartupService startupService = new StartupService();
		startupService.setIdea(idea);
		startupService.setRequestBaseamount(serviceCreation.getRequestBaseamount());
		startupService.setRequestDescription(serviceCreation.getRequestDescription());
		startupService.setRequestEnddate(serviceCreation.getRequestEnddate());
		startupService.setRequestStartdate(serviceCreation.getRequestStartdate());
		startupService.setRequestStatus("Active");
		
		serviceDao.save(startupService);
		return true;
		}
		return false;
	}

	public List<serviceReturn> findbid(Integer id) {
		// TODO Auto-generated method stub
		Idea idea = ideaDao.findOne(id);
		
		return serviceDao.findByIdea(idea).stream()
	   .map(x -> {
		   serviceReturn temp = new serviceReturn();
			temp.setIdeaId(x.getIdea().getIdeaId());
			temp.setRequestBaseamount(x.getRequestBaseamount());
			temp.setRequestStartdate(x.getRequestStartdate());
			temp.setRequestEnddate(x.getRequestEnddate());
			temp.setRequestDescription(x.getRequestDescription());
			temp.setRequestStatus(x.getRequestStatus());
			temp.setStatusReason(x.getStatusReason());
			temp.setRequestId(x.getRequestId());
			return temp;
		}).collect(Collectors.toList());
	}
	
	public serviceReturn findByServiceId(Integer id) {
		// TODO Auto-generated method stub
		
		StartupService x =serviceDao.findOne(id);
	   
		   serviceReturn temp = new serviceReturn();
			temp.setIdeaId(x.getIdea().getIdeaId());
			temp.setRequestBaseamount(x.getRequestBaseamount());
			temp.setRequestStartdate(x.getRequestStartdate());
			temp.setRequestEnddate(x.getRequestEnddate());
			temp.setRequestDescription(x.getRequestDescription());
			temp.setRequestStatus(x.getRequestStatus());
			temp.setStatusReason(x.getStatusReason());
			temp.setRequestId(x.getRequestId());
			return temp;
		
	}
	
}
