package processapply.data;

import java.util.List;


public interface ProcessApplyDaoInter {
	public void insertProcessApply(ProcessApplyDto processapplydto);
	public List<ProcessApplyDto> listProcessApply(int member_num);
	public ProcessApplyDto selectProcessApply(int member_num);
	public void upldateProcessApplyAccept(ProcessApplyDto processapplydto);
}
