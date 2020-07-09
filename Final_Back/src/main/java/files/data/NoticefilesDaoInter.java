package files.data;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface NoticefilesDaoInter {
	//파일 추가
	public void insertFile(MultipartHttpServletRequest request, List<MultipartFile> uploadFiles,int noticefiles_notice_num);
	//파일 수정
	public void updateFile(int noticefiles_num);
	//파일 삭제
	public void deleteFile(int noticefiles_num);
	public void deleteFile(String noticefiles_notice_filename);
	//선택 조회
	public List<String> selectnoticeFile(int noticefiles_notice_num);
	
}

