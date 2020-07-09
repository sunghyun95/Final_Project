package studyfeed.data;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StudyFeedDao extends SqlSessionDaoSupport implements StudyFeedDaoInter {
	@Override
	public void insertOfStudyFeed(StudyFeedDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfStudyFeed", dto);
	}
	@Override
	public int maxNumOfStudyFeed() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("maxNumOfStudyFeed");
	}
	@Override
	public List<StudyFeedDto> selectOfStudyFeedList(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectOfStudyFeedList", map);
	}
	@Override
	public void updateOfStudyFeed(StudyFeedDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfStudyFeed", dto);
	}
	@Override
	public void deleteOfStudyFeed(int studyfeed_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfStudyFeed", studyfeed_num);
	}
}
