package studyapply.data;

import org.springframework.stereotype.Service;

import study.data.StudyDto;
import studygroup.data.StudyGroupDto;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Service
public class StudyApplyService implements StudyApplyServiceInter {
	@Autowired
	private StudyApplyDaoInter dao;
	
	@Override
	public void insertOfStudyApply(StudyApplyDto dto) {
		// TODO Auto-generated method stub
		dao.insertOfStudyApply(dto);
	}
	@Override
	public int selectOfStudyApplyState(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.selectOfStudyApplyState(map);
	}
	@Override
	public List<StudyDto> selectOfMyStudyApply(int studyapply_member_num) {
		// TODO Auto-generated method stub
		return dao.selectOfMyStudyApply(studyapply_member_num);
	}
	@Override
	public List<StudyApplyDto> selectOfApplyMember(int studyapply_study_num) {
		// TODO Auto-generated method stub
		return dao.selectOfApplyMember(studyapply_study_num);
	}
	@Override
	public void deleteOfStudyApply(StudyApplyDto dto) {
		// TODO Auto-generated method stub
		dao.deleteOfStudyApply(dto);
	}
	@Override
	public void deleteOfStudyApplyByGroup(StudyGroupDto dto) {
		// TODO Auto-generated method stub
		dao.deleteOfStudyApplyByGroup(dto);
	}
}
