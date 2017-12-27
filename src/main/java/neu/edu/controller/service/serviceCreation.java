package neu.edu.controller.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class serviceCreation {
	private int ideaId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date requestStartdate;
	private float requestBaseamount;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date requestEnddate;
	private String requestDescription;
	private String requestStatus;
	public int getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}
	public Date getRequestStartdate() {
		return requestStartdate;
	}
	public void setRequestStartdate(Date requestStartdate) {
		this.requestStartdate = requestStartdate;
	}
	public float getRequestBaseamount() {
		return requestBaseamount;
	}
	public void setRequestBaseamount(float requestBaseamount) {
		this.requestBaseamount = requestBaseamount;
	}
	public Date getRequestEnddate() {
		return requestEnddate;
	}
	public void setRequestEnddate(Date requestEnddate) {
		this.requestEnddate = requestEnddate;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	
	
}
