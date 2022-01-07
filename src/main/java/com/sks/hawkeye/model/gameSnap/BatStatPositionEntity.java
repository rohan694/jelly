package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BatStatPosition")
public class BatStatPositionEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private TrajectoryEntity trajectory;
    public double x;
    public double y;
    

    public BatStatPositionEntity() {}
	public BatStatPositionEntity(TrajectoryEntity trajectory) {
		this.trajectory = trajectory;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TrajectoryEntity getTrajectory() {
		return trajectory;
	}
	public void setTrajectory(TrajectoryEntity trajectory) {
		this.trajectory = trajectory;
	}
    
}