package member.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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

import upload.util.SpringFileWrite;
import sms.data.ExampleSend;

@RestController
@CrossOrigin
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private JavaMailSender mailsender;
	
	//濡쒓렇�씤
	@PostMapping("/login/loginck")
	public Map<String,Object> loginck(@RequestParam String member_id, @RequestParam String member_password
			,@RequestParam(required=false) String idsave,HttpSession session)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		if(service.isCheckPass(member_id, member_password))
		{
		
		System.out.println("id:"+member_id+",pw:"+member_password);
		System.out.println("react>>login ");
		
		map.put("member_name",service.selectNameMember(member_id).getMember_name());
		map.put("member_num",service.selectNameMember(member_id).getMember_num());
		map.put("member_type",service.selectNameMember(member_id).getMember_type());
		map.put("success","success");
		return map;
		}
		else
		{
			System.out.println("react>>login fail");
			map.put("fail","fail");
			return map;
		}
	}
	
	//�븘�씠�뵒 以묐났�솗�씤
	@GetMapping("/member/idcheck")
	public int idcheck(@RequestParam String id)
	{
		System.out.println("react >> idcheck"+","+id);
		
		int idcheck = service.checkId2(id);
		System.out.println("idcheck:"+idcheck);
		
		return idcheck;
	}
	
	//�쉶�썝媛��엯 -�쉶�썝 異붽�
	@PostMapping("/member/insert")
	public void insertMember(@RequestParam String member_name,
			@RequestParam String member_id,
			@RequestParam String member_password,
			@RequestParam String member_phone,
			@RequestParam String member_email,
			@RequestParam String member_address,
			@RequestParam String member_detailaddr
			)
	{
		MemberDto memberdto = new MemberDto();
		
		memberdto.setMember_name(member_name);
		memberdto.setMember_id(member_id);
		memberdto.setMember_password(member_password);
		memberdto.setMember_phone(member_phone);
		memberdto.setMember_email(member_email);
		memberdto.setMember_address(member_address);
		memberdto.setMember_detailaddr(member_detailaddr);
		
		System.out.println("react >> insert, "+ memberdto.getMember_id());
		
		service.insertMember(memberdto);
	}
	
	//�븘�씠�뵒 李얘린 �쐞�븳 �젙蹂� �솗�씤
	@PostMapping("/check/checkId")
	public int checkId(@RequestParam String member_name, String member_email, String member_phone)
	{
		int cnt=0;
		System.out.println("react>>checkId");
		System.out.println(member_name);
		System.out.println(member_email);
		System.out.println(member_phone);
		cnt=service.selectCountId(member_name, member_email, member_phone);
		System.out.println(cnt);
		return cnt;
	}
	
	//鍮꾨�踰덊샇 �옱�꽕�젙�쓣 �쐞�븳 �젙蹂� �솗�씤
	@PostMapping("/check/checklogin")
	public int checklogin(@RequestParam String member_name, String member_id, String member_phone)
	{
		int cnt=0;
		System.out.println("react>>checklogin");
		System.out.println(member_name);
		System.out.println(member_id);
		System.out.println(member_phone);
		cnt=service.selectCount(member_name, member_id, member_phone);
		System.out.println(cnt);
		return cnt;
	}
	
	//鍮꾨�踰덊샇 �옱�꽕�젙
	@PostMapping("/check/updatepassword")
	public void updatePassword(@RequestParam String member_id, String member_password)
	{
		System.out.println("react>>updatepassword");
		service.updatePassword(member_id, member_password);
	}
	
	//�씤利앸쾲�샇 臾몄옄 諛쒖넚
	@PostMapping("/check/checknum")
	public String checknum(@RequestParam String member_phone)
	{
		System.out.println("react>>checknum");
		String randomsu="";
		MemberDto cdto=service.admin();
		String adminhp=cdto.getMember_phone();
		
		for(int i=0;i<6;i++)
		{
			int nansu=(int)(Math.random()*10);
			randomsu+=Integer.toString(nansu);
		}
		System.out.println(member_phone);
		
		ExampleSend send=new ExampleSend();
		send.sendSms(randomsu, member_phone, adminhp);
		
		return randomsu;
	}
	
	//�븘�씠�뵒 硫붿씪 諛쒖넚
	@PostMapping("/check/emailId")
	public void emailId(@RequestParam String member_name, String member_email, String member_phone)
	{
		System.out.println("react>>emailId");
		System.out.println(member_name);
		System.out.println(member_email);
		System.out.println(member_phone);
		String member_id=service.selectId(member_name,member_email,member_phone);
		String email_content=member_id.substring(0, member_id.length()-2)+"**";
		String content="회원님의 ID는 "+email_content+"입니다.";
		
		MimeMessage message=mailsender.createMimeMessage();
		try {
		
			message.setSubject("IT Campus 아이디 확인");//硫붿씪�젣紐�
			message.setText(content);//硫붿씪蹂몃Ц
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(member_email));//蹂대궪 硫붿씪二쇱냼
			mailsender.send(message);//硫붿씪�쟾�넚

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("mail error="+e.getMessage());
		}

	}
	
	//硫ㅻ쾭愿�由�-異쒕젰
	@GetMapping("/member/memberlist")
	public List<MemberDto> list(@RequestParam(required=false) String type, @RequestParam(required=false) String field,
			@RequestParam(required=false) String search)
	{
		System.out.println(type);
		System.out.println(field);
		System.out.println(search);
		System.out.println("react>>list");
		
		
		return service.allOfMember(type,field, search);
	}
	
	//硫ㅻ쾭愿�由�-�궘�젣
	@RequestMapping(value="/member/memberdelete",method=RequestMethod.DELETE)
	public void delete(@RequestParam int member_num)
	{
		System.out.println("react>>delete");
		service.deleteMember(member_num);
	}
	
	// mypage member select
	@GetMapping("/mypage/memberselect")
	public MemberDto selectOneMember(@RequestParam(name = "member_num") int member_num) {
		MemberDto memberdto = service.selectOneMember(member_num);
		return memberdto;
	}
	
	// mypage member update
	@PostMapping("/mypage/memberupdate")
	public void updateOfMember(@ModelAttribute MemberDto dto, HttpServletRequest request) {
		MemberDto memberdto = new MemberDto();
		
		if(dto.getProfile_image() != null) {
			MultipartFile file = dto.getProfile_image();
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
			System.out.println("path="+path);
			SpringFileWrite sfw = new SpringFileWrite();
			String filename = sfw.writeProfile(file, path, dto.getMember_email(), dto.getMember_name());
			System.out.println("filename="+filename);
			memberdto.setMember_profile(filename);
		}
		if(dto.getMember_profile() != null)
			memberdto.setMember_profile(dto.getMember_profile());
		
		memberdto.setMember_num(dto.getMember_num());
		memberdto.setMember_phone(dto.getMember_phone());
		memberdto.setMember_email(dto.getMember_email());
		memberdto.setMember_address(dto.getMember_address());
		memberdto.setMember_detailaddr(dto.getMember_detailaddr());
		
		
		service.updateMember(memberdto);
	}
	@PostMapping("/member/memberlistupdate")
	public void updateOfMemberList(@RequestParam int member_num,@RequestParam String member_type)
	{
		System.out.println("react>>memberlist");
		service.updateType(member_num, member_type);
		
	}
}