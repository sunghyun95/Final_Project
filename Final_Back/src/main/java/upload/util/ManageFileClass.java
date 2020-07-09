package upload.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ManageFileClass {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm_ss");
	
	public void fileUpload(String filename,MultipartFile uploadfile, String path ,int num)
	{	
		
		File file = new File(path+"\\"+filename);
		FileOutputStream fos = null;
		try {
			byte[] filedata = uploadfile.getBytes();
			fos=new FileOutputStream(path+"\\"+filename);
			fos.write(filedata);	
			
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
	}
	
	public void insertOneFile(MultipartFile uploadfile,String filename,String path)
	{
		File file = new File(path+"\\"+filename);
		FileOutputStream fos = null;
		try {
			byte[] filedata = uploadfile.getBytes();
			fos=new FileOutputStream(path+"\\"+filename);
			fos.write(filedata);	
			
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
	}
	
	public void deleteFile(String filename, String path)
	{
		File file = new File(path+"\\"+filename);
		if(file.exists())
		{
			file.delete();
		}
		
	}
	
}
	