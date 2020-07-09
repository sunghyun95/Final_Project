package processapply.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessApplyService implements ProcessApplyServiceInter{

	@Autowired
	private ProcessApplyDaoInter dao;

	@Override
	public void insertProcessApply(ProcessApplyDto processapplydto) {
		// TODO Auto-generated method stub
		dao.insertProcessApply(processapplydto);
	}

	@Override
	public List<ProcessApplyDto> listProcessApply(int member_num) {
		// TODO Auto-generated method stub
		return dao.listProcessApply(member_num);
	}

	@Override
	public ProcessApplyDto selectProcessApply(int member_num) {
		// TODO Auto-generated method stub
		return dao.selectProcessApply(member_num);
	}

	@Override
	public void upldateProcessApplyAccept(ProcessApplyDto processapplydto) {
		// TODO Auto-generated method stub
		dao.upldateProcessApplyAccept(processapplydto);
	}
}
