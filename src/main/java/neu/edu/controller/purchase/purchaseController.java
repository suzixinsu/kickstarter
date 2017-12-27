package neu.edu.controller.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.controller.ideaOption.ideaoptionWhole;
import neu.edu.entity.User;
import neu.edu.service.purchaseService;
import neu.edu.service.userService;

@RestController
@RequestMapping("/purchase")
public class purchaseController {
	@Autowired
	private purchaseService purchaseService;
	
	@Autowired
	private userService userService;
	
	@RequestMapping(path = "/getByUser/{userName}", method = RequestMethod.GET)
	public List<purchaseReturn> getIdeaOption(@PathVariable("userName") String userName){
		User user = userService.findUserByUserName(userName);
		return purchaseService.findByuserName(user);
	}
}
