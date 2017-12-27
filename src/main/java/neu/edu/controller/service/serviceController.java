package neu.edu.controller.service;

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

import neu.edu.service.serviceService;

@RestController
@RequestMapping("/service")

public class serviceController {
	@Autowired
	private serviceService serviceService;
	
	@RequestMapping(path="/create", method = RequestMethod.POST)
	public ResponseEntity<?> createService(@Valid @RequestBody serviceCreation serviceCreation){
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		if(serviceService.createService(serviceCreation)==true) {
			responseEntity = new ResponseEntity<>("Service Creation successed",
					HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(path = "/getAll/{ideaid}", method = RequestMethod.GET)
	public List<serviceReturn> getIdeaOption(@PathVariable("ideaid") int ideaid){
		
		List<serviceReturn> result =  serviceService.findbid(ideaid);
		return result;
	}
	
	@RequestMapping(path = "/getByServiceId/{serviceId}", method = RequestMethod.GET)
	public serviceReturn getByServiceId(@PathVariable("serviceId") int serviceId){
		
		serviceReturn result =  serviceService.findByServiceId(serviceId);
		return result;
	}
}
