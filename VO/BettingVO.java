package VO;

public class BettingVO {
	private String gameNo;
	private String memId;
	private long amount;
	private String result;
	public BettingVO(String gameNo, String memId, long amount, String result) {
		this.gameNo = gameNo;
		this.memId = memId;
		this.amount = amount;
		this.result = result;
	}
	public String getGameNo() {
		return gameNo;
	}
	public void setGameNo(String gameNo) {
		this.gameNo = gameNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "BettingVO [gameNo=" + gameNo + ", memId=" + memId + ", amount=" + amount + ", result=" + result + "]";
	}
	
}
