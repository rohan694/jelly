package com.sks.hawkeye.model.gameSnap;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teams",uniqueConstraints = @UniqueConstraint(columnNames= {"teamName"}))
@Getter @Setter
public class TeamEntity {

	@Id
	private String teamName;
	
	private BigInteger id;
    public boolean home;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    public Set<PlayerEntity> players=new HashSet<PlayerEntity>();

    @ManyToMany(mappedBy = "participatingTeams",fetch = FetchType.LAZY)
	private Set<MatchEntity> match=new HashSet<MatchEntity>();

	public TeamEntity(MatchEntity me) {
		this.match.add(me);
	}

	public TeamEntity() {
		super();
	}

	public void addMatch(MatchEntity matchEntity) {
		this.match.add(matchEntity);
	}

	public void addPlayer(PlayerEntity player) {
		this.players.add(player);
	}
}
