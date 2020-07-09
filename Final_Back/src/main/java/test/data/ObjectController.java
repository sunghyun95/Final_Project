package test.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@CrossOrigin
@RestController
public class ObjectController {
	
	@GetMapping("/word/save")
	public ModelAndView saveWord(@RequestParam String content,@RequestParam String process_num)
	{
		System.out.println("react >> word");

		//content=content.replaceAll("&", "<");
		//content=content.replaceAll("*", ">");

		
		/*String str = new String(content);
		
		String str2 = "";
		String[] splstr = str.split(",");
		for(int i=0; i<splstr.length; i++)
		{
			int a = Integer.parseInt(splstr[i]);
			
			char as = (char)a;
			
			str2 += Character.toString(as);
		}
		
		classcontent = str2;
		System.out.println("str2:"+str2);
		*/
		//   try {
		//	str2 = URLEncoder.encode(str2, "UTF-8");
		//} catch (UnsupportedEncodingException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		ModelAndView model = new ModelAndView();
		model.addObject("content", content);
		model.addObject("process_num", process_num);
		
		model.setViewName("/views/saveWordAction");
		
		return model;
	}
	@GetMapping("/word/save2")
	public ModelAndView saveWord2(@RequestParam String content,@RequestParam String process_num)
	{
		System.out.println("react >> word2");
		/*
		 * System.out.println("save2메서드 content:"+content);
		 * System.out.println("save2메서드 content:"+member_num);
		 */
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("process_num",process_num);
		model.addObject("content",content);
		model.setViewName("/views/saveWord");
		
		return model;
	}	
}
