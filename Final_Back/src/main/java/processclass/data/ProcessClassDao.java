package processclass.data;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import process.data.ProcessDto;

@Repository
public class ProcessClassDao extends SqlSessionDaoSupport implements ProcessClassDaoInter{

	@Override
	public void insertProcessClass(ProcessClassDto processclassdto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertProcessClass",processclassdto);
	}

	@Override
	public void updateTeacherNum(ProcessClassDto processclassdto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateTeacherNum",processclassdto);
	}

	@Override
	public void updateMemberType(int member_num, String process_subject) {
		// TODO Auto-generated method stub
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("process_subject",process_subject);
		map.put("member_num", member_num);
		
		
		getSqlSession().update("updateMemberType",map);
	}

	@Override
	public int checkProcessClass(int processclass_process_num, int processclass_member_num) {
		// TODO Auto-generated method stub
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		map.put("process_num", processclass_process_num);
		map.put("member_num",processclass_member_num);
		
		
		return getSqlSession().selectOne("checkProcessClass",map);
	}

	@Override
	public ProcessDto getClassPage(String member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("getClassPage",member_num);
	}
}
