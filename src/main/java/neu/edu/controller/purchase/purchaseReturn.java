package neu.edu.controller.purchase;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class purchaseReturn {
	
	private String ideaName;
	private Integer purchaseRecordId;
	private Integer ideaOptionId;
	private String ideaOptionName;
	private float purchaseRecordAmount;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date purchaseRecordDate;
	public Integer getPurchaseRecordId() {
		return purchaseRecordId;
	}
	public void setPurchaseRecordId(Integer purchaseRecordId) {
		this.purchaseRecordId = purchaseRecordId;
	}
	public Integer getIdeaOptionId() {
		return ideaOptionId;
	}
	public void setIdeaOptionId(Integer ideaOptionId) {
		this.ideaOptionId = ideaOptionId;
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
	public String getIdeaName() {
		return ideaName;
	}
	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}
	public String getIdeaOptionName() {
		return ideaOptionName;
	}
	public void setIdeaOptionName(String ideaOptionName) {
		this.ideaOptionName = ideaOptionName;
	}
	private String purchaseRecordStatus;
}
