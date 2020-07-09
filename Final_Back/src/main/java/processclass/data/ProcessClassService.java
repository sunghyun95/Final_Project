package processclass.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import process.data.ProcessDto;

@Service
public class ProcessClassService implements ProcessClassServiceInter{

	@Autowired
	private ProcessClassDaoInter dao;
	
	@Override
	public void insertProcessClass(ProcessClassDto processclassdto) {
		// TODO Auto-generated method stub
		dao.insertProcessClass(processclassdto);
	}

	@Override
	public void updateTeacherNum(ProcessClassDto processclassdto) {
		// TODO Auto-generated method stub
		dao.updateTeacherNum(processclassdto);
	}

	@Override
	public void updateMemberType(int member_num, String process_subject) {
		// TODO Auto-generated method stub
		dao.updateMemberType(member_num,process_subject);
	}

	@Override
	public int checkProcessClass(int processclass_process_num, int processclass_member_num) {
		// TODO Auto-generated method stub
		return dao.checkProcessClass(processclass_process_num, processclass_member_num);
	}

	@Override
	public ProcessDto getClassPage(String member_num) {
		// TODO Auto-generated method stub
		return dao.getClassPage(member_num);
	}


	

}
