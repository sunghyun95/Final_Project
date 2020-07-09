package classdata.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class ClassDataService implements ClassDataServiceInter {
	
	@Autowired
	private ClassDataDao dao;

	@Override
	public void insertClassData(ClassDataDto dto) {
		dao.insertClassData(dto);
		
	}

	@Override
	public int selectMaxNum() {
		// TODO Auto-generated method stub
		return dao.selectMaxNum();
	}

	@Override
	public List<ClassDataDto> AllClassData(int process_num) {
		// TODO Auto-generated method stub
		return dao.AllClassData(process_num);
	}

	@Override
	public void updateClassData(ClassDataDto dto) {
		// TODO Auto-generated method stub
		dao.updateClassData(dto);
	}

	@Override
	public void deleteClassData(int classdata_num) {
		// TODO Auto-generated method stub
		dao.deleteClassData(classdata_num);
	}

	@Override
	public ClassDataDto selectOne(int classdata_num) {
		// TODO Auto-generated method stub
		return dao.selectOne(classdata_num);
	}

}