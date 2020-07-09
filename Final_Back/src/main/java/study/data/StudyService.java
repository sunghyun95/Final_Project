package study.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class StudyService implements StudyServiceInter {
	@Autowired
	private StudyDaoInter dao;
	
	@Override
	public void insertStudy(StudyDto dto) {
		// TODO Auto-generated method stub
		dao.insertStudy(dto);
	}
	@Override
	public List<StudyDto> selectOfStudyList(StudySearchDto sdto) {
		// TODO Auto-generated method stub
		return dao.selectOfStudyList(sdto);
	}
	@Override
	public int selectNumOfNewestStudy() {
		// TODO Auto-generated method stub
		return dao.selectNumOfNewestStudy();
	}
	@Override
	public StudyDto selectOfStudyByNum(int study_num) {
		// TODO Auto-generated method stub
		return dao.selectOfStudyByNum(study_num);
	}
	@Override
	public List<StudyDto> selectOfStudyFounder(int study_member_num) {
		// TODO Auto-generated method stub
		return dao.selectOfStudyFounder(study_member_num);
	}
	@Override
	public void deleteOfStudy(int study_num) {
		// TODO Auto-generated method stub
		dao.deleteOfStudy(study_num);
	}
	@Override
	public void updateOfStudy(StudyDto dto) {
		// TODO Auto-generated method stub
		dao.updateOfStudy(dto);
	}
	@Override
	public void updateOfStudyReadCount(int study_num) {
		// TODO Auto-generated method stub
		dao.updateOfStudyReadCount(study_num);
	}
}
