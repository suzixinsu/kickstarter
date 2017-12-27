package neu.edu.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.service.userService;

@RestController
@RequestMapping("/user")
public class userController {
	@Autowired
	private userService userService;
	
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@Valid @RequestBody userCreation userCreation) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("User Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		if(userService.creatUser(userCreation) == true)
			responseEntity = new ResponseEntity<>("User Creation successed",
					HttpStatus.OK);
		
		return responseEntity;
	}
	
	
}
