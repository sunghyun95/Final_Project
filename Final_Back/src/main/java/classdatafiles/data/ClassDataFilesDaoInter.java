package classdatafiles.data;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ClassDataFilesDaoInter {
	
	public void insertClassDataFiles(MultipartHttpServletRequest request, List<MultipartFile> uploadFiles,int num);
	public void updateClassDataFiles(int classdatafiles_num);
	public void deleteclassDataFiles(String classdatafiles_classdata_filename);
	public List<String> selectClassDataFiles(int classdatafiles_classdata_num);

}
