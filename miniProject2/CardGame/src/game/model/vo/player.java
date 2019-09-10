package game.model.vo;

import java.io.Serializable;

public class player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4750298945102194097L;
	private int lifeP;
	private int skill;
	
	public player() {}
	
	public player(int lifeP, int skill) {
		this.lifeP = lifeP;
		this.skill = skill;
	}
	
	public int getLifeP() {
		return lifeP;
	}

	public void setLifeP(int lifeP) {
		this.lifeP = lifeP;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "player [lifeP=" + lifeP + ", skill=" + skill + "]";
	}
	
	
}
