package review.data;

import java.util.List;

public interface ReviewServiceInter {
	public void insertReview(ReviewDto dto);
	public void updateReview(ReviewDto dto);
	public void deleteReview(int review_num);
	public List<ReviewDto> allOfReview();
}
