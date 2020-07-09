package reply.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ReplyController {
	@Autowired
	private ReplyServiceInter service;
	
	@PostMapping("/reply/add")
	public void insertOfReply(@RequestBody ReplyDto dto) {
		service.insertOfReply(dto);
	}
	
	@GetMapping("/reply/list")
	public List<ReplyDto> selectOfReply() {
		List<ReplyDto> list = service.selectOfReply();
		for(ReplyDto dto:list)
			System.out.println(dto);
		
		return list;
	}
	
	@DeleteMapping("/reply/delete")
	public void deleteOfReply(@RequestParam int reply_num) {
		service.deleteOfReply(reply_num);
		System.out.println("댓글 삭제");
	}
}
