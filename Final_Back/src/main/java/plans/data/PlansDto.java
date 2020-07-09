package plans.data;

import java.sql.Timestamp;

public class PlansDto {
	private int plans_num;
	private int plans_member_num;
	private String plans_subject;
	private String plans_content;
	private String plans_startdate;
	private String plans_enddate;
	private Timestamp plans_writeday;
	
	public int getPlans_num() {
		return plans_num;
	}
	public void setPlans_num(int plans_num) {
		this.plans_num = plans_num;
	}
	public int getPlans_member_num() {
		return plans_member_num;
	}
	public void setPlans_member_num(int plans_member_num) {
		this.plans_member_num = plans_member_num;
	}
	public String getPlans_subject() {
		return plans_subject;
	}
	public void setPlans_subject(String plans_subject) {
		this.plans_subject = plans_subject;
	}
	public String getPlans_content() {
		return plans_content;
	}
	public void setPlans_content(String plans_content) {
		this.plans_content = plans_content;
	}
	public String getPlans_startdate() {
		return plans_startdate;
	}
	public void setPlans_startdate(String plans_startdate) {
		this.plans_startdate = plans_startdate;
	}
	public String getPlans_enddate() {
		return plans_enddate;
	}
	public void setPlans_enddate(String plans_enddate) {
		this.plans_enddate = plans_enddate;
	}
	public Timestamp getPlans_writeday() {
		return plans_writeday;
	}
	public void setPlans_writeday(Timestamp plans_writeday) {
		this.plans_writeday = plans_writeday;
	}
	
	@Override
	public String toString() {
		return "PlansDto [plans_num=" + plans_num + ", plans_member_num=" + plans_member_num + ", plans_subject="
				+ plans_subject + ", plans_content=" + plans_content + ", plans_startdate=" + plans_startdate
				+ ", plans_enddate=" + plans_enddate + ", plans_writeday=" + plans_writeday + "]";
	}
	
}
