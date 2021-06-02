package VO;

/**
 * 일자별 경기조회 VO
 * @author PC-05
 *
 */
public class searchGameVO {
	private String gameNo;
	private String homeTeam;
	private String awayTeam;
	private String homeTeamRate;
	private String awayTeamRate;
	private String drawTeamRate;
	public searchGameVO(String gameNo, String homeTeam, String awayTeam, String homeTeamRate, String awayTeamRate,
			String drawTeamRate) {
		super();
		this.gameNo = gameNo;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamRate = homeTeamRate;
		this.awayTeamRate = awayTeamRate;
		this.drawTeamRate = drawTeamRate;
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
	public String getHomeTeamRate() {
		return homeTeamRate;
	}
	public void setHomeTeamRate(String homeTeamRate) {
		this.homeTeamRate = homeTeamRate;
	}
	public String getAwayTeamRate() {
		return awayTeamRate;
	}
	public void setAwayTeamRate(String awayTeamRate) {
		this.awayTeamRate = awayTeamRate;
	}
	public String getDrawTeamRate() {
		return drawTeamRate;
	}
	public void setDrawTeamRate(String drawTeamRate) {
		this.drawTeamRate = drawTeamRate;
	}
	@Override
	public String toString() {
		return "searchGameVO [gameNo=" + gameNo + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
				+ ", homeTeamRate=" + homeTeamRate + ", awayTeamRate=" + awayTeamRate + ", drawTeamRate=" + drawTeamRate
				+ "]";
	}
	
}