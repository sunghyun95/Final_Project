package reply.data;

import java.util.List;

public interface ReplyDaoInter {
	public void insertOfReply(ReplyDto dto);
	public List<ReplyDto> selectOfReply();
	public void deleteOfReply(int reply_num);
}
