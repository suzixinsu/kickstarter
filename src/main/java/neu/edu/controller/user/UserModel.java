package neu.edu.controller.user;

import neu.edu.controller.role.RoleModel;

public class UserModel {
	
	private Integer userId;
	private RoleModel role;
	private String username;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
