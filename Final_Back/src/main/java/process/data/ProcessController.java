package process.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import books.data.BooksDto;
import books.data.BooksServiceInter;
import files.data.FilesDto;
import files.data.ProcessFilesDto;
import member.data.MemberDto;
import member.data.MemberServiceInter;
import processclass.data.ProcessClassDto;
import processclass.data.ProcessClassServiceInter;
import upload.util.ManageFileClass;
import upload.util.ReadBooksList;
import upload.util.WebCrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


@RestController
@CrossOrigin
public class ProcessController {
	
	@Autowired
	private ProcessServiceInter service;
	
	@Autowired
	private BooksServiceInter booksService;
	
	@Autowired
	private ProcessClassServiceInter processClassService;
	
	@Autowired
	private MemberServiceInter memberService;
	
	
	@GetMapping("/process/searchTeacher")
	public List<MemberDto> searchTeacher()
	{
	
		System.out.println("react >> searchTeacher");
		
		return service.searchTeacher();
	}
	
	@GetMapping("/process/getBooksList")
	public List<BooksDto> getBooksList()
	{
		System.out.println("react >> getBooksList");
		List<List<String>> bookslist = new ReadBooksList().readBooks();
		
		List<BooksDto> list = new ArrayList<BooksDto>();
		
		for(List<String> s : bookslist)
		{
			BooksDto dto = new BooksDto();
			for(int i=0; i<s.size(); i++)
			{
				dto.setBooks_brand(s.get(1));
				dto.setBooks_name(s.get(4));
				dto.setBooks_writer(s.get(5));
				
			}
			list.add(dto);
		}
		
		
		return list;
	}
		
	@RequestMapping(value="/process/insert",method=RequestMethod.POST)
	public int insertProcess(@ModelAttribute ProcessDto processdto,HttpServletRequest request)
	{
		
		System.out.println("react >> processInsert");
		System.out.println("react >> dto");
		System.out.println(processdto);
		String teachernum = processdto.getProcess_teacher();
		
		MemberDto teacher = service.selectOneTeacher(teachernum);
		
		processdto.setProcess_teachername(teacher.getMember_name());
		
		service.insertProcess(processdto);
		System.out.println("insert 성공");
		int maxnum = service.selectProcessMaxnum();	
		
		ProcessClassDto processclassdto = new ProcessClassDto();
		//강사회원 클래스에 추가
		processclassdto.setProcessclass_process_num(maxnum);
		processclassdto.setProcessclass_member_num(Integer.parseInt(teachernum));
		processclassdto.setProcessclass_member_type(teacher.getMember_type());
		processClassService.insertProcessClass(processclassdto);
		
		//매니져 회원 클래스에 추가
		processclassdto.setProcessclass_member_num(processdto.getProcess_member_num());
		MemberDto manager = memberService.selectOneMember(processdto.getProcess_member_num());
		processclassdto.setProcessclass_member_type(manager.getMember_type());
		processClassService.insertProcessClass(processclassdto);
		
		
		
		if(processdto.getProcess_uploadfiles()!=null) {			
			ManageFileClass mfc = new ManageFileClass();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
			System.out.println("path:"+path);
			String nowdate = sdf.format(new Date());
			
			
			for(MultipartFile uploadfile : processdto.getProcess_uploadfiles())
			{
				String fileName= nowdate+"_"+maxnum+"_"+uploadfile.getOriginalFilename();
				mfc.fileUpload(fileName,uploadfile, path, maxnum);
				ProcessFilesDto processfilesdto = new ProcessFilesDto();
				
				processfilesdto.setProcessfiles_process_num(maxnum);
				processfilesdto.setProcessfiles_process_filename(fileName);
				service.insertProcessFiles(processfilesdto);
			}
		}
			
		return maxnum;
	}

	@RequestMapping(value="/process/list",method=RequestMethod.POST)
	public List<ProcessListDto> getAllProcess(){
		System.out.println("react >> getAllProcess");
		
		return service.getAllProcess();
		
	}
	
	@RequestMapping(value="/process/mainlist",method=RequestMethod.GET)
	public Map<String,List<ProcessListDto>> getMainAllProcess(){
		System.out.println("react >> getAllMainProcess");
	
		Map<String,List<ProcessListDto>> map = new HashMap<String,List<ProcessListDto>>();
		
		map.put("all",service.getAllMainProcess(""));
		map.put("bigdata",service.getAllMainProcess("빅데이터"));
		map.put("cloud",service.getAllMainProcess("클라우드"));
		map.put("ai",service.getAllMainProcess("인공지능"));
		
		return map;
		
	}
	@RequestMapping(value="/process/detail",method=RequestMethod.GET)
	public Map<String,Object> selectOneProcess(@RequestParam int process_num)
	{
		System.out.println("react >> process/detail");
		Map<String,Object> process = new HashMap<String,Object>();
		
		ProcessDto processdto = service.selectOneProcess(process_num);
		List<ProcessFilesDto> processfiles = service.processFilesList(process_num);
		List<BooksDto> books = 
				booksService.processBooks(process_num);
		
		System.out.println("processdto_subject : "+processdto.getProcess_subject() );
		System.out.println("files size : " + processfiles.size());
		System.out.println("books size : " + books.size());
		
		process.put("processdto",processdto);
		process.put("processfiles",processfiles);
		process.put("books",books);
		
		return process;
	}
	
	@RequestMapping(value="/process/getImages",method=RequestMethod.GET)
	public List<String> getBooksImages(int num)
	{
		List<BooksDto> s = booksService.processBooks(num);
		
		WebCrawling craw = new WebCrawling();
	
		List<String> booksImages = craw.booksImageCrawling(s);
		
		if(booksImages.size() > 0) {
			return booksImages;		
		}
		
		return null;
	}
	
	//채용공고 크롤링 메서드
	@GetMapping("/process/hirelist")
	public Map<String,List<String>> getHireList(String searchtxt){
		
		Map<String,List<String>> hirelist = new HashMap<String,List<String>>();
		
		WebCrawling craw = new WebCrawling();
		
		hirelist = craw.getHireList(searchtxt);
		
		
		return hirelist;
	}
	
	@GetMapping("process/delete")
	public void deleteProcess(HttpServletRequest request, int process_num)
	{
		System.out.println("react >> delete");
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
				
		List<ProcessFilesDto> processfilesdto = service.processFilesList(process_num);
		ManageFileClass mfc = new ManageFileClass();
		
		if(processfilesdto != null)
		{
			for(ProcessFilesDto dto : processfilesdto)
			{
				String filename = dto.getProcessfiles_process_filename();
				mfc.deleteFile(filename, path);
			}
		}
		
		List<BooksDto> booksdto = booksService.processBooks(process_num);
		
		
		
		booksService.deleteBooks(process_num);
		service.deleteProcessFiles(process_num);
		service.deleteProcess(process_num);
	}
	
	@GetMapping("/process/updateform")
	public Map<String,Object> updateProcessForm(@RequestParam int process_num)
	{
		System.out.println("react >> process/updateProcessForm");
		Map<String,Object> process = new HashMap<String,Object>();
		
		ProcessDto processdto = service.selectOneProcess(process_num);
		List<ProcessFilesDto> processfiles = service.processFilesList(process_num);
		List<BooksDto> books = booksService.processBooks(process_num);
		
		
		process.put("processdto",processdto);
		process.put("processfiles",processfiles);
		process.put("books",books);
		
		return process;
	}
	
	@GetMapping("/process/deletefiles")
	public void deletefiles(HttpServletRequest request,@RequestParam List<String> deleteBooks,@RequestParam List<String> deleteImage)
	{
		System.out.println("react >> deleteBooks");
		System.out.println("books size:"+deleteBooks.size());
		System.out.println("images size :"+deleteImage.size());
		
		if(deleteBooks.size() > 0)
		{
			for(String deleteBooknum : deleteBooks)
			{
				booksService.deleteBooks(Integer.parseInt(deleteBooknum));
			}			
		}
		
		if(deleteImage.size() > 0)
		{
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfiles");
			ManageFileClass mfc = new ManageFileClass();
			for(String image : deleteImage)
			{
				ProcessFilesDto processfilesdto = service.getProcessImage(Integer.parseInt(image));
				mfc.deleteFile(processfilesdto.getProcessfiles_process_filename(), path);
				
				service.deleteImage(Integer.parseInt(image));
			}
		}
		
	}
	
	@PostMapping("/process/update")
	public void updateProcess(@ModelAttribute ProcessDto processdto, HttpServletRequest request)
	{
		System.out.println("react >> update");
		
		//강사 이름 수정
		String teachernum = processdto.getProcess_teacher();
		MemberDto teacher = service.selectOneTeacher(teachernum);
		processdto.setProcess_teachername(teacher.getMember_name());
		ProcessClassDto processclassdto = new ProcessClassDto();
		processclassdto.setProcessclass_process_num(processdto.getProcess_num());
		processclassdto.setProcessclass_member_num(Integer.parseInt(teachernum));
		
		processClassService.updateTeacherNum(processclassdto);
		
		//파일이 추가된게 있다면 추가,테이블에도 추가
		if(processdto.getProcess_uploadfiles() != null)
		{
			ManageFileClass mfc = new ManageFileClass();
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
			for(MultipartFile file : processdto.getProcess_uploadfiles())
			{
				String filename = file.getOriginalFilename();
				mfc.fileUpload(filename, file, path, processdto.getProcess_num());
				
				ProcessFilesDto processfilesdto = new ProcessFilesDto();
				
				processfilesdto.setProcessfiles_process_num(processdto.getProcess_num());
				processfilesdto.setProcessfiles_process_filename(filename);
				service.insertProcessFiles(processfilesdto);
			}
		}
		
		
		
		
		service.updateProcess(processdto);
		
	}
	
	@GetMapping("/process/managerlist")
	public List<ProcessDto> managerlist(@RequestParam int member_num)
	{
		System.out.println("react >> managerlist");
		return service.managerlist(member_num);	
	}
}
