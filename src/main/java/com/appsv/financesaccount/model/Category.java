package com.appsv.financesaccount.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name =  "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_category")
	private Integer pkCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="fk_bank")
	private Bank bank;
	
	@Column(name = "name_category")
	private String nameCategory;
	
	@Column(name = "actual_balance")
	private BigDecimal actualBalance;
	
	@Column(name="activeCategory")
	private Boolean activeCategory;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@PrePersist
	protected void onCreate() {
		this.createdDate = LocalDateTime.now();
	}
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(Integer pkCategory) {
		super();
		this.pkCategory = pkCategory;
	}

	public Integer getPkCategory() {
		return pkCategory;
	}

	public void setPkCategory(Integer pkCategory) {
		this.pkCategory = pkCategory;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public BigDecimal getActualBalance() {
		return actualBalance;
	}

	public void setActualBalance(BigDecimal actualBalance) {
		this.actualBalance = actualBalance;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public Boolean getActiveCategory() {
		return activeCategory;
	}

	public void setActiveCategory(Boolean activeCategory) {
		this.activeCategory = activeCategory;
	}
	
	
}
