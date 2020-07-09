package files.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import upload.util.SpringFileWrite;

@Repository
public class NoticefilesDao extends SqlSessionDaoSupport implements NoticefilesDaoInter {
	
	@Override
	public void insertFile(MultipartHttpServletRequest request, List<MultipartFile> uploadFiles,int noticefiles_notice_num) {
		// TODO Auto-generated method stub
		//업로드 경로
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		System.out.println("path="+path);
		//업로드 할 파일명들 구하기
		SpringFileWrite sfw=new SpringFileWrite();
		for(MultipartFile f:uploadFiles)
		{
			//실제 업로드한 경우에만 db에 저장하기
			if(!f.getOriginalFilename().equals(""))
			{
				String filename=sfw.writeFile(f, path);
				System.out.println(filename);
				System.out.println(noticefiles_notice_num);
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("noticefiles_notice_num", noticefiles_notice_num);
				map.put("noticefiles_notice_filename", filename);
				System.out.println(map);
				getSqlSession().insert("insertOfNoticefiles", map);
			
			}else {
				
			}
		}
	}

	@Override
	public void updateFile(int files_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfNoticefiles", files_num);
	}

	@Override
	public void deleteFile(int files_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfNoticefiles",files_num);
	}

	@Override
	public List<String> selectnoticeFile(int noticefiles_notice_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOneofNoticefiles", noticefiles_notice_num);
	}

	@Override
	public void deleteFile(String noticefiles_notice_filename) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfNoticefile",noticefiles_notice_filename);
	}

}
