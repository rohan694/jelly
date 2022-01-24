package com.sks.hawkeye.model.gameSnap;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "players")
@Getter @Setter
public class PlayerEntity {
	@Id
	private BigInteger playerId;
	
	@ManyToOne
    @JoinColumn(name="teamId", nullable=true)
	@NotFound(action = NotFoundAction.IGNORE)
	private TeamEntity team;
	
	private boolean rightHanded;
	private String name;
    private int spell;
    
    public PlayerEntity() {	}
	public PlayerEntity(TeamEntity team) {
		this.team = team;
	}
	
}
