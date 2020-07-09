package process.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import files.data.FilesDto;
import files.data.ProcessFilesDto;
import member.data.MemberDto;

@Service
public class ProcessService implements ProcessServiceInter{

	@Autowired
	private ProcessDaoInter dao;
	
	@Override
	public List<MemberDto> searchTeacher() {
		// TODO Auto-generated method stub
		return dao.searchTeacher();
	}

	@Override
	public void insertProcess(ProcessDto processdto) {
		// TODO Auto-generated method stub
		dao.insertProcess(processdto);
	}

	@Override
	public int selectProcessMaxnum() {
		// TODO Auto-generated method stub
		return dao.selectProcessMaxnum();
	}
	@Override
	public List<ProcessListDto> getAllProcess() {
		// TODO Auto-generated method stub
		return dao.getAllProcess();
	}

	@Override
	public MemberDto selectOneTeacher(String teachernum) {
		// TODO Auto-generated method stub
		return dao.selectOneTeacher(teachernum);
	}

	@Override
	public void insertProcessFiles(ProcessFilesDto processfilesdto) {
		// TODO Auto-generated method stub
		dao.insertProcessFiles(processfilesdto);
	}

	@Override
	public ProcessDto selectOneProcess(int process_num) {
		// TODO Auto-generated method stub
		return dao.selectOneProcess(process_num);
	}

	@Override
	public List<ProcessFilesDto> processFilesList(int processfiles_process_num) {
		// TODO Auto-generated method stub
		return dao.processFilesList(processfiles_process_num);
	}

	@Override
	public void deleteProcess(int process_num) {
		// TODO Auto-generated method stub
		dao.deleteProcess(process_num);
	}

	@Override
	public void deleteProcessFiles(int process_num) {
		// TODO Auto-generated method stub
		dao.deleteProcessFiles(process_num);
	}

	@Override
	public void updateProcess(ProcessDto processdto) {
		// TODO Auto-generated method stub
		dao.updateProcess(processdto);
	}

	@Override
	public void deleteImage(int processfiles_num) {
		// TODO Auto-generated method stub
		dao.deleteImage(processfiles_num);
	}

	@Override
	public ProcessFilesDto getProcessImage(int processfiles_num) {
		// TODO Auto-generated method stub
		return dao.getProcessImage(processfiles_num);
	}

	@Override
	public List<ProcessListDto> getAllMainProcess(String process_type) {
		// TODO Auto-generated method stub
		return dao.getAllMainProcess(process_type);
	}

	@Override
	public List<ProcessDto> managerlist(int member_num) {
		// TODO Auto-generated method stub
		return dao.managerlist(member_num);
	}


	

	

	

}
