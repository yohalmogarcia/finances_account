package com.appsv.financesaccount.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name="pk_bank")
	private Integer pkBank;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_users")
    private Users user;
	
	@Column(name = "name_bank")
	private String nameBank;
	
	@Column(name ="year_interest")
	private BigDecimal yearInterest;
	
	@Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;
	
	@Column(name="active_bank")
	private Boolean activeBank;
	
	@OneToMany(mappedBy = "bank",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
	private List<Category> categoryList = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
    
    public Bank() {
		
	}

	public Bank(Integer pkBank) {
		super();
		this.pkBank = pkBank;
	}

	public Integer getPkBank() {
		return pkBank;
	}

	public void setPkBank(Integer pkBank) {
		this.pkBank = pkBank;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getNameBank() {
		return nameBank;
	}

	public void setNameBank(String nameBank) {
		this.nameBank = nameBank;
	}

	public BigDecimal getYearInterest() {
		return yearInterest;
	}

	public void setYearInterest(BigDecimal yearInterest) {
		this.yearInterest = yearInterest;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public Boolean getActiveBank() {
		return activeBank;
	}

	public void setActiveBank(Boolean activeBank) {
		this.activeBank = activeBank;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	
}
