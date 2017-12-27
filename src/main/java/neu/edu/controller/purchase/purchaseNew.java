package neu.edu.controller.purchase;

import java.util.Date;

import neu.edu.entity.IdeaOption;
import neu.edu.entity.User;

public class purchaseNew {
	private IdeaOption ideaOption;
	private User user;
	private float purchaseRecordAmount;
	private Date purchaseRecordDate;
	private String purchaseRecordStatus;
	public purchaseNew(){

		Date date = new Date();
		this.purchaseRecordDate = date;
	}
	public IdeaOption getIdeaOption() {
		return ideaOption;
	}
	public void setIdeaOption(IdeaOption ideaOption) {
		this.ideaOption = ideaOption;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getPurchaseRecordAmount() {
		return purchaseRecordAmount;
	}
	public void setPurchaseRecordAmount(float purchaseRecordAmount) {
		this.purchaseRecordAmount = purchaseRecordAmount;
	}
	public Date getPurchaseRecordDate() {
		return purchaseRecordDate;
	}
	public void setPurchaseRecordDate(Date purchaseRecordDate) {
		this.purchaseRecordDate = purchaseRecordDate;
	}
	public String getPurchaseRecordStatus() {
		return purchaseRecordStatus;
	}
	public void setPurchaseRecordStatus(String purchaseRecordStatus) {
		this.purchaseRecordStatus = purchaseRecordStatus;
	}
	
	
}
