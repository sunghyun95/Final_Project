package memo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import process.data.ProcessDto;

@Service
public class MemoService implements MemoServiceInter{

	@Autowired
	private MemoDaoInter dao;
	
	@Override
	public List<MemoDto> getMemoList(int process_num) {
		// TODO Auto-generated method stub
		return dao.getMemoList(process_num);
	}

	@Override
	public void insertMemo(MemoDto memodto) {
		// TODO Auto-generated method stub
		dao.insertMemo(memodto);
	}

	@Override
	public List<ProcessDto> getProcessList(int member_num) {
		// TODO Auto-generated method stub
		return dao.getProcessList(member_num);
	}

	@Override
	public int getMemoMaxnum() {
		// TODO Auto-generated method stub
		return dao.getMemoMaxnum();
	}

	@Override
	public void deleteMemo(int memo_num) {
		// TODO Auto-generated method stub
		dao.deleteMemo(memo_num);
	}

	@Override
	public MemoDto selectOneMemo(int memo_num) {
		// TODO Auto-generated method stub
		return dao.selectOneMemo(memo_num);
	}

	@Override
	public void updateMemo(MemoDto memodto) {
		// TODO Auto-generated method stub
		
	}

}
