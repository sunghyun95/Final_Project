package classdata.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

	@Repository
	public class ClassDataDao extends SqlSessionDaoSupport implements ClassDataDaoInter{

		@Override
		public void insertClassData(ClassDataDto dto) {
			getSqlSession().insert("insertOfClassData",dto);
			
		}

		@Override
		public int selectMaxNum() {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("selectClassDataMaxnum");
		}

		@Override
		public List<ClassDataDto> AllClassData(int process_num) {
			// TODO Auto-generated method stub
			return getSqlSession().selectList("selectOfClassData",process_num);
		}

		@Override
		public void updateClassData(ClassDataDto dto) {
			// TODO Auto-generated method stub
			getSqlSession().update("updateOfClassData",dto);
			
		}

		@Override
		public void deleteClassData(int classdata_num) {
			// TODO Auto-generated method stub
			getSqlSession().delete("deleteOfClassData",classdata_num);
		}

		@Override
		public ClassDataDto selectOne(int classdata_num) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("selectOneOfClassData", classdata_num);
		}


}
