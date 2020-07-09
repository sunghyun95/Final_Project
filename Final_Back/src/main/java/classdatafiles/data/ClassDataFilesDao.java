package classdatafiles.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import upload.util.SpringFileWrite;

@Repository
public class ClassDataFilesDao extends SqlSessionDaoSupport implements ClassDataFilesDaoInter {

	@Override
	public void insertClassDataFiles(MultipartHttpServletRequest request, List<MultipartFile> uploadFiles, int num) {
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
						System.out.println(num);
						Map<String, Object> map=new HashMap<String, Object>();
						map.put("classdatafiles_classdata_num", num);
						map.put("classdatafiles_classdata_filename", filename);
						System.out.println(map);
						getSqlSession().insert("insertOfClassDataFiles", map);
					
					}else {
						
					}
				}
	}

	@Override
	public void updateClassDataFiles(int classdatafiles_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfClassDataFiles",classdatafiles_num);
	}

	@Override
	public void deleteclassDataFiles(String classdatafiles_classdata_filename) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfClassDataFiles",classdatafiles_classdata_filename);
		
	}

	@Override
	public List<String> selectClassDataFiles(int classdatafiles_classdata_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOneOfClassDataFiles",classdatafiles_classdata_num);
	}

	

}
