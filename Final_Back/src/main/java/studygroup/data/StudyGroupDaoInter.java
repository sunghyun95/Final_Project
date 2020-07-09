package studygroup.data;

import java.util.HashMap;
import java.util.List;

import member.data.MemberDto;
import study.data.StudyDto;

public interface StudyGroupDaoInter {
	public void insertStudyGroup(HashMap<String, Integer> map);
	public void insertOfStudyGroupByDto(StudyGroupDto dto);
	public int selectCountOfStudyGroupPeoples(int studygroup_study_num);
	public int selectOfStudyGroupParticipationState(HashMap<String, Integer> map);
	public List<StudyDto> selectOfStudyGroupParticipation(int studygroup_member_num);
	public int selectOfZeroCheckByStudyGroup(int study_num);
	public void deleteOfStudyGroup(StudyGroupDto dto);
	public List<MemberDto> selectOfStudyMember(int studygroup_study_num);
}
