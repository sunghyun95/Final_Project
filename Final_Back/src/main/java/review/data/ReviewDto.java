package review.data;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReviewDto {
	private int review_num;
	private int review_member_num;
	private String review_member_name;
	private String review_process;
	private int review_plans;
	private int review_ready;
	private int review_commu;
	private String review_subject;
	private String review_content;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Timestamp review_writeday;
	private String member_profile;
	
	
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public int getReview_member_num() {
		return review_member_num;
	}
	public void setReview_member_num(int review_member_num) {
		this.review_member_num = review_member_num;
	}
	public String getReview_member_name() {
		return review_member_name;
	}
	public void setReview_member_name(String review_member_name) {
		this.review_member_name = review_member_name;
	}
	public String getReview_process() {
		return review_process;
	}
	public void setReview_process(String review_process) {
		this.review_process = review_process;
	}
	public int getReview_plans() {
		return review_plans;
	}
	public void setReview_plans(int review_plans) {
		this.review_plans = review_plans;
	}
	public int getReview_ready() {
		return review_ready;
	}
	public void setReview_ready(int review_ready) {
		this.review_ready = review_ready;
	}
	public int getReview_commu() {
		return review_commu;
	}
	public void setReview_commu(int review_commu) {
		this.review_commu = review_commu;
	}
	public String getReview_subject() {
		return review_subject;
	}
	public void setReview_subject(String review_subject) {
		this.review_subject = review_subject;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public Timestamp getReview_writeday() {
		return review_writeday;
	}
	public void setReview_writeday(Timestamp review_writeday) {
		this.review_writeday = review_writeday;
	}
	
	
	public String getMember_profile() {
		return member_profile;
	}
	public void setMember_profile(String member_profile) {
		this.member_profile = member_profile;
	}
	@Override
	public String toString() {
		return "ReviewDto [review_num=" + review_num + ", review_member_num=" + review_member_num
				+ ", review_member_name=" + review_member_name + ", review_process=" + review_process
				+ ", review_plans=" + review_plans + ", review_ready=" + review_ready + ", review_commu=" + review_commu
				+ ", review_subject=" + review_subject + ", review_content=" + review_content + ", review_writeday="
				+ review_writeday + ", member_profile=" + member_profile + "]";
	}
	

	
	
	
	
}
