package neu.edu.controller.idea;

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

import neu.edu.entity.Category;
import neu.edu.entity.User;
import neu.edu.service.ideaService;
import neu.edu.service.userService;

import neu.edu.dao.categoryDao;

@RestController
@RequestMapping("/idea")
public class ideaController {
	
	@Autowired
	private ideaService ideaService;
	
	@Autowired
	private userService userService;
	
	@Autowired
	private categoryDao categoryDao;
	
	@RequestMapping(path="/register/{username}", method = RequestMethod.POST)
	public ResponseEntity<?> CreatIdea(@PathVariable("username") String username,
			@Valid @RequestBody ideaCreation ideaCreation){
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Idea Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		if(ideaService.createIdea(ideaCreation, username) == true)
			responseEntity = new ResponseEntity<>("Idea Creation successed",
					HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ideaCreation> getIdea(){
		
		return ideaService.findAll();
	}
	
	@RequestMapping(path = "/{ideaId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateIdea(@PathVariable("ideaId") Integer ideaId,
			@Valid @RequestBody ideaCreation ideaCreation) {
		ResponseEntity<?> response = new ResponseEntity<>("Role Not Updated", HttpStatus.UNPROCESSABLE_ENTITY);
		
		boolean deleteStatus = ideaService.updateIdea(ideaId, ideaCreation);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = "/{ideaId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteIdea(@PathVariable("ideaId") Integer ideaId) {
		ResponseEntity<?> response = new ResponseEntity<>("{ msg:'Role Not Deleted'}", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = ideaService.deleteRole(ideaId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = "/byUser/{username}",method = RequestMethod.GET)
	public List<ideaCreation> getIdeaByUser(@PathVariable("username") String username){
		User user = userService.findUserByUserName(username);
		return ideaService.findByUsername(user);
	}
	
	@RequestMapping(path = "/byCategory/{category}",method = RequestMethod.GET)
	public List<ideaCreation> getIdeaByCategory(@PathVariable("category") String categoryName){
		Category category = categoryDao.findBycategoryName(categoryName);
		return ideaService.findByCategory(category);
	}
}
