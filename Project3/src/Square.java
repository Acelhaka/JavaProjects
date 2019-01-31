

public class Square {
	
	private String pit = "P";
	private String wumpus = "W";
	private String gold = "G";
	private String human = "H";
	private String breeze = "B";
	private String stench = "S";
	private String empty = " ";
	
	public Square() {
	}
	
	
	
	public Square(String human, String gold, String wumpus, String pit) {
		this.human = human;
		this.gold = gold;
		this.wumpus = wumpus;
		this.pit = pit;
	}
	
	
	
	public void setPit(String pit) {
		this.pit = pit;
	}
	
	
	
	public void setWumpus(String wumpus) {
		this.wumpus = wumpus;
	}
	
	
	
	public void setGold(String gold) {
		this.gold = gold;
	}
	
	
	
	public void setHuman(String human) {
		this.human = human;
	}
	
	
	public void setBreeze(String breeze) {
		this.breeze = breeze;
	}
	
	
	public void setStench(String stench) {
		this.stench = stench;
	}
	
	
	public String getPit() {
		return pit;
	}
	
	
	
	public String getWumpus() {
		return wumpus;
	}
	
	
	
	public String getGold() {
		return gold;
	}
	
	
	
	public String getHuman() {
		return human;
	}
	
	public String getBreeze() {
		return breeze;
	}
	
	
	public String getStench() {
		return stench;
	}

	public String getEmpty() {
		return empty;
	}
	public void setEmpty(String empty) {
		this.empty = empty;
	}

	

	
	
	

}
