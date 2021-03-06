package neu.edu.entity;
// Generated Dec 14, 2017 2:47:12 AM by Hibernate Tools 5.2.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BidRecord generated by hbm2java
 */
@Entity
@Table(name = "bid_record", catalog = "finalprj")
public class BidRecord implements java.io.Serializable {

	private Integer bidId;
	private StartupService startupService;
	private User user;
	private String bidStatus;
	private Date bidStartdate;
	private Date bidEnddate;
	private float bidAmount;
	private String bidRecordStatus;

	public BidRecord() {
	}

	public BidRecord(String bidStatus, Date bidStartdate, Date bidEnddate, float bidAmount, String bidRecordStatus) {
		this.bidStatus = bidStatus;
		this.bidStartdate = bidStartdate;
		this.bidEnddate = bidEnddate;
		this.bidAmount = bidAmount;
		this.bidRecordStatus = bidRecordStatus;
	}

	public BidRecord(StartupService startupService, User user, String bidStatus, Date bidStartdate, Date bidEnddate,
			float bidAmount, String bidRecordStatus) {
		this.startupService = startupService;
		this.user = user;
		this.bidStatus = bidStatus;
		this.bidStartdate = bidStartdate;
		this.bidEnddate = bidEnddate;
		this.bidAmount = bidAmount;
		this.bidRecordStatus = bidRecordStatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "bid_id", unique = true, nullable = false)
	public Integer getBidId() {
		return this.bidId;
	}

	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "request_id")
	public StartupService getStartupService() {
		return this.startupService;
	}

	public void setStartupService(StartupService startupService) {
		this.startupService = startupService;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "startup_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "bid_status", nullable = false, length = 20)
	public String getBidStatus() {
		return this.bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bid_startdate", nullable = false, length = 19)
	public Date getBidStartdate() {
		return this.bidStartdate;
	}

	public void setBidStartdate(Date bidStartdate) {
		this.bidStartdate = bidStartdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bid_enddate", nullable = false, length = 19)
	public Date getBidEnddate() {
		return this.bidEnddate;
	}

	public void setBidEnddate(Date bidEnddate) {
		this.bidEnddate = bidEnddate;
	}

	@Column(name = "bid_amount", nullable = false, precision = 12, scale = 0)
	public float getBidAmount() {
		return this.bidAmount;
	}

	public void setBidAmount(float bidAmount) {
		this.bidAmount = bidAmount;
	}

	@Column(name = "bid_record_status", nullable = false, length = 20)
	public String getBidRecordStatus() {
		return this.bidRecordStatus;
	}

	public void setBidRecordStatus(String bidRecordStatus) {
		this.bidRecordStatus = bidRecordStatus;
	}

}
