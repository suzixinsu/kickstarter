package neu.edu.controller.ideaOption;

public class ideaoptionCreation {
	public String optionDescription;
	public float optionPrice;
	public int optionBoughtAmount;
	public Integer optionMaxAmount;
	public Integer ideaId;
	
	public Integer getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

	public ideaoptionCreation() {
		
	}

	public String getOptionDescription() {
		return optionDescription;
	}

	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	public float getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(float optionPrice) {
		this.optionPrice = optionPrice;
	}

	public int getOptionBoughtAmount() {
		return optionBoughtAmount;
	}

	public void setOptionBoughtAmount(int optionBoughtAmount) {
		this.optionBoughtAmount = optionBoughtAmount;
	}

	public Integer getOptionMaxAmount() {
		return optionMaxAmount;
	}

	public void setOptionMaxAmount(Integer optionMaxAmount) {
		this.optionMaxAmount = optionMaxAmount;
	}


	
}
