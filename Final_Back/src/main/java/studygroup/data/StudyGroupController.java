package studygroup.data;

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
import study.data.StudyServiceInter;
import studyapply.data.StudyApplyServiceInter;

@RestController
@CrossOrigin
public class StudyGroupController {
	@Autowired
	private StudyGroupServiceInter service;
	
	@Autowired
	private StudyApplyServiceInter applyservice;
	
	@Autowired
	private StudyServiceInter studyservice;
	
	@PostMapping("/studygroup/add")
	public void insertOfStudyGroup(@RequestBody StudyGroupDto dto) {
		service.insertOfStudyGroupByDto(dto);
		applyservice.deleteOfStudyApplyByGroup(dto);
		System.out.println("그룹 추가 성공 및 신청 데이터 삭제");
	}
	
	@GetMapping("/studygroup/state")
	public int selectOfStudyGroupParticipationState(
			@RequestParam int studygroup_study_num,
			@RequestParam int studygroup_member_num
			) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("studygroup_study_num", studygroup_study_num);
		map.put("studygroup_member_num", studygroup_member_num);
		
		return service.selectOfStudyGroupParticipationState(map);
	}
	
	@GetMapping("/studygroup/joinedlist")
	public List<StudyDto> selectOfStudyGroupParticipation(@RequestParam int studygroup_member_num) {
		List<StudyDto> list = service.selectOfStudyGroupParticipation(studygroup_member_num);
		
		return list;
	}
	
	@DeleteMapping("/studygroup/delete")
	public void deleteOfStudyGroup(@RequestParam int study_num, @RequestParam int studygroup_member_num) {
		StudyGroupDto dto = new StudyGroupDto();
		dto.setStudygroup_study_num(study_num);
		dto.setStudygroup_member_num(studygroup_member_num);
		service.deleteOfStudyGroup(dto);
		System.out.println("스터디 멤버 삭제");
		
		int count = service.selectOfZeroCheckByStudyGroup(study_num);
		if(count == 0) {
			studyservice.deleteOfStudy(study_num);
			System.out.println("멤버가 0이 되어 스터디가 삭제됨");
		}
	}
}
