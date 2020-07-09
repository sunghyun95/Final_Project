package studyapply.data;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import study.data.StudyDto;

@RestController
@CrossOrigin
public class StudyApplyController {
	@Autowired
	private StudyApplyServiceInter service;
	
	@PostMapping("/studyapply/add")
	public void insertStudyApply(@RequestBody StudyApplyDto dto) {
		service.insertOfStudyApply(dto);
		System.out.println("데이터 추가 성공");
	}
	
	@GetMapping("/studyapply/state")
	public int selectOfStudyApplyState(
			@RequestParam int studyapply_member_num,
			@RequestParam int studyapply_study_num
			) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("studyapply_member_num", studyapply_member_num);
		map.put("studyapply_study_num", studyapply_study_num);
		
		return service.selectOfStudyApplyState(map);
	}
	
	@GetMapping("/studyapply/myapply")
	public List<StudyDto> selectOfMyStudyApply(@RequestParam int studyapply_member_num) {
		List<StudyDto> list = service.selectOfMyStudyApply(studyapply_member_num);
		
		return list;
	}
	
	@GetMapping("/studyapply/member")
	public List<StudyApplyDto> selectOfApplyMember(@RequestParam int studyapply_study_num) {
		List<StudyApplyDto> list = service.selectOfApplyMember(studyapply_study_num);
		
		return list;
	}
	
	@PostMapping("/studyapply/delete")
	public void deleteOfStudyApply(@RequestBody StudyApplyDto dto) {
		service.deleteOfStudyApply(dto);
		System.out.println("스터디 신청 데이터 삭제");
	}
	
	@DeleteMapping("studyapply/myapplydelete")
	public void deleteOfMyApply(@RequestParam int study_num, @RequestParam int studyapply_member_num) {
		StudyApplyDto dto = new StudyApplyDto();
		dto.setStudyapply_study_num(study_num);
		dto.setStudyapply_member_num(studyapply_member_num);
		service.deleteOfStudyApply(dto);
		System.out.println("스터디 신청 취소 성공");
	}
}
