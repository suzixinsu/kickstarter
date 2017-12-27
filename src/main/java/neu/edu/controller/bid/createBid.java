package neu.edu.controller.bid;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class createBid {

	private String startupName;
	private Integer serviceId;;
	private String bidStatus;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date bidStartdate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date bidEnddate;
	private float bidAmount;
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	public Date getBidStartdate() {
		return bidStartdate;
	}
	public void setBidStartdate(Date bidStartdate) {
		this.bidStartdate = bidStartdate;
	}
	public Date getBidEnddate() {
		return bidEnddate;
	}
	public void setBidEnddate(Date bidEnddate) {
		this.bidEnddate = bidEnddate;
	}
	public float getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(float bidAmount) {
		this.bidAmount = bidAmount;
	}
	public String getStartupName() {
		return startupName;
	}
	public void setStartupName(String startupName) {
		this.startupName = startupName;
	}

}
