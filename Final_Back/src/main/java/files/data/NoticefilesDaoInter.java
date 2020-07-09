package files.data;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface NoticefilesDaoInter {
	//���� �߰�
	public void insertFile(MultipartHttpServletRequest request, List<MultipartFile> uploadFiles,int noticefiles_notice_num);
	//���� ����
	public void updateFile(int noticefiles_num);
	//���� ����
	public void deleteFile(int noticefiles_num);
	public void deleteFile(String noticefiles_notice_filename);
	//���� ��ȸ
	public List<String> selectnoticeFile(int noticefiles_notice_num);
	
}

