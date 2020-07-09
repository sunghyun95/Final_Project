package memo.data;

import java.util.List;

import process.data.ProcessDto;

public interface MemoDaoInter {
	public List<MemoDto> getMemoList(int process_num);
	public void insertMemo(MemoDto memodto);
	public List<ProcessDto> getProcessList(int member_num);
	public int getMemoMaxnum();
	public void deleteMemo(int memo_num);
	public MemoDto selectOneMemo(int memo_num);
	public void updateMemo(MemoDto memodto);
}
