package com.appsv.financesaccount.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "movement")
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_movement")
	private Integer pkMovement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_category", nullable = false)
	private Category category;
	
	@Column(name="ammount")
	private BigDecimal ammount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type_movement_type")
	private MovementType typeMovementType;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "active_movement")
	private Boolean activeMovement;
	
	@Column(name = "movement_date", updatable = false)
    private LocalDateTime movementDate;

    @PrePersist
    protected void onCreate() {
        this.movementDate = LocalDateTime.now();
    }
    
    public Movement() {
		// TODO Auto-generated constructor stub
	}

	public Movement(Integer pkMovement) {
		super();
		this.pkMovement = pkMovement;
	}

	public Integer getPkMovement() {
		return pkMovement;
	}

	public void setPkMovement(Integer pkMovement) {
		this.pkMovement = pkMovement;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal getAmmount() {
		return ammount;
	}

	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}

	public MovementType getTypeMovementType() {
		return typeMovementType;
	}

	public void setTypeMovementType(MovementType typeMovementType) {
		this.typeMovementType = typeMovementType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getMovementDate() {
		return movementDate;
	}

	public Boolean getActiveMovement() {
		return activeMovement;
	}

	public void setActiveMovement(Boolean activeMovement) {
		this.activeMovement = activeMovement;
	}
    
	
}
