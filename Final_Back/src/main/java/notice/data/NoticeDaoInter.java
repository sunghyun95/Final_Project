package notice.data;

import java.util.List;

public interface NoticeDaoInter {
	//����Ʈ
	public List<NoticeDto> AllNotice();
	//maxNum
	public int maxNumNotice();
	//�߰�
	public void insertNotice(NoticeDto ndto);
	//������ȸ
	public NoticeDto getNotice(int notice_num);
	//����
	public void updateNotice(NoticeDto ndto);
	//����
	public void deleteNotice(int notice_num);
	//��ȸ��
	public void readCount(int notice_num);
	//������
	public void updateNoticetype(int notice_type,int notice_num);
	//�������� �˻�
	public List<NoticeDto> allOfNotice(String field,String search);
}
