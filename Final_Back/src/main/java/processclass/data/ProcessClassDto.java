package processclass.data;

public class ProcessClassDto {
	private int processclass_num;
	private int processclass_process_num;
	private int processclass_member_num;
	private String processclass_member_type;
	
	public String getProcessclass_member_type() {
		return processclass_member_type;
	}
	public void setProcessclass_member_type(String processclass_member_type) {
		this.processclass_member_type = processclass_member_type;
	}
	public int getProcessclass_num() {
		return processclass_num;
	}
	public void setProcessclass_num(int processclass_num) {
		this.processclass_num = processclass_num;
	}
	public int getProcessclass_process_num() {
		return processclass_process_num;
	}
	public void setProcessclass_process_num(int processclass_process_num) {
		this.processclass_process_num = processclass_process_num;
	}
	public int getProcessclass_member_num() {
		return processclass_member_num;
	}
	public void setProcessclass_member_num(int processclass_member_num) {
		this.processclass_member_num = processclass_member_num;
	}
	@Override
	public String toString() {
		return "ProcessClassDto [processclass_num=" + processclass_num + ", processclass_process_num="
				+ processclass_process_num + ", processclass_member_num=" + processclass_member_num
				+ ", processclass_member_type=" + processclass_member_type + "]";
	}
	
	
	
}
