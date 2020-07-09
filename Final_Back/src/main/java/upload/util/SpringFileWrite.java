package upload.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

//占쏙옙占싸듸옙占쏙옙 占싱뱄옙占쏙옙占쏙옙 특占쏙옙 占쏙옙恝占� 占쏙옙占쏙옙
public class SpringFileWrite {
   private FileOutputStream fos;
   
   public String writeFile(MultipartFile file,String path)
   {
      
      Date date=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
      String today=sdf.format(date);
      //占쏙옙占싹몌옙
      String fileName=today+"_"+file.getOriginalFilename();
      try {
         byte []fileData=file.getBytes();
         fos=new FileOutputStream(path+"\\"+fileName);
         fos.write(fileData);
         
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         try {
            fos.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return fileName;
   }
   
   public String writeProfile(MultipartFile file, String path, String email, String name) {
	   String emailid = StringUtils.substringBefore(email, "@");
	   String fileName = emailid + "_" + name + "." + FilenameUtils.getExtension(file.getOriginalFilename());
	   
	   try {
		   byte []fileData = file.getBytes();
		   fos = new FileOutputStream(path + "\\" + fileName);
		   fos.write(fileData);
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   } finally {
		   try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   return fileName;
   }
}