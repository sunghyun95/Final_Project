package review.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import member.data.MemberDto;
import member.data.MemberServiceInter;

@RestController
@CrossOrigin
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	//¸®ºä ¸ñ·Ï Ãâ·Â
	@GetMapping("/review/reviewlist")
	public List<ReviewDto> reviewList()
	{
		System.out.println("react>>list");
		
		return service.allOfReview();
	}
	
	//¸®ºä Ãß°¡
	@RequestMapping(value="/review/addreview",method=RequestMethod.POST)
	public void addReview(@ModelAttribute ReviewDto dto)
	{
		System.out.println("react>>reviewadd");
		service.insertReview(dto);
	}
	
	@RequestMapping(value="/review/updatereview",method=RequestMethod.POST)
	public void updateReview(@ModelAttribute ReviewDto dto)
	{
		System.out.println("react>>reviewupdate");
		System.out.println(dto);
		service.updateReview(dto);
		
	}
	
	
	//¸®ºä »èÁ¦
	@GetMapping("/review/deletereview")
	public void deleteReview(@RequestParam int review_num)
	{
		System.out.println("react>>reviewdelete");
		service.deleteReview(review_num);
	}

}
