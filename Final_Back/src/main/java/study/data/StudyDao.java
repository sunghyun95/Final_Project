package study.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StudyDao extends SqlSessionDaoSupport implements StudyDaoInter {
	@Override
	public void insertStudy(StudyDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfStudy", dto);
	}
	@Override
	public List<StudyDto> selectOfStudyList(StudySearchDto sdto) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		if(sdto.getSearchSubject()!=null)
		{
			map.put("textfield", sdto.getTextfield());
			map.put("searchSubject", sdto.getSearchSubject());
			map.put("searchLevel", sdto.getSearchLevel());
			map.put("searchType",sdto.getSearchType());
			map.put("searchStartdate", sdto.getSearchStartdate());
			map.put("searchEnddate",sdto.getSearchEnddate());
			map.put("searchGatherday", sdto.getSearchGatherday());
			map.put("searchAddress",sdto.getSearchAddress());
			map.put("searchDetailAddr",sdto.getSearchDetailAddr());
		}
		return getSqlSession().selectList("selectOfStudyList",map);
	}
	@Override
	public int selectNumOfNewestStudy() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectNumOfNewestStudy");
	}
	@Override
	public StudyDto selectOfStudyByNum(int study_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOfStudyByNum", study_num);
	}
	@Override
	public List<StudyDto> selectOfStudyFounder(int study_member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfStudyFounder", study_member_num);
	}
	@Override
	public void deleteOfStudy(int study_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfStudy", study_num);
	}
	@Override
	public void updateOfStudy(StudyDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfStudy", dto);
	}
	@Override
	public void updateOfStudyReadCount(int study_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfStudyReadCount", study_num);
	}
}
