package processclass.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import member.data.MemberDto;
import member.data.MemberServiceInter;
import process.data.ProcessDto;
import process.data.ProcessServiceInter;

@RestController
@CrossOrigin
public class ProcessClassController {

	@Autowired
	private ProcessServiceInter processService;
	
	@Autowired
	private ProcessClassServiceInter service;
	
	@Autowired
	private MemberServiceInter memberService;
	
	
	@GetMapping("/processclass/check")
	public int checkProcessClass(@RequestParam int processclass_process_num,
			@RequestParam int processclass_member_num) {
		
		int check = 0;
		
		check = service.checkProcessClass(processclass_process_num,processclass_member_num);
		
	
		return check;
	}
	
	
	
	
	@PostMapping("/processclass/insert")
	public void insertProcessClass(@ModelAttribute ProcessClassDto processclassdto) {
		
		System.out.println(processclassdto);
		System.out.println("react >> processclass/insert");
		
		ProcessDto processdto = processService.selectOneProcess(processclassdto.getProcessclass_process_num());
		
		
		service.updateMemberType(processclassdto.getProcessclass_member_num(),processdto.getProcess_subject());
		service.insertProcessClass(processclassdto);
		
	}
	
	@GetMapping("/processclass/classpage")
	public ProcessDto getClassPage(@RequestParam String member_num)
	{
		ProcessDto processdto = service.getClassPage(member_num);
		
		SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		try {
			Date start = s.parse(processdto.getProcess_startdate());
			Date end = s.parse(processdto.getProcess_enddate());

			cal.setTime(start);
			cal2.setTime(end);
			int count = 0;
			while(cal.compareTo(cal2) != 1) {
				cal.add(Calendar.DATE, 1);
				count+=1;
			}
		
			int count2 = 0;
			String nowday = s.format(new Date());
			Date now = s.parse(nowday);
			Calendar cal3 = Calendar.getInstance();
			cal3.setTime(now);
			
			while(cal.compareTo(cal3) != 1) {
				cal.add(Calendar.DATE, 1);
				count2 += 1;
			}
			
			int avgday = count2/count;
			System.out.println("count="+count+",count2="+count2+",avgday="+avgday);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return processdto;
	}
	
	@GetMapping("/processclass/opennote")
	public ProcessDto openNote(@RequestParam String member_num)
	{
		ProcessDto processdto = service.getClassPage(member_num);
		
		return processdto;
		
	}
	
	
	@GetMapping("/processclass/classList")
	public Map<String,Object> classList(HttpServletRequest request, @RequestParam String process_subject,@RequestParam String member_num)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		
		//어제날짜파일 복사
		Date dDate = new Date();
		dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
		SimpleDateFormat dSdf = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
		String yesterday = dSdf.format(dDate);
		
		File yesterfile = new File("C:\\Users\\ASUS\\Downloads\\"+process_subject+"_"+yesterday+".hwp");

		if(yesterfile.exists()) {
			
			
			
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
			System.out.println("path:"+path);
			
			File folder = new File(path + "/" + member_num);

			if (!folder.exists()) {
				try {
					folder.mkdir(); //폴더 생성합니다.
					System.out.println("폴더가 생성되었습니다.");
				} catch (Exception e) {
					e.getStackTrace();
				}
				
			} else {
				System.out.println("이미 폴더가 생성되어 있습니다.");
			}
			
			try{
			Thread.sleep(2000);
			}catch(Exception e){}
			
			String ins =  "C:\\Users\\ASUS\\Downloads\\"+process_subject+"_"+yesterday+".hwp";
			String outs = path+"\\"+member_num+"\\"+process_subject+"_"+yesterday+".hwp";
			
			 byte[] buf = new byte[1024];
		        FileInputStream fin = null;
		        FileOutputStream fout = null;
		        
		        File file = new File(ins);
		        if(!file.renameTo(new File(outs))){    // renameTo로 이동 실패할 경우
		            
		            buf = new byte[1024];
		            try {
		                fin = new FileInputStream(ins);
		                fout = new FileOutputStream(outs);
		                int read = 0;
		                while((read=fin.read(buf,0,buf.length))!=-1){
		                    fout.write(buf, 0, read);
		                }
		                 
		                fin.close();
		                fout.close();
		                file.delete();                        // 복사 후 파일 삭제
		            } catch (IOException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
			
			
			
		}
		return map;
	}	
	
	@RequestMapping(value="/processclass/classlist",method=RequestMethod.GET)
	public List<String> getClassList(HttpServletRequest request, @RequestParam String process_num)
	{
		System.out.println("react >> getClassList");
		System.out.println("process_num:"+process_num);
		int pnum_length=process_num.length(); // 2
		
		
		List<String> list = new ArrayList<String>();
		File folder = new File("C:\\Users\\ASUS\\Downloads");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  
			  int a = listOfFiles[i].getName().indexOf('_');
			  if(a != -1) {
				  String[] strArr = listOfFiles[i].getName().split("_");
				 if(process_num.equals(strArr[0])) {
					 
					 System.out.println(listOfFiles[i].getName());
					 String filedate = strArr[1].substring(0,strArr[1].indexOf('.'));
					 
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					 
					 try {
						Date fileDate = sdf.parse(filedate);
						
						Date today = new Date();
						String todayString = sdf.format(today);
						today = sdf.parse(todayString);
						
						if(today.compareTo(fileDate) == 1) {
							
							String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
							System.out.println("path:"+path);
							
							File filefolder = new File(path + "/" + process_num);

							if (!filefolder.exists()) {
								try {
									filefolder.mkdir(); //폴더 생성합니다.
									System.out.println("폴더가 생성되었습니다.");
								} catch (Exception e) {
									e.getStackTrace();
								}
								
							} else {
								System.out.println("이미 폴더가 생성되어 있습니다.");
							}
							
							
							String ins =  "C:\\Users\\ASUS\\Downloads\\"+listOfFiles[i].getName();
							String outs = path+"\\"+process_num+"\\"+listOfFiles[i].getName();
							
							 byte[] buf = new byte[1024];
						        FileInputStream fin = null;
						        FileOutputStream fout = null;
						        
						        File file = new File(ins);
						        if(!file.renameTo(new File(outs))){    // renameTo로 이동 실패할 경우
						            
						            buf = new byte[1024];
						            try {
						                fin = new FileInputStream(ins);
						                fout = new FileOutputStream(outs);
						                int read = 0;
						                while((read=fin.read(buf,0,buf.length))!=-1){
						                    fout.write(buf, 0, read);
						                }
						                 
						                fin.close();
						                fout.close();
						                file.delete(); // 복사 후 파일 삭제
						                //System.out.println("제발 성공 제발...");
						                
						            } catch (IOException e) {
						                // TODO Auto-generated catch block
						                e.printStackTrace();
						            }
						        }	
						}
					 }catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
			  }  
		  } 
		}
		
		//목록 불러오기
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile/"+process_num);
		
		File classfolder = new File(path);
		File[] fileList = classfolder.listFiles();

		if(fileList != null)
		{
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isFile()) {
					list.add(fileList[i].getName());
					
					
					System.out.println("File " + fileList[i].getName());
				} 
			}			
		}
		
		
		
		return list;
	}
}
