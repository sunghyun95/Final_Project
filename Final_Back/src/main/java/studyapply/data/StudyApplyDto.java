package studyapply.data;

import java.sql.Timestamp;

public class StudyApplyDto {
	private int studyapply_num;
	private int studyapply_member_num;
	private int studyapply_study_num;
	private String member_name;
	private String member_phone;
	private String studyapply_mylevel;
	private String studyapply_comment;
	private Timestamp studyapply_writeday;
	
	public int getStudyapply_num() {
		return studyapply_num;
	}
	public void setStudyapply_num(int studyapply_num) {
		this.studyapply_num = studyapply_num;
	}
	public int getStudyapply_member_num() {
		return studyapply_member_num;
	}
	public void setStudyapply_member_num(int studyapply_member_num) {
		this.studyapply_member_num = studyapply_member_num;
	}
	public int getStudyapply_study_num() {
		return studyapply_study_num;
	}
	public void setStudyapply_study_num(int studyapply_study_num) {
		this.studyapply_study_num = studyapply_study_num;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getStudyapply_mylevel() {
		return studyapply_mylevel;
	}
	public void setStudyapply_mylevel(String studyapply_mylevel) {
		this.studyapply_mylevel = studyapply_mylevel;
	}
	public String getStudyapply_comment() {
		return studyapply_comment;
	}
	public void setStudyapply_comment(String studyapply_comment) {
		this.studyapply_comment = studyapply_comment;
	}
	public Timestamp getStudyapply_writeday() {
		return studyapply_writeday;
	}
	public void setStudyapply_writeday(Timestamp studyapply_writeday) {
		this.studyapply_writeday = studyapply_writeday;
	}
	
	@Override
	public String toString() {
		return "StudyApplyDto [studyapply_num=" + studyapply_num + ", studyapply_member_num=" + studyapply_member_num
				+ ", studyapply_study_num=" + studyapply_study_num + ", member_name=" + member_name + ", member_phone="
				+ member_phone + ", studyapply_mylevel=" + studyapply_mylevel + ", studyapply_comment="
				+ studyapply_comment + ", studyapply_writeday=" + studyapply_writeday + "]";
	}
	
}
