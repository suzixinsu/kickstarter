package neu.edu.controller.idea;

import java.util.Date;

public class ideaModel {
	
	public int ideaId;
	public String ideaName;
    public Date ideaStartdate;
    public Date ideaEngdate;
    public String category;
    public String status;
    private float ideaTargeramount;
	private float ideaGatheredAmount;
    public String ideaDesc;

	
    public int getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
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

	public ideaModel(int ideaId)
    {
    	this.ideaId = ideaId;
    }
    
	public String getIdeaName() {
		return ideaName;
	}
	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}
	public Date getIdeaStartdate() {
		return ideaStartdate;
	}
	public void setIdeaStartdate(Date ideaStartdate) {
		this.ideaStartdate = ideaStartdate;
	}
	public Date getIdeaEngdate() {
		return ideaEngdate;
	}
	public void setIdeaEngdate(Date ideaEngdate) {
		this.ideaEngdate = ideaEngdate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
    
    
}
