package qna.data;

import java.util.List;

public interface QnaDaoInter {
	//��ü ����Ʈ ��ȸ
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
	//QnA �˻�
	public List<QnaDto> allOfQna(String field,String search);
}
