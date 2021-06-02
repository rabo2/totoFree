package VO;

public class myGameAndResultVO {
	private String gameDate;
	private String gameNo;
	private String homeTeam;
	private String awayTeam;
	private String choiceResult;
	private String bettingAmount;
	private String gameResult;
	private String refundsRate;
	public myGameAndResultVO(String gameDate, String gameNo, String homeTeam, String awayTeam, String choiceResult,
			String bettingAmount, String gameResult, String refundsRate) {
		this.gameDate = gameDate;
		this.gameNo = gameNo;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.choiceResult = choiceResult;
		this.bettingAmount = bettingAmount;
		this.gameResult = gameResult;
		this.refundsRate = refundsRate;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public String getGameNo() {
		return gameNo;
	}
	public void setGameNo(String gameNo) {
		this.gameNo = gameNo;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public String getChoiceResult() {
		return choiceResult;
	}
	public void setChoiceResult(String choiceResult) {
		this.choiceResult = choiceResult;
	}
	public String getBettingAmount() {
		return bettingAmount;
	}
	public void setBettingAmount(String bettingAmount) {
		this.bettingAmount = bettingAmount;
	}
	public String getGameResult() {
		return gameResult;
	}
	public void setGameResult(String gameResult) {
		this.gameResult = gameResult;
	}
	public String getRefundsRate() {
		return refundsRate;
	}
	public void setRefundsRate(String refundsRate) {
		this.refundsRate = refundsRate;
	}
	@Override
	public String toString() {
		return "myGameAndResultVO [gameDate=" + gameDate + ", gameNo=" + gameNo + ", homeTeam=" + homeTeam
				+ ", awayTeam=" + awayTeam + ", choiceResult=" + choiceResult + ", bettingAmount=" + bettingAmount
				+ ", gameResult=" + gameResult + ", refundsRate=" + refundsRate + "]";
	}

	
	
}
