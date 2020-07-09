package files.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import upload.util.SpringFileWrite;

@Repository
public class StudyFeedFilesDao extends SqlSessionDaoSupport implements StudyFeedFilesDaoInter {
	@Override
	public void insertFile(MultipartHttpServletRequest request, List<MultipartFile> uploadFiles,
			int studyfeedfiles_studyfeed_num) {
		// TODO Auto-generated method stub
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadfile");
		System.out.println("path="+path);
		SpringFileWrite sfw = new SpringFileWrite();
		for(MultipartFile f:uploadFiles)
		{
			if(!f.getOriginalFilename().equals(""))
			{
				String filename=sfw.writeFile(f, path);
				System.out.println(filename);
				System.out.println(studyfeedfiles_studyfeed_num);
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("studyfeedfiles_studyfeed_num", studyfeedfiles_studyfeed_num);
				map.put("studyfeedfiles_studyfeed_filename", filename);
				System.out.println(map);
				getSqlSession().insert("insertOfStudyFeedfiles", map);
			}
		}
	}
	@Override
	public void deleteFile(String studyfeedfiles_studyfeed_filename) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfStudyFeedfile", studyfeedfiles_studyfeed_filename);
	}
	@Override
	public List<String> selectStudyFeedFile(int studyfeedfiles_studyfeed_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOneOfStudyFeedfiles", studyfeedfiles_studyfeed_num);
	}
}
