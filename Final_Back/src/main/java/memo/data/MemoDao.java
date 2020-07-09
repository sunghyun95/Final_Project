package memo.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import process.data.ProcessDto;

@Repository
public class MemoDao extends SqlSessionDaoSupport implements MemoDaoInter{

	@Override
	public List<MemoDto> getMemoList(int process_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("getMemoList",process_num);
	}

	@Override
	public void insertMemo(MemoDto memodto) {
		// TODO Auto-generated method stub
		
		System.out.println(memodto.getMemo_subject());
		
		getSqlSession().insert("insertMemo",memodto);
	}

	@Override
	public List<ProcessDto> getProcessList(int member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("getProcessList", member_num);
	}

	@Override
	public int getMemoMaxnum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("getMemoMaxnum");
	}

	@Override
	public void deleteMemo(int memo_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteMemo",memo_num);
	}

	@Override
	public MemoDto selectOneMemo(int memo_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOneMemo",memo_num);
	}

	@Override
	public void updateMemo(MemoDto memodto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateMemo",memodto);
	}

}
