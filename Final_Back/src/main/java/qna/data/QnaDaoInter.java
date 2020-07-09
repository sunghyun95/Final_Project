package qna.data;

import java.util.List;

public interface QnaDaoInter {
	//전체 리스트 조회
	public List<QnaDto> getAlllist();
	//totalCount
	public int getTotalCount();
	//maxNum
	public int getMaxNum();
	//update Restep
	public void updateRestep(int qna_regroup, int qna_restep);
	//insert
	public void insertQna(QnaDto dto);
	//readcount
	public void updateReadCount(int qna_num);
	//get data
	public QnaDto getData(int qna_num);
	//update
	public void updateQna(QnaDto dto);
	//delete
	public void deleteQna(int qna_num);
	//QnA 검색
	public List<QnaDto> allOfQna(String field,String search);
}
