package neu.edu.entity;
// Generated Dec 14, 2017 2:47:12 AM by Hibernate Tools 5.2.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * IdeaOption generated by hbm2java
 */
@Entity
@Table(name = "idea_option", catalog = "finalprj")
public class IdeaOption implements java.io.Serializable {

	private Integer optionId;
	private Idea idea;
	private String optionDescription;
	private float optionPrice;
	private int optionBoughtAmount;
	private Integer optionMaxAmount;
	private Set<PurchaseRecord> purchaseRecords = new HashSet<PurchaseRecord>(0);
	private Set<ShoppingCart> shoppingCarts = new HashSet<ShoppingCart>(0);

	public IdeaOption() {
	}

	public IdeaOption(float optionPrice, int optionBoughtAmount) {
		this.optionPrice = optionPrice;
		this.optionBoughtAmount = optionBoughtAmount;
	}

	public IdeaOption(Idea idea, String optionDescription, float optionPrice, int optionBoughtAmount,
			Integer optionMaxAmount, Set<PurchaseRecord> purchaseRecords, Set<ShoppingCart> shoppingCarts) {
		this.idea = idea;
		this.optionDescription = optionDescription;
		this.optionPrice = optionPrice;
		this.optionBoughtAmount = optionBoughtAmount;
		this.optionMaxAmount = optionMaxAmount;
		this.purchaseRecords = purchaseRecords;
		this.shoppingCarts = shoppingCarts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "option_id", unique = true, nullable = false)
	public Integer getOptionId() {
		return this.optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idea_id")
	public Idea getIdea() {
		return this.idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	@Column(name = "option_description", length = 4000)
	public String getOptionDescription() {
		return this.optionDescription;
	}

	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	@Column(name = "option_price", nullable = false, precision = 12, scale = 0)
	public float getOptionPrice() {
		return this.optionPrice;
	}

	public void setOptionPrice(float optionPrice) {
		this.optionPrice = optionPrice;
	}

	@Column(name = "option_bought_amount", nullable = false)
	public int getOptionBoughtAmount() {
		return this.optionBoughtAmount;
	}

	public void setOptionBoughtAmount(int optionBoughtAmount) {
		this.optionBoughtAmount = optionBoughtAmount;
	}

	@Column(name = "option_max_amount")
	public Integer getOptionMaxAmount() {
		return this.optionMaxAmount;
	}

	public void setOptionMaxAmount(Integer optionMaxAmount) {
		this.optionMaxAmount = optionMaxAmount;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ideaOption")
	public Set<PurchaseRecord> getPurchaseRecords() {
		return this.purchaseRecords;
	}

	public void setPurchaseRecords(Set<PurchaseRecord> purchaseRecords) {
		this.purchaseRecords = purchaseRecords;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ideaOption")
	public Set<ShoppingCart> getShoppingCarts() {
		return this.shoppingCarts;
	}

	public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

}
