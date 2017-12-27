package neu.edu.controller.bid;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.dao.serviceDao;
import neu.edu.dao.userDao;
import neu.edu.entity.StartupService;
import neu.edu.entity.User;
import neu.edu.service.bidService;
@RestController
@RequestMapping("/bid")
public class bidController {
	
	@Autowired
	private bidService bidService;
	
	@Autowired
	private serviceDao serviceDao;
	
	@Autowired
	private userDao userDao;
	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public ResponseEntity<?> createBid(@Valid @RequestBody createBid createBid){
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Bid Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		if(bidService.createBid(createBid) == true) {
			responseEntity = new ResponseEntity<>("Bid Creation successed",
					HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path="/getByIdeaId/{serviceId}", method = RequestMethod.GET)
	public List<bidReturn> getBidByIdeaid(@PathVariable("serviceId") Integer serviceId){
		StartupService startupservice = serviceDao.findOne(serviceId);
		return bidService.getAllBid(startupservice);
	}
	
	@RequestMapping(path="/getByStartupId/{startupName}", method = RequestMethod.GET)
	public List<bidReturn> getByStartupId(@PathVariable("startupName") String startupName){
		User user = userDao.findByuserUsername(startupName);
		return bidService.getAllBidWithUsername(user);
	}
}
