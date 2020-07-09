package study.data;

import java.util.List;

public interface StudyServiceInter {
	public void insertStudy(StudyDto dto);
	public List<StudyDto> selectOfStudyList(StudySearchDto sdto);
	public int selectNumOfNewestStudy();
	public StudyDto selectOfStudyByNum(int study_num);
	public List<StudyDto> selectOfStudyFounder(int study_member_num);
	public void deleteOfStudy(int study_num);
	public void updateOfStudy(StudyDto dto);
	public void updateOfStudyReadCount(int study_num);
}
