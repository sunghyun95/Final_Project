package studyfeed.data;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class StudyFeedDto {
	private int studyfeed_num;
	private int studyfeed_studygroup_num;
	private int studyfeed_member_num;
	private String studyfeed_content;
	private Timestamp studyfeed_writeday;
	private List<MultipartFile> uploadfile;
	private List<String> studyfeedfiles_studyfeed_filename;
	private String member_name;
	private String member_profile;
	
	public int getStudyfeed_num() {
		return studyfeed_num;
	}
	public void setStudyfeed_num(int studyfeed_num) {
		this.studyfeed_num = studyfeed_num;
	}
	public int getStudyfeed_studygroup_num() {
		return studyfeed_studygroup_num;
	}
	public void setStudyfeed_studygroup_num(int studyfeed_studygroup_num) {
		this.studyfeed_studygroup_num = studyfeed_studygroup_num;
	}
	public int getStudyfeed_member_num() {
		return studyfeed_member_num;
	}
	public void setStudyfeed_member_num(int studyfeed_member_num) {
		this.studyfeed_member_num = studyfeed_member_num;
	}
	public String getStudyfeed_content() {
		return studyfeed_content;
	}
	public void setStudyfeed_content(String studyfeed_content) {
		this.studyfeed_content = studyfeed_content;
	}
	public Timestamp getStudyfeed_writeday() {
		return studyfeed_writeday;
	}
	public void setStudyfeed_writeday(Timestamp studyfeed_writeday) {
		this.studyfeed_writeday = studyfeed_writeday;
	}
	public List<MultipartFile> getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(List<MultipartFile> uploadfile) {
		this.uploadfile = uploadfile;
	}
	public List<String> getStudyfeedfiles_studyfeed_filename() {
		return studyfeedfiles_studyfeed_filename;
	}
	public void setStudyfeedfiles_studyfeed_filename(List<String> studyfeedfiles_studyfeed_filename) {
		this.studyfeedfiles_studyfeed_filename = studyfeedfiles_studyfeed_filename;
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
		return "StudyFeedDto [studyfeed_num=" + studyfeed_num + ", studyfeed_studygroup_num=" + studyfeed_studygroup_num
				+ ", studyfeed_member_num=" + studyfeed_member_num + ", studyfeed_content=" + studyfeed_content
				+ ", studyfeed_writeday=" + studyfeed_writeday + ", uploadfile=" + uploadfile
				+ ", studyfeedfiles_studyfeed_filename=" + studyfeedfiles_studyfeed_filename + ", member_name="
				+ member_name + ", member_profile=" + member_profile + "]";
	}
	
}
