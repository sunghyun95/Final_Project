package classdata.data;

import java.util.List;

public interface ClassDataServiceInter {
	public void insertClassData(ClassDataDto dto);
	public int selectMaxNum();
	public ClassDataDto selectOne(int classdata_num);
	public List<ClassDataDto> AllClassData(int process_num);
	public void updateClassData(ClassDataDto dto);
	public void deleteClassData(int classdata_num);
}
