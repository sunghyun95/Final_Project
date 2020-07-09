package processclass.data;

import process.data.ProcessDto;

public interface ProcessClassServiceInter {
	public void insertProcessClass(ProcessClassDto processclassdto);
	public void updateTeacherNum(ProcessClassDto processclassdto);
	public void updateMemberType(int member_num,String process_subject);
	public int checkProcessClass(int processclass_process_num,int processclass_member_num);
	public ProcessDto getClassPage(String member_num);
	
}
