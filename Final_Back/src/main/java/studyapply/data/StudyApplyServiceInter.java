package studyapply.data;

import java.util.HashMap;
import java.util.List;

import study.data.StudyDto;
import studygroup.data.StudyGroupDto;

public interface StudyApplyServiceInter {
	public void insertOfStudyApply(StudyApplyDto dto);
	public int selectOfStudyApplyState(HashMap<String, Integer> map);
	public List<StudyDto> selectOfMyStudyApply(int studyapply_member_num);
	public List<StudyApplyDto> selectOfApplyMember(int studyapply_study_num);
	public void deleteOfStudyApply(StudyApplyDto dto);
	public void deleteOfStudyApplyByGroup(StudyGroupDto dto);
}
