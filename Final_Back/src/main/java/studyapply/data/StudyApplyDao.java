package studyapply.data;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import study.data.StudyDto;
import studygroup.data.StudyGroupDto;

@Repository
public class StudyApplyDao extends SqlSessionDaoSupport implements StudyApplyDaoInter {
	@Override
	public void insertOfStudyApply(StudyApplyDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfStudyApply", dto);
	}
	@Override
	public int selectOfStudyApplyState(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOfStudyApplyState", map);
	}
	@Override
	public List<StudyDto> selectOfMyStudyApply(int studyapply_member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfMyStudyApply", studyapply_member_num);
	}
	@Override
	public List<StudyApplyDto> selectOfApplyMember(int studyapply_study_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfApplyMember", studyapply_study_num);
	}
	@Override
	public void deleteOfStudyApply(StudyApplyDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfStudyApply", dto);
	}
	@Override
	public void deleteOfStudyApplyByGroup(StudyGroupDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfStudyApplyByGroup", dto);
	}
}
