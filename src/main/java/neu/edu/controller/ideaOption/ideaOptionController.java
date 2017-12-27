package neu.edu.controller.ideaOption;

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

import neu.edu.controller.idea.ideaCreation;
import neu.edu.service.ideaOptionService;
import neu.edu.service.purchaseService;

@RestController
@RequestMapping("/ideaOption")
public class ideaOptionController {
	
	@Autowired
	private ideaOptionService ideaOptionService;
	
	@Autowired
	private purchaseService purchaseService;
	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public ResponseEntity<?> CreatIdea(@Valid @RequestBody ideaoptionCreation ideaCreation){
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Idea Option Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		if(ideaOptionService.createIdeaOption(ideaCreation) == true)
			responseEntity = new ResponseEntity<>("Idea Option Creation successed",
					HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(path = "/getAll/{ideaOptionId}", method = RequestMethod.GET)
	public List<ideaoptionWhole> getIdeaOption(@PathVariable("ideaOptionId") Integer ideaOptionId){
		
		return ideaOptionService.findOption(ideaOptionId);
	}
	
	@RequestMapping(path = "/{ideaOptionId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@PathVariable("ideaOptionId") Integer ideaOptionId) {
		ResponseEntity<?> response = new ResponseEntity<>("{ msg:'Option Not Deleted'}", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = ideaOptionService.deleteOption(ideaOptionId);
		if (deleteStatus) { 
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = "/{ideaOptionId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateIdea(@PathVariable("ideaOptionId") Integer ideaOptionId,
			@Valid @RequestBody ideaoptionWhole ideaoptionWhole) {
		ResponseEntity<?> response = new ResponseEntity<>("Option Not Updated", HttpStatus.UNPROCESSABLE_ENTITY);
		
		boolean deleteStatus = ideaOptionService.updateIdeaOption(ideaoptionWhole);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = "/bought/{ideaOptionId}/amount/{amount}/userid/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> buyOption(@PathVariable("ideaOptionId") Integer ideaOptionId,
			@PathVariable("amount") Integer amount,
			@PathVariable("username") String username) {
		ResponseEntity<?> response = new ResponseEntity<>("Option Not bought", HttpStatus.UNPROCESSABLE_ENTITY);
		
		boolean deleteStatus = purchaseService.boughtOption(ideaOptionId, amount, username);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}

}
