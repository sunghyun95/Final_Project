package review.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDao extends SqlSessionDaoSupport implements ReviewDaoInter{

	@Override
	public void insertReview(ReviewDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfReview",dto);
	}

	@Override
	public void updateReview(ReviewDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfReview",dto);
	}

	@Override
	public void deleteReview(int review_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfReview", review_num);
	}

	@Override
	public List<ReviewDto> allOfReview() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectAllOfReview");
	}
	
	
}
