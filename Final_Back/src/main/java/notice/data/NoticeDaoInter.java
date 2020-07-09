package notice.data;

import java.util.List;

public interface NoticeDaoInter {
	//리스트
	public List<NoticeDto> AllNotice();
	//maxNum
	public int maxNumNotice();
	//추가
	public void insertNotice(NoticeDto ndto);
	//선택조회
	public NoticeDto getNotice(int notice_num);
	//수정
	public void updateNotice(NoticeDto ndto);
	//삭제
	public void deleteNotice(int notice_num);
	//조회수
	public void readCount(int notice_num);
	//맨위로
	public void updateNoticetype(int notice_type,int notice_num);
	//공지사항 검색
	public List<NoticeDto> allOfNotice(String field,String search);
}
