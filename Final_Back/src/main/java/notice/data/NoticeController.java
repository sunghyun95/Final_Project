package notice.data;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.runtime.directive.Parse;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.mysql.jdbc.PreparedStatement.ParseInfo;

import files.data.FilesDto;
import files.data.NoticefilesDao;
import files.data.NoticefilesDaoInter;

@RestController
@CrossOrigin
public class NoticeController {
	
	@Autowired
	private NoticeDaoInter ndao;
	
	@Autowired
	private NoticefilesDaoInter fdao;
	
	
	//리스트 출력
	@GetMapping("/notice/noticelist")
	public List<NoticeDto> listNotice(@RequestParam(name = "field", required=false) String field,
			@RequestParam(name = "search",required=false) String search)
	{
		System.out.println("field"+field);
		System.out.println("search"+search);
		List<NoticeDto> list=ndao.allOfNotice(field, search);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getNotice_type()==1)
			{
				list.get(i).setNoti_type("공지");
			}else {
				list.get(i).setNoti_type("일반");
			}
		}
		return list;
	}
	
	//insert
	@RequestMapping(value="/notice/noticeadd", consumes= {"multipart/form-data"},method = RequestMethod.POST)
	public void insertNotice(@ModelAttribute NoticeDto ndto,MultipartHttpServletRequest request)
	{
		
		System.out.println("react>>noticeadd");
		System.out.println(ndto.toString());
		//notice add
		ndao.insertNotice(ndto);
		int maxNum=ndao.maxNumNotice();
		System.out.println("maxnum="+maxNum);
		
		//file add
		if(ndto.getNotice_file()!=null)
		{			
			for(MultipartFile f:ndto.getNotice_file())
			{
				System.out.println(f.getOriginalFilename());
			}
			fdao.insertFile(request, ndto.getNotice_file(), maxNum);
		}
		
		//top
		System.out.println("add notice_type="+ndto.getNotice_type());
		if(ndto.getNotice_type()==1)
			ndao.updateNoticetype(1,maxNum);
		
	}
	
	//선택 조회-공지사항 글
	@GetMapping("/notice/noticedetail")
	public NoticeDto getNotice(@RequestParam int num)
	{
		System.out.println("react>>noticedetail");
		ndao.readCount(num);
		NoticeDto dto=ndao.getNotice(num);
		System.out.println(dto);
		System.out.println(dto.getNotice_type());
		return dto;
	}
	//선택 조회 -파일
	@GetMapping("/notice/noticefile")
	public List<String> getnoticeFile(@RequestParam int num)
	{
		List<String> list=fdao.selectnoticeFile(num);
		return list;
	}
	
	//삭제
	@GetMapping("/notice/noticedelete")
	public void deleteNotice(@RequestParam int num, HttpServletRequest request)
	{
		System.out.println("react>>noticedelete");
		//업로드한 경로
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		//업로드한 파일명들 구하기
		List<String> list=fdao.selectnoticeFile(num);
		System.out.println(list.size());
		//파일 삭제
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
		ndao.deleteNotice(num);
	}
	
	//update
	@RequestMapping(value="/notice/noticeupdate", consumes= {"multipart/form-data"},method = RequestMethod.POST)
	public void updateNotice(@ModelAttribute NoticeDto ndto,
					MultipartHttpServletRequest request)
	{
		System.out.println("react>>noticeupdate");
		System.out.println(ndto.getNotice_type());
		//업로드한 경로
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		if(ndto.getNotice_file()!=null)
		{
			for(MultipartFile f:ndto.getNotice_file())
			{
				System.out.println(f.getOriginalFilename());
			}
			//file add
			fdao.insertFile(request, ndto.getNotice_file(), ndto.getNotice_num());
		}else {
			
		}
		//notice update
		ndao.updateNotice(ndto);
		ndao.updateNoticetype(ndto.getNotice_type(),ndto.getNotice_num());
		System.out.println("notice_delfile="+ndto.getNotice_delfile());
		//delete removed file
		if(ndto.getNotice_delfile()!=null)
		{
			for(int i=0;i<ndto.getNotice_delfile().size();i++)
			{
				System.out.println(ndto.getNotice_delfile().get(i));
				File file=new File(path+"\\"+ndto.getNotice_delfile().get(i));
				if(file.exists())
					file.delete();
				fdao.deleteFile(ndto.getNotice_delfile().get(i));
			}
		}else {
			
		}
		
	}
}
