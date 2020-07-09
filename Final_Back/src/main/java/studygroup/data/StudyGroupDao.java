package studygroup.data;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import member.data.MemberDto;
import study.data.StudyDto;

@Repository
public class StudyGroupDao extends SqlSessionDaoSupport implements StudyGroupDaoInter {
	@Override
	public void insertStudyGroup(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfStudyGroup", map);
	}
	@Override
	public void insertOfStudyGroupByDto(StudyGroupDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfStudyGroupByDto", dto);
	}
	@Override
	public int selectCountOfStudyGroupPeoples(int studygroup_study_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCountOfStudyGroupPeoples", studygroup_study_num);
	}
	@Override
	public int selectOfStudyGroupParticipationState(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOfStudyGroupParticipationState", map);
	}
	@Override
	public List<StudyDto> selectOfStudyGroupParticipation(int studygroup_member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfStudyGroupParticipation", studygroup_member_num);
	}
	@Override
	public int selectOfZeroCheckByStudyGroup(int study_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOfZeroCheckByStudyGroup", study_num);
	}
	@Override
	public void deleteOfStudyGroup(StudyGroupDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfStudyGroup", dto);
	}
	@Override
	public List<MemberDto> selectOfStudyMember(int studygroup_study_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfStudyMember", studygroup_study_num);
	}
}
