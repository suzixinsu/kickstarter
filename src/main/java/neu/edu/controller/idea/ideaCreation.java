package neu.edu.controller.idea;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ideaCreation {
	
	private int ideaId;
	private String category;
	private int user;
	private String ideaName;
	private float ideaTargeramount;
	private float ideaGatheredAmount;
	private String status;
	private String ideaDesc;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ideaStartdate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ideaEnddate;
	
	
	public ideaCreation() {
		
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getIdeaName() {
		return ideaName;
	}

	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}

	public float getIdeaTargeramount() {
		return ideaTargeramount;
	}

	public void setIdeaTargeramount(float ideaTargeramount) {
		this.ideaTargeramount = ideaTargeramount;
	}

	public float getIdeaGatheredAmount() {
		return ideaGatheredAmount;
	}

	public void setIdeaGatheredAmount(float ideaGatheredAmount) {
		this.ideaGatheredAmount = ideaGatheredAmount;
	}

	public Date getIdeaStartdate() {
		return ideaStartdate;
	}

	public void setIdeaStartdate(Date ideaStartdate) {
		this.ideaStartdate = ideaStartdate;
	}

	public Date getIdeaEnddate() {
		return ideaEnddate;
	}

	public void setIdeaEnddate(Date ideaEnddate) {
		this.ideaEnddate = ideaEnddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdeaDesc() {
		return ideaDesc;
	}

	public void setIdeaDesc(String ideaDesc) {
		this.ideaDesc = ideaDesc;
	}

	public int getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}
	
	
}
