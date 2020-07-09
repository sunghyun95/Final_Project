package memo.data;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MemoDto {
	private int memo_num;
	private int memo_member_num;
	private String memo_subject;
	private String memo_content;
	private int memo_process_num;
	private String memo_filename;
	private MultipartFile memo_file;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Timestamp memo_writeday;
	
	
	
	public String getMemo_subject() {
		return memo_subject;
	}
	public void setMemo_subject(String memo_subject) {
		this.memo_subject = memo_subject;
	}
	public int getMemo_process_num() {
		return memo_process_num;
	}
	public void setMemo_process_num(int memo_process_num) {
		this.memo_process_num = memo_process_num;
	}
	public String getMemo_filename() {
		return memo_filename;
	}
	public void setMemo_filename(String memo_filename) {
		this.memo_filename = memo_filename;
	}
	public MultipartFile getMemo_file() {
		return memo_file;
	}
	public void setMemo_file(MultipartFile memo_file) {
		this.memo_file = memo_file;
	}
	public int getMemo_num() {
		return memo_num;
	}
	public void setMemo_num(int memo_num) {
		this.memo_num = memo_num;
	}
	public int getMemo_member_num() {
		return memo_member_num;
	}
	public void setMemo_member_num(int memo_member_num) {
		this.memo_member_num = memo_member_num;
	}
	public String getMemo_content() {
		return memo_content;
	}
	public void setMemo_content(String memo_content) {
		this.memo_content = memo_content;
	}
	public Timestamp getMemo_writeday() {
		return memo_writeday;
	}
	public void setMemo_writeday(Timestamp memo_writeday) {
		this.memo_writeday = memo_writeday;
	}
	@Override
	public String toString() {
		return "MemoDto [memo_num=" + memo_num + ", memo_member_num=" + memo_member_num + ", memo_subject="
				+ memo_subject + ", memo_content=" + memo_content + ", memo_process_num=" + memo_process_num
				+ ", memo_filename=" + memo_filename + ", memo_file=" + memo_file + ", memo_writeday=" + memo_writeday
				+ "]";
	}
	
	
}
