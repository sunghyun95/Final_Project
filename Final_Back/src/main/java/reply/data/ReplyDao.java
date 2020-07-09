package reply.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDao extends SqlSessionDaoSupport implements ReplyDaoInter {
	@Override
	public void insertOfReply(ReplyDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfReply", dto);
	}
	
	@Override
	public List<ReplyDto> selectOfReply() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfReply");
	}
	
	@Override
	public void deleteOfReply(int reply_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfReply", reply_num);
	}
}
