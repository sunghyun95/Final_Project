package studyfeed.data;

import java.util.HashMap;
import java.util.List;

public interface StudyFeedServiceInter {
	public void insertOfStudyFeed(StudyFeedDto dto);
	public int maxNumOfStudyFeed();
	public List<StudyFeedDto> selectOfStudyFeedList(HashMap<String, Integer> map);
	public void updateOfStudyFeed(StudyFeedDto dto);
	public void deleteOfStudyFeed(int studyfeed_num);
}
