package neu.edu.controller.startup;

import neu.edu.controller.user.userCreation;
import neu.edu.entity.User;

public class startupCreation {
	private userCreation usercreation;
	private int categoryId;
	private String startupName;
	private String startupDescription;
	
	public userCreation getUsercreation() {
		return usercreation;
	}
	public void setUsercreation(userCreation usercreation) {
		this.usercreation = usercreation;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getStartupName() {
		return startupName;
	}
	public void setStartupName(String startupName) {
		this.startupName = startupName;
	}
	public String getStartupDescription() {
		return startupDescription;
	}
	public void setStartupDescription(String startupDescription) {
		this.startupDescription = startupDescription;
	}
	
	
}
