package process.data;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProcessListDto {

	private String process_num;
	private String process_type;
	private String member_name;
	private String process_subject;
	private String process_intr;
	private String process_startdate;
	private String process_enddate;
	private int process_boardtype;
	private String process_status;
	private String process_teachername;
	private String process_writer;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp process_writeday;
	public String getProcess_num() {
		return process_num;
	}
	public void setProcess_num(String process_num) {
		this.process_num = process_num;
	}
	public String getProcess_type() {
		return process_type;
	}
	public void setProcess_type(String process_type) {
		this.process_type = process_type;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getProcess_subject() {
		return process_subject;
	}
	public void setProcess_subject(String process_subject) {
		this.process_subject = process_subject;
	}
	public String getProcess_intr() {
		return process_intr;
	}
	public void setProcess_intr(String process_intr) {
		this.process_intr = process_intr;
	}
	public String getProcess_startdate() {
		return process_startdate;
	}
	public void setProcess_startdate(String process_startdate) {
		this.process_startdate = process_startdate;
	}
	public String getProcess_enddate() {
		return process_enddate;
	}
	public void setProcess_enddate(String process_enddate) {
		this.process_enddate = process_enddate;
	}
	public int getProcess_boardtype() {
		return process_boardtype;
	}
	public void setProcess_boardtype(int process_boardtype) {
		this.process_boardtype = process_boardtype;
	}
	public String getProcess_status() {
		return process_status;
	}
	public void setProcess_status(String process_status) {
		this.process_status = process_status;
	}
	
	public String getProcess_teachername() {
		return process_teachername;
	}
	public void setProcess_teachername(String process_teachername) {
		this.process_teachername = process_teachername;
	}
	public String getProcess_writer() {
		return process_writer;
	}
	public void setProcess_writer(String process_writer) {
		this.process_writer = process_writer;
	}
	public Timestamp getProcess_writeday() {
		return process_writeday;
	}
	public void setProcess_writeday(Timestamp process_writeday) {
		this.process_writeday = process_writeday;
	}
	
}
