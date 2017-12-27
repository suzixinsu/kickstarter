package neu.edu.controller.category;

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

import neu.edu.service.categoryService;

@RestController
@RequestMapping("/category")
public class categoryController {
	
	@Autowired
	categoryService categoryService;
	
	@RequestMapping(path="/register", method = RequestMethod.POST)

	public ResponseEntity<?> showCategory(@Valid @RequestBody categoryCreation categoryCreation){
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Category Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		
		if(categoryService.createCategry(categoryCreation) == true) {
			responseEntity = new ResponseEntity<>("Category Creation successed",
					HttpStatus.OK);
		}
		return responseEntity;
	}
	
		
	@RequestMapping(path = "/{categoryId}", method = RequestMethod.DELETE)

	public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
		ResponseEntity<?> response = new ResponseEntity<>("{ msg:'Category Not Deleted'}", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = categoryService.deleteCategory(categoryId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<categoryModel> findAll() {
		return categoryService.findAll();
	}
		
	@RequestMapping(path = "/{categoryId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCategory(@PathVariable("categoryId") Integer categoryId,
			@Valid @RequestBody categoryCreation categoryCreation) {
		ResponseEntity<?> response = new ResponseEntity<>("Category Not Updated", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = categoryService.updateCategory(categoryId, categoryCreation);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
}
