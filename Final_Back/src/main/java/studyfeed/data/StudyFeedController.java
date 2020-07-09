package studyfeed.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import files.data.StudyFeedFilesDaoInter;
import member.data.MemberDto;
import reply.data.ReplyServiceInter;
import study.data.StudyServiceInter;
import studygroup.data.StudyGroupServiceInter;

@RestController
@CrossOrigin
public class StudyFeedController {
	@Autowired
	private StudyFeedServiceInter service;
	
	@Autowired
	private StudyFeedFilesDaoInter filesdao;
	
	@Autowired
	private StudyGroupServiceInter groupservice;
	
	@Autowired
	private ReplyServiceInter replyservice;
	
	@Autowired
	private StudyServiceInter studyservice;
	
	@GetMapping("/studyfeed/member")
	public Map<String, Object> getStudyMember(@RequestParam int studyfeed_studygroup_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberDto> memberlist = new ArrayList<MemberDto>();
		
	
		
		int membercount = groupservice.selectCountOfStudyGroupPeoples(studyfeed_studygroup_num);
		memberlist = groupservice.selectOfStudyMember(studyfeed_studygroup_num);
		
		String subject=studyservice.selectOfStudyByNum(studyfeed_studygroup_num).getStudy_subject();
		map.put("membercount", membercount);
		map.put("memberlist", memberlist);
		map.put("subject",subject);
		
		return map;
	}
	
	@RequestMapping(value="/studyfeed/add", consumes= {"multipart/form-data"},method = RequestMethod.POST)
	public void insertOfStudyFeed(@ModelAttribute StudyFeedDto dto, MultipartHttpServletRequest request) {
		service.insertOfStudyFeed(dto);
		int maxNum = service.maxNumOfStudyFeed();
		System.out.println("max num=" + maxNum);
		
		//file add
		if(dto.getUploadfile()!=null) {			
			for(MultipartFile f:dto.getUploadfile())
			{
				System.out.println(f.getOriginalFilename());
			}
			filesdao.insertFile(request, dto.getUploadfile(), maxNum);
		}
		System.out.println("�뵾�뱶 異붽�");
	}
	
	@GetMapping("/studyfeed/feedlist")
	public List<StudyFeedDto> selectOfStudyFeedList(
			@RequestParam(name = "studyfeed_studygroup_num") int studyfeed_studygroup_num,
			@RequestParam(name = "offset") int offset) {
		System.out.println(studyfeed_studygroup_num);
		System.out.println(offset);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("studyfeed_studygroup_num", studyfeed_studygroup_num);
		map.put("offset", offset);
		List<StudyFeedDto> list = service.selectOfStudyFeedList(map);
		for(StudyFeedDto dto:list) {
			System.out.println(dto);
		}
		
		return list;
	}
	
	@GetMapping("/studyfeed/filelist")
	public List<String> selectOfStudyFileList(@RequestParam int studyfeedfiles_studyfeed_num) {
		List<String> list = filesdao.selectStudyFeedFile(studyfeedfiles_studyfeed_num);
		
		return list;
	}
	
	@DeleteMapping("/studyfeed/filedelete")
	public void selectStudyFeedFile(@RequestParam String studyfeedfiles_studyfeed_filename) {
		filesdao.deleteFile(studyfeedfiles_studyfeed_filename);
		System.out.println("�뙆�씪 �궘�젣");
	}
	
	@RequestMapping(value="/studyfeed/update", consumes= {"multipart/form-data"},method = RequestMethod.POST)
	public void updateOfStudyFeed(@ModelAttribute StudyFeedDto dto, MultipartHttpServletRequest request) {
		service.updateOfStudyFeed(dto);
		int maxNum = service.maxNumOfStudyFeed();
		System.out.println("max num=" + maxNum);
		
		//file add
		if(dto.getUploadfile()!=null) {			
			for(MultipartFile f:dto.getUploadfile())
			{
				System.out.println(f.getOriginalFilename());
			}
			filesdao.insertFile(request, dto.getUploadfile(), maxNum);
		}
		System.out.println("�뵾�뱶 �닔�젙");
	}
	
	@DeleteMapping("/studyfeed/delete")
	public void deleteOfStudyFeed(@RequestParam int studyfeed_num, HttpServletRequest request)
	{
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		List<String> list = filesdao.selectStudyFeedFile(studyfeed_num);
		System.out.println(list.size());
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i));
				File file=new File(path+"\\"+list.get(i));
				if(file.exists())
					file.delete();
			}
		}
		service.deleteOfStudyFeed(studyfeed_num);
		System.out.println("�궘�젣 �꽦怨�");
	}
}
