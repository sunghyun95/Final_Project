package review.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements ReviewServiceInter {
	
	@Autowired
	private ReviewDaoInter dao;

	@Override
	public void insertReview(ReviewDto dto) {
		// TODO Auto-generated method stub
		dao.insertReview(dto);
		
	}

	@Override
	public void updateReview(ReviewDto dto) {
		// TODO Auto-generated method stub
		dao.updateReview(dto);
	}

	@Override
	public void deleteReview(int review_num) {
		// TODO Auto-generated method stub
		dao.deleteReview(review_num);
	}

	@Override
	public List<ReviewDto> allOfReview() {
		// TODO Auto-generated method stub
		return dao.allOfReview();
	}

}
