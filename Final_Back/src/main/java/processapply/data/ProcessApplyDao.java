package processapply.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessApplyDao extends SqlSessionDaoSupport implements ProcessApplyDaoInter{

	@Override
	public void insertProcessApply(ProcessApplyDto processapplydto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertProcessApply",processapplydto);
	}

	@Override
	public List<ProcessApplyDto> listProcessApply(int member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("listProcessApply",member_num);
	}

	@Override
	public ProcessApplyDto selectProcessApply(int member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectProcessApply",member_num);
	}

	@Override
	public void upldateProcessApplyAccept(ProcessApplyDto processapplydto) {
		// TODO Auto-generated method stub
		getSqlSession().update("upldateProcessApplyAccept",processapplydto);
	}

}
