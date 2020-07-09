package process.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import files.data.FilesDto;
import files.data.ProcessFilesDto;
import member.data.MemberDto;

@Repository
public class ProcessDao extends SqlSessionDaoSupport implements ProcessDaoInter{

	@Override
	public List<MemberDto> searchTeacher() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("searchTeacher");
	}

	@Override
	public void insertProcess(ProcessDto processdto) {
		
		getSqlSession().insert("insertProcess",processdto);
		
	}

	@Override
	public int selectProcessMaxnum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectProcessMaxnum");
	}
	@Override
	public List<ProcessListDto> getAllProcess() {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", 0);
		map.put("end", 9);
		
		return getSqlSession().selectList("getAllProcess",map);
	}

	@Override
	public MemberDto selectOneTeacher(String teachernum) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOneTeacher",teachernum);
	}

	@Override
	public void insertProcessFiles(ProcessFilesDto processfilesdto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertProcessFiles", processfilesdto);
	}

	@Override
	public ProcessDto selectOneProcess(int process_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOneProcess",process_num);
	}

	@Override
	public List<ProcessFilesDto> processFilesList(int processfiles_process_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("processFilesList",processfiles_process_num);
	}

	@Override
	public void deleteProcess(int process_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteProcess",process_num);
	}

	@Override
	public void deleteProcessFiles(int process_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteProcessFiles",process_num);
	}

	@Override
	public void updateProcess(ProcessDto processdto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateProcess", processdto);
	}

	@Override
	public void deleteImage(int processfiles_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteImage",processfiles_num);
	}

	@Override
	public ProcessFilesDto getProcessImage(int processfiles_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("getProcessImage",processfiles_num);
	}

	@Override
	public List<ProcessListDto> getAllMainProcess(String process_type) {
		// TODO Auto-generated method stub
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("start", 0);
				map.put("end", 9);
				map.put("process_type",process_type);
		return getSqlSession().selectList("getAllMainProcess",map);
	}

	@Override
	public List<ProcessDto> managerlist(int member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("managerlist", member_num);
	}

	

	


	


}
