package Service;

import java.util.List;
import DAO.ShowPlayerDAO;
import VO.ShowPlayerVO;

public class ShowPlayer {
	public static void search(String inputTeam) throws Exception {
		ShowPlayerDAO input = new ShowPlayerDAO();
		List<ShowPlayerVO> select = input.selectshowPlayer(inputTeam);
		if(select.size() == 0){
			System.out.println("존재하지 않는 팀입니다.");
		}
		for (ShowPlayerVO ShowPlayerVO : select) {
			System.out.println(ShowPlayerVO.getPlayerName() + "\t" + ShowPlayerVO.getBackNum() + "\t"
					+ ShowPlayerVO.getPosition() + "\t" + ShowPlayerVO.getHeight() + "\t" + ShowPlayerVO.getWeight());
		}
	}
}
