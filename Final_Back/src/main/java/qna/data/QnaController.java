package qna.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import member.data.MemberDaoInter;

@RestController
@CrossOrigin
public class QnaController {
	
	@Autowired
	private QnaDaoInter qdao;
	
	@Autowired
	private MemberDaoInter mdao;
	
	//list
	@GetMapping("/qna/qnalist")
	public List<QnaDto> getlist(@RequestParam(name = "field", required=false) String field,
			@RequestParam(name = "search",required=false) String search)
	{
		//search´Â ÀÌ¸§
		
		System.out.println("react>>QnA list");
		System.out.println("field"+field);
		System.out.println("search"+search);

		List<QnaDto> qlist=qdao.allOfQna(field, search);
		
		return qlist;
	}
	
	//add
	@PostMapping("/qna/qnaadd")
	public void insertQna(@ModelAttribute QnaDto dto)
	{
		System.out.println("react>>QnA add");
		String qna_member_name=mdao.selectOneMember(dto.getQna_member_num()).getMember_name();
		dto.setQna_member_name(qna_member_name);
		qdao.insertQna(dto);
	}
	
	//detail
	@GetMapping("/qna/qnadetail")
	public QnaDto detailQna(@RequestParam int qna_num)
	{
		System.out.println("react>>QnA detail");
		qdao.updateReadCount(qna_num);
		QnaDto qdto=qdao.getData(qna_num);
		return qdto;
	}
	
	//delete
	@GetMapping("/qna/qnadelete")
	public void deleteQna(@RequestParam int qna_num)
	{
		System.out.println("react>>QnA delete");
		qdao.deleteQna(qna_num);
	}
	
	//update
	@PostMapping("/qna/qnaupdate")
	public void updateQna(@ModelAttribute QnaDto dto)
	{
		System.out.println("react>>QnA update");
		System.out.println(dto);
		qdao.updateQna(dto);
	}
}
