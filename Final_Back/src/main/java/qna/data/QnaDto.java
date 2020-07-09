package qna.data;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QnaDto {
	private int qna_num;
	private int qna_member_num;
	private String qna_member_name;
	private String qna_subject;
	private String qna_content;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Timestamp qna_writeday;
	private int qna_readcount;
	private int qna_regroup;
	private int qna_restep;
	private int qna_relevel;
	
	
	public String getQna_member_name() {
		return qna_member_name;
	}
	public void setQna_member_name(String qna_member_name) {
		this.qna_member_name = qna_member_name;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public int getQna_member_num() {
		return qna_member_num;
	}
	public void setQna_member_num(int qna_member_num) {
		this.qna_member_num = qna_member_num;
	}
	public String getQna_subject() {
		return qna_subject;
	}
	public void setQna_subject(String qna_subject) {
		this.qna_subject = qna_subject;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Timestamp getQna_writeday() {
		return qna_writeday;
	}
	public void setQna_writeday(Timestamp qna_writeday) {
		this.qna_writeday = qna_writeday;
	}
	public int getQna_readcount() {
		return qna_readcount;
	}
	public void setQna_readcount(int qna_readcount) {
		this.qna_readcount = qna_readcount;
	}
	public int getQna_regroup() {
		return qna_regroup;
	}
	public void setQna_regroup(int qna_regroup) {
		this.qna_regroup = qna_regroup;
	}
	public int getQna_restep() {
		return qna_restep;
	}
	public void setQna_restep(int qna_restep) {
		this.qna_restep = qna_restep;
	}
	public int getQna_relevel() {
		return qna_relevel;
	}
	public void setQna_relevel(int qna_relevel) {
		this.qna_relevel = qna_relevel;
	}
	@Override
	public String toString() {
		return "QnaDto [qna_num=" + qna_num + ", qna_member_num=" + qna_member_num + ", qna_member_name="
				+ qna_member_name + ", qna_subject=" + qna_subject + ", qna_content=" + qna_content + ", qna_writeday="
				+ qna_writeday + ", qna_readcount=" + qna_readcount + ", qna_regroup=" + qna_regroup + ", qna_restep="
				+ qna_restep + ", qna_relevel=" + qna_relevel + "]";
	}
	
}
