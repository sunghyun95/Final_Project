package classdata.data;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import classdata.data.ClassDataDto;
import classdata.data.ClassDataService;
import classdatafiles.data.ClassDataFilesDaoInter;
import classdatafiles.data.ClassDataFilesDto;
import files.data.NoticefilesDaoInter;
import member.data.MemberDto;
import notice.data.NoticeDto;
import upload.util.ManageFileClass;

@RestController
@CrossOrigin
public class ClassDataController {
	
	@Autowired
	private ClassDataServiceInter service;
	@Autowired
	private ClassDataFilesDaoInter service2;
	
	
	//목록 출력
	@GetMapping("/classdata/classdatalist")
	public List<ClassDataDto> classdatalist(@RequestParam int process_num)
	{
		System.out.println("react>>classdatalist");
		List<ClassDataDto> list=service.AllClassData(process_num);
		System.out.println(list);
		return list;
	}
	
	//선택 조회-수업자료 글
		@GetMapping("/classdata/classdatadetail")
		public ClassDataDto getClassData(@RequestParam int num)
		{
			System.out.println("react>>classdatadetail");
			ClassDataDto dto=service.selectOne(num);
			System.out.println(dto);
			return dto;
		}
		//선택 조회 -파일
		@GetMapping("/classdatafiles/classdatafilesdetail")
		public List<String> getClassDataFiles(@RequestParam int num)
		{
			System.out.println("react>>classdatadetailfiles");
			List<String> list=service2.selectClassDataFiles(num);
			System.out.println(list);
			return list;
		}
	
	
	
	//추가
	@PostMapping("/classdata/insertclassdata")
	public void insertClassData(@ModelAttribute ClassDataDto dto
			,MultipartHttpServletRequest request)
	{
		System.out.println(dto);
		
		  System.out.println("react>>classdataInsert");
		  service.insertClassData(dto);
		  int maxnum= service.selectMaxNum();
		  System.out.println("1차 성공!!");
		  
 
		  if(dto.getClassdata_files()!=null)
		  {
			  service2.insertClassDataFiles(request, dto.getClassdata_files(), maxnum);
		  }else {
			  System.out.println("if문에러");
		  }
		 
		
	}
	//수정
	@RequestMapping(value="/classdata/classdataupdate",consumes= {"multipart/form-data"},method=RequestMethod.POST)
	public void updateClassData(@ModelAttribute ClassDataDto dto,MultipartHttpServletRequest request)
	{
		System.out.println("react>>classdataupdate");
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		if(dto.getClassdata_files()!=null)
		{
			for(MultipartFile f:dto.getClassdata_files())
			{
				System.out.println(f.getOriginalFilename());
			}
			service2.insertClassDataFiles(request, dto.getClassdata_files(), dto.getClassdata_num());
		}else {
			
		}
		System.out.println(dto);
		service.updateClassData(dto);
		
		if(dto.getClassdata_delfiles()!=null)
		{
			for(int i=0;i<dto.getClassdata_delfiles().size();i++)
			{
				System.out.println(dto.getClassdata_delfiles().get(i));
				File file=new File(path+"\\"+dto.getClassdata_delfiles().get(i));
				if(file.exists())
					file.delete();
				service2.deleteclassDataFiles(dto.getClassdata_delfiles().get(i));
			}
		}else {
			System.out.println(dto.getClassdata_delfiles());
		}
		
	}
	
	//삭제
	@GetMapping("/classdata/classdatadelete")
	public void deleteClassDataFiles(@RequestParam int num, HttpServletRequest request)
	{
		System.out.println("react>>classdatadelete");
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		List<String> list=service2.selectClassDataFiles(num);
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
		service.deleteClassData(num);
	}

}
