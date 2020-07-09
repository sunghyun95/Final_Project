package reply.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class ReplyService implements ReplyServiceInter {
	@Autowired
	private ReplyDaoInter dao;
	
	@Override
	public void insertOfReply(ReplyDto dto) {
		// TODO Auto-generated method stub
		dao.insertOfReply(dto);
	}
	
	@Override
	public List<ReplyDto> selectOfReply() {
		// TODO Auto-generated method stub
		return dao.selectOfReply();
	}
	
	@Override
	public void deleteOfReply(int reply_num) {
		// TODO Auto-generated method stub
		dao.deleteOfReply(reply_num);
	}
}
