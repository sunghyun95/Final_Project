package files.data;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface StudyFeedFilesDaoInter {
	public void insertFile(MultipartHttpServletRequest request, List<MultipartFile> uploadFiles, int studyfeedfiles_studyfeed_num);
	public void deleteFile(String studyfeedfiles_studyfeed_filename);
	public List<String> selectStudyFeedFile(int studyfeedfiles_studyfeed_num);
}
