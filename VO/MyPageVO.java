package VO;

public class MyPageVO {
	private String gameDate;
	private String gameNo;
	private String homeTeam;
	private String awayTeam;
	private String choiceResult;
	private String bettingAmount;

	public MyPageVO(String gameDate, String gameNo, String homeTeam, String awayTeam, String choiceResult,
			String bettingAmount) {
		this.gameDate = gameDate.replaceAll("(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])", gameDate);
		this.gameNo = gameNo;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.choiceResult = choiceResult;
		this.bettingAmount = bettingAmount;
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
	String patternStr = "(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])";

	@Override
	public String toString() {
		return "게임날짜 : " + gameDate + ", 게임번호 : " + gameNo + ", 홈팀 : " + homeTeam + ", 어웨이팀 :"
				+ awayTeam + ", 선택결과 : " + choiceResult + ", 배팅금 : "+ bettingAmount;
	}

}
