package processapply.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import processclass.data.ProcessClassDto;

@RestController
@CrossOrigin
public class ProcessApplyController {

	@Autowired
	private ProcessApplyServiceInter service;

	@PostMapping("/processapply/insert")
	public void insertProcessApply(@ModelAttribute ProcessApplyDto processapplydto)
	{
		System.out.println("react >> insertProcessApply");
		
		System.out.println(processapplydto);
		
		service.insertProcessApply(processapplydto);
	}
	
	@GetMapping("/processapply/check")
	public int selectProcessApply(int member_num) {
		
		System.out.println("react >> selectProcessApply");
		
		ProcessApplyDto applydto = service.selectProcessApply(member_num);
		int count = 0;
		if(applydto!=null)
			count = 1;
		
		return count;
		
	}
	
	
	@GetMapping("/processapply/list")
	public List<ProcessApplyDto> listProcessApply(int member_num)
	{
		System.out.println("react >> listProcessApply");
		List<ProcessApplyDto> applylist = service.listProcessApply(member_num);
		
		return applylist;
		
	}
	
	@PostMapping("/processapply/accept")
	public void upldateProcessApplyAccept(@ModelAttribute ProcessApplyDto processapplydto) {
		
		System.out.println("react >> accept");
		
		System.out.println(processapplydto);
		
		
		service.upldateProcessApplyAccept(processapplydto);
		
	}
}
