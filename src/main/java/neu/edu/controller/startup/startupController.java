package neu.edu.controller.startup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.service.startupService;

@RestController
@RequestMapping("/startup")
public class startupController {
	@Autowired
	private startupService startupService;
	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public ResponseEntity<?> CreatStartup(@Valid @RequestBody startupCreation startupCreation){
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Startup Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		if(startupService.creatStartup(startupCreation) == true)
			responseEntity = new ResponseEntity<>("Startup Creation successed",
					HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
}
