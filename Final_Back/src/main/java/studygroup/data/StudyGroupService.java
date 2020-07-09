package studygroup.data;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import member.data.MemberDto;
import study.data.StudyDto;

@Repository
@Service
public class StudyGroupService implements StudyGroupServiceInter {
	@Autowired
	private StudyGroupDaoInter dao;
	
	@Override
	public void insertStudyGroup(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		dao.insertStudyGroup(map);
	}
	@Override
	public void insertOfStudyGroupByDto(StudyGroupDto dto) {
		// TODO Auto-generated method stub
		dao.insertOfStudyGroupByDto(dto);
	}
	@Override
	public int selectCountOfStudyGroupPeoples(int studygroup_study_num) {
		// TODO Auto-generated method stub
		return dao.selectCountOfStudyGroupPeoples(studygroup_study_num);
	}
	@Override
	public int selectOfStudyGroupParticipationState(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.selectOfStudyGroupParticipationState(map);
	}
	@Override
	public List<StudyDto> selectOfStudyGroupParticipation(int studygroup_member_num) {
		// TODO Auto-generated method stub
		return dao.selectOfStudyGroupParticipation(studygroup_member_num);
	}
	@Override
	public int selectOfZeroCheckByStudyGroup(int study_num) {
		// TODO Auto-generated method stub
		return dao.selectOfZeroCheckByStudyGroup(study_num);
	}
	@Override
	public void deleteOfStudyGroup(StudyGroupDto dto) {
		// TODO Auto-generated method stub
		dao.deleteOfStudyGroup(dto);
	}
	@Override
	public List<MemberDto> selectOfStudyMember(int studygroup_study_num) {
		// TODO Auto-generated method stub
		return dao.selectOfStudyMember(studygroup_study_num);
	}
}
