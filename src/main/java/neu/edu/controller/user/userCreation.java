package neu.edu.controller.user;

public class userCreation {

	private Integer roleId;
	private String userUsername;
	private String userPassword;
	private float userBalance;
	private String userStatus;
	
	public userCreation() {
		
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public float getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(float userBalance) {
		this.userBalance = userBalance;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
}
