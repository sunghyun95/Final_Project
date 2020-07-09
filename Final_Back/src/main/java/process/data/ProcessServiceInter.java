package process.data;

import java.util.List;

import files.data.FilesDto;
import files.data.ProcessFilesDto;
import member.data.MemberDto;

public interface ProcessServiceInter {
	public List<MemberDto> searchTeacher();
	public void insertProcess(ProcessDto processdto);
	public int selectProcessMaxnum();
	
	public List<ProcessListDto> getAllProcess();
	public MemberDto selectOneTeacher(String teachernum);
	public void insertProcessFiles(ProcessFilesDto processfilesdto);
	public ProcessDto selectOneProcess(int process_num);
	public List<ProcessFilesDto> processFilesList(int processfiles_process_num);
	
	public void deleteProcess(int process_num);
	public void deleteProcessFiles(int process_num);
	
	public void updateProcess(ProcessDto processdto);
	public ProcessFilesDto getProcessImage(int processfiles_num);
	public void deleteImage(int processfiles_num);
	public List<ProcessListDto> getAllMainProcess(String process_type);
	public List<ProcessDto> managerlist(int member_num);

}
