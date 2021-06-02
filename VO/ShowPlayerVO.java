package VO;

public class ShowPlayerVO {
	private String backNum;
	private String playerName;
	private String height;
	private String weight;
	private String position;
	public ShowPlayerVO(String backNum, String playerName, String height, String weight, String position) {
		super();
		this.backNum = backNum;
		this.playerName = playerName;
		this.height = height;
		this.weight = weight;
		this.position = position;
	}
	public String getBackNum() {
		return backNum;
	}
	public void setBackNum(String backNum) {
		this.backNum = backNum;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "ShowPlayerVO [backNum=" + backNum + ", playerName=" + playerName + ", height=" + height + ", weight="
				+ weight + ", position=" + position + "]";
	}
	public String getPosition() {
		return position;
	}
	
		
	}


	