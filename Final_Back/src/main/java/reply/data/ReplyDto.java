package reply.data;

import java.sql.Timestamp;

public class ReplyDto {
	private int reply_num;
	private int reply_member_num;
	private int reply_studyfeed_num;
	private String reply_content;
	private Timestamp reply_writeday;
	private String member_name;
	private String member_profile;
	
	public int getReply_num() {
		return reply_num;
	}
	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}
	public int getReply_member_num() {
		return reply_member_num;
	}
	public void setReply_member_num(int reply_member_num) {
		this.reply_member_num = reply_member_num;
	}
	public int getReply_studyfeed_num() {
		return reply_studyfeed_num;
	}
	public void setReply_studyfeed_num(int reply_studyfeed_num) {
		this.reply_studyfeed_num = reply_studyfeed_num;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Timestamp getReply_writeday() {
		return reply_writeday;
	}
	public void setReply_writeday(Timestamp reply_writeday) {
		this.reply_writeday = reply_writeday;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_profile() {
		return member_profile;
	}
	public void setMember_profile(String member_profile) {
		this.member_profile = member_profile;
	}
	
	@Override
	public String toString() {
		return "ReplyDto [reply_num=" + reply_num + ", reply_member_num=" + reply_member_num + ", reply_studyfeed_num="
				+ reply_studyfeed_num + ", reply_content=" + reply_content + ", reply_writeday=" + reply_writeday
				+ ", member_name=" + member_name + ", member_profile=" + member_profile + "]";
	}
		
}
