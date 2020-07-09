package qna.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDao extends SqlSessionDaoSupport implements QnaDaoInter {

	@Autowired
	private QnaDaoInter dao;
	
	@Override
	public List<QnaDto> getAlllist() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selecoOfQna");
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("totalCountOfQna");
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOfMaxnum");
	}

	@Override
	public void updateRestep(int qna_regroup, int qna_restep) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("qna_regroup", qna_regroup);
		map.put("qna_restep", qna_restep);
		getSqlSession().update("updateRestepOfBoard", map);
	}

	@Override
	public void insertQna(QnaDto dto) {
		// TODO Auto-generated method stub
		System.out.println(dto);
		int regroup, restep, relevel;
		if(dto.getQna_num()==0) //새글
		{
			regroup=dao.getMaxNum()+1;
			restep=0;
			relevel=0;
		}else {
			//답글
			regroup=dto.getQna_regroup();
			//전달 받은 restep보다 큰 값들은 모두 +1
			if(dto.getQna_restep()!=0)
				this.updateRestep(regroup, dto.getQna_restep());
			//전달받은 restep+1
			restep=dto.getQna_restep()+1;
			relevel=dto.getQna_relevel()+1;
		}
		
		dto.setQna_regroup(regroup);
		dto.setQna_restep(restep);
		dto.setQna_relevel(relevel);
		getSqlSession().insert("insertOfQna", dto);
	}

	@Override
	public void updateReadCount(int qna_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("readCountOfQna", qna_num);
	}

	@Override
	public QnaDto getData(int qna_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOneOfQna", qna_num);
	}

	@Override
	public void updateQna(QnaDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfQna", dto);
	}

	@Override
	public void deleteQna(int qna_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfQna", qna_num);
	}

	@Override
	public List<QnaDto> allOfQna(String field, String search) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		if(search!=null)
		{
			map.put("field", field);
			map.put("search", search);
		}
		return getSqlSession().selectList("allOfQna",map);
	}

}
