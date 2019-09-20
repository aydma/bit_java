package service;

import java.util.List;

import vo.ReviewVO;

public interface ReviewService {
	
	List<ReviewVO> reviewList();
	int addReview(ReviewVO vo) throws Exception;
	int deleteReview(int rid);
	int updateReview(ReviewVO vo);
}
