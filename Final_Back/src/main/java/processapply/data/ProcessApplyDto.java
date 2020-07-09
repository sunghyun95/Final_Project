package processapply.data;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProcessApplyDto {
	private int processapply_num;
	private int processapply_member_num;
	private String processapply_member_name;
	private String processapply_process_subject;
	private String processapply_member_phone;
	private String processapply_member_email;
	private String processapply_member_address;
	private String processapply_member_detailaddr;
	private String processapply_member_type;
	private int processapply_process_num;
	private String processapply_applyreason;
	
	private String processapply_acceptreason;
	private String processapply_consulting;
	private Timestamp processapply_writeday;
	
	
	public String getProcessapply_member_type() {
		return processapply_member_type;
	}
	public void setProcessapply_member_type(String processapply_member_type) {
		this.processapply_member_type = processapply_member_type;
	}
	public String getProcessapply_acceptreason() {
		return processapply_acceptreason;
	}
	public void setProcessapply_acceptreason(String processapply_acceptreason) {
		this.processapply_acceptreason = processapply_acceptreason;
	}
	public String getProcessapply_consulting() {
		return processapply_consulting;
	}
	public void setProcessapply_consulting(String processapply_consulting) {
		this.processapply_consulting = processapply_consulting;
	}
	public String getProcessapply_member_phone() {
		return processapply_member_phone;
	}
	public void setProcessapply_member_phone(String processapply_member_phone) {
		this.processapply_member_phone = processapply_member_phone;
	}
	public String getProcessapply_member_email() {
		return processapply_member_email;
	}
	public void setProcessapply_member_email(String processapply_member_email) {
		this.processapply_member_email = processapply_member_email;
	}
	public String getProcessapply_member_address() {
		return processapply_member_address;
	}
	public void setProcessapply_member_address(String processapply_member_address) {
		this.processapply_member_address = processapply_member_address;
	}
	public String getProcessapply_member_detailaddr() {
		return processapply_member_detailaddr;
	}
	public void setProcessapply_member_detailaddr(String processapply_member_detailaddr) {
		this.processapply_member_detailaddr = processapply_member_detailaddr;
	}
	public String getProcessapply_member_name() {
		return processapply_member_name;
	}
	public void setProcessapply_member_name(String processapply_member_name) {
		this.processapply_member_name = processapply_member_name;
	}
	public String getProcessapply_process_subject() {
		return processapply_process_subject;
	}
	public void setProcessapply_process_subject(String processapply_process_subject) {
		this.processapply_process_subject = processapply_process_subject;
	}
	public String getProcessapply_applyreason() {
		return processapply_applyreason;
	}
	public void setProcessapply_applyreason(String processapply_applyreason) {
		this.processapply_applyreason = processapply_applyreason;
	}
	public int getProcessapply_num() {
		return processapply_num;
	}
	public void setProcessapply_num(int processapply_num) {
		this.processapply_num = processapply_num;
	}
	public int getProcessapply_member_num() {
		return processapply_member_num;
	}
	public void setProcessapply_member_num(int processapply_member_num) {
		this.processapply_member_num = processapply_member_num;
	}
	public int getProcessapply_process_num() {
		return processapply_process_num;
	}
	public void setProcessapply_process_num(int processapply_process_num) {
		this.processapply_process_num = processapply_process_num;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	public Timestamp getProcessapply_writeday() {
		return processapply_writeday;
	}
	public void setProcessapply_writeday(Timestamp processapply_writeday) {
		this.processapply_writeday = processapply_writeday;
	}
	@Override
	public String toString() {
		return "ProcessApplyDto [processapply_num=" + processapply_num + ", processapply_member_num="
				+ processapply_member_num + ", processapply_member_name=" + processapply_member_name
				+ ", processapply_process_subject=" + processapply_process_subject + ", processapply_member_phone="
				+ processapply_member_phone + ", processapply_member_email=" + processapply_member_email
				+ ", processapply_member_address=" + processapply_member_address + ", processapply_member_detailaddr="
				+ processapply_member_detailaddr + ", processapply_member_type=" + processapply_member_type
				+ ", processapply_process_num=" + processapply_process_num + ", processapply_applyreason="
				+ processapply_applyreason + ", processapply_acceptreason=" + processapply_acceptreason
				+ ", processapply_consulting=" + processapply_consulting + ", processapply_writeday="
				+ processapply_writeday + "]";
	}

	
	
}
