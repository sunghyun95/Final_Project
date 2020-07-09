package memo.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.data.ProcessDto;
import process.data.ProcessServiceInter;
import upload.util.ManageFileClass;
import upload.util.SpringFileWrite;

@RestController
@CrossOrigin
public class MemoController {

	@Autowired
	private MemoServiceInter service;
	
	
	@GetMapping("/memo/list")
	public List<MemoDto> getMemoList(int process_num)
	{
		System.out.println("react >> memo/list");
		List<MemoDto> memolist = service.getMemoList(process_num);
		
		return memolist;
	}
	
	@RequestMapping(value="/memo/insert",method=RequestMethod.POST)
	public void insertMemo(HttpServletRequest request, @ModelAttribute MemoDto memodto)
	{
		System.out.println("react >> memo/insert");
		System.out.println(memodto);
	
		if(memodto.getMemo_file() != null) {
			
				Date date=new Date();
		      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		      String today=sdf.format(date);
		     
		    String fileName=today+"_"+memodto.getMemo_file().getOriginalFilename();
		    String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		    System.out.println(path);
		    memodto.setMemo_filename(fileName);
			ManageFileClass mfc = new ManageFileClass();
			mfc.insertOneFile(memodto.getMemo_file(), fileName, path);
		}
		
		service.insertMemo(memodto);
	}
	
	@GetMapping("/memo/delete")
	public void deleteMemo(@RequestParam int memo_num)
	{
		System.out.println("react >> memo/delete");
		
		service.deleteMemo(memo_num);
	}
	
	@GetMapping("/memo/updateform")
	public MemoDto updateFormMemo(@RequestParam int memo_num)
	{
		
		System.out.println("react >> updateform");
		MemoDto memodto = service.selectOneMemo(memo_num);
		
		return memodto;
		
	}
	
	
	@GetMapping("/memo/processlist")
	public List<ProcessDto> getProcessList(@RequestParam int member_num)
	{
		System.out.println("memo >> processlist");
		
		List<ProcessDto> list = service.getProcessList(member_num);
		
		
		return list;
	}
	
	@RequestMapping(value="/memo/update",method=RequestMethod.POST)
	public void updateMemo(HttpServletRequest request, @ModelAttribute MemoDto memodto) {
		
		System.out.println("react >> memo/update");
		System.out.println(memodto);
		
		if(memodto.getMemo_file() != null)
		{
			MemoDto memodto2 = service.selectOneMemo(memodto.getMemo_num());
			
			String filename = memodto2.getMemo_filename();
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
			
			ManageFileClass mfc = new ManageFileClass();
			mfc.deleteFile(filename, path);
			
			
			Date date=new Date();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		    String today=sdf.format(date);
		     
		    String fileName=today+"_"+memodto.getMemo_file().getOriginalFilename();
		    System.out.println(path);
		    memodto.setMemo_filename(fileName);
			mfc.insertOneFile(memodto.getMemo_file(), fileName, path);
			
		}
		
		service.updateMemo(memodto);
		
	}
}
