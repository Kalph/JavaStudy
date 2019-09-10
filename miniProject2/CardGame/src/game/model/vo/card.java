package game.model.vo;

public class card {
	private String name;
	private int atk;
	
	public card() {}

	public card(String name, int atk) {
		this.name = name;
		this.atk = atk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	
	
}
