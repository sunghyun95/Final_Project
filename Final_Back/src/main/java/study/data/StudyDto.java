package study.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class StudyDto {
	private int study_num;
	private String study_type;
	private String study_subject;
	private int study_member_num;
	private String study_startdate;
	private String study_enddate;
	private ArrayList<String> study_gatherdayname;
	private String study_gatherday;
	private int study_peoples;
	private String study_level;
	private String study_intr;
	private String study_goal;
	private String study_progress;
	private String study_address;
	private String study_detailaddr;
	private MultipartFile uploadfile;
	private String study_mainimage;
	private Timestamp study_writeday;
	private String study_writer;
	private int study_writer_num;
	private String study_oldmainimage;
	private int study_readcount;
	
	public int getStudy_num() {
		return study_num;
	}
	public void setStudy_num(int study_num) {
		this.study_num = study_num;
	}
	public String getStudy_type() {
		return study_type;
	}
	public void setStudy_type(String study_type) {
		this.study_type = study_type;
	}
	public String getStudy_subject() {
		return study_subject;
	}
	public void setStudy_subject(String study_subject) {
		this.study_subject = study_subject;
	}
	public int getStudy_member_num() {
		return study_member_num;
	}
	public void setStudy_member_num(int study_member_num) {
		this.study_member_num = study_member_num;
	}
	public String getStudy_startdate() {
		return study_startdate;
	}
	public void setStudy_startdate(String study_startdate) {
		this.study_startdate = study_startdate;
	}
	public String getStudy_enddate() {
		return study_enddate;
	}
	public void setStudy_enddate(String study_enddate) {
		this.study_enddate = study_enddate;
	}
	public ArrayList<String> getStudy_gatherdayname() {
		return study_gatherdayname;
	}
	public void setStudy_gatherdayname(ArrayList<String> study_gatherdayname) {
		this.study_gatherdayname = study_gatherdayname;
	}
	public String getStudy_gatherday() {
		return study_gatherday;
	}
	public void setStudy_gatherday(String study_gatherday) {
		this.study_gatherday = study_gatherday;
	}
	public int getStudy_peoples() {
		return study_peoples;
	}
	public void setStudy_peoples(int study_peoples) {
		this.study_peoples = study_peoples;
	}
	public String getStudy_level() {
		return study_level;
	}
	public void setStudy_level(String study_level) {
		this.study_level = study_level;
	}
	public String getStudy_intr() {
		return study_intr;
	}
	public void setStudy_intr(String study_intr) {
		this.study_intr = study_intr;
	}
	public String getStudy_goal() {
		return study_goal;
	}
	public void setStudy_goal(String study_goal) {
		this.study_goal = study_goal;
	}
	public String getStudy_progress() {
		return study_progress;
	}
	public void setStudy_progress(String study_progress) {
		this.study_progress = study_progress;
	}
	public String getStudy_address() {
		return study_address;
	}
	public void setStudy_address(String study_address) {
		this.study_address = study_address;
	}
	public String getStudy_detailaddr() {
		return study_detailaddr;
	}
	public void setStudy_detailaddr(String study_detailaddr) {
		this.study_detailaddr = study_detailaddr;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getStudy_mainimage() {
		return study_mainimage;
	}
	public void setStudy_mainimage(String study_mainimage) {
		this.study_mainimage = study_mainimage;
	}
	public Timestamp getStudy_writeday() {
		return study_writeday;
	}
	public void setStudy_writeday(Timestamp study_writeday) {
		this.study_writeday = study_writeday;
	}
	public String getStudy_writer() {
		return study_writer;
	}
	public void setStudy_writer(String study_writer) {
		this.study_writer = study_writer;
	}
	public int getStudy_writer_num() {
		return study_writer_num;
	}
	public void setStudy_writer_num(int study_writer_num) {
		this.study_writer_num = study_writer_num;
	}
	public String getStudy_oldmainimage() {
		return study_oldmainimage;
	}
	public void setStudy_oldmainimage(String study_oldmainimage) {
		this.study_oldmainimage = study_oldmainimage;
	}
	public int getStudy_readcount() {
		return study_readcount;
	}
	public void setStudy_readcount(int study_readcount) {
		this.study_readcount = study_readcount;
	}
	
	@Override
	public String toString() {
		return "StudyDto [study_num=" + study_num + ", study_type=" + study_type + ", study_subject=" + study_subject
				+ ", study_member_num=" + study_member_num + ", study_startdate=" + study_startdate + ", study_enddate="
				+ study_enddate + ", study_gatherdayname=" + study_gatherdayname + ", study_gatherday="
				+ study_gatherday + ", study_peoples=" + study_peoples + ", study_level=" + study_level
				+ ", study_intr=" + study_intr + ", study_goal=" + study_goal + ", study_progress=" + study_progress
				+ ", study_address=" + study_address + ", study_detailaddr=" + study_detailaddr + ", uploadfile="
				+ uploadfile + ", study_mainimage=" + study_mainimage + ", study_writeday=" + study_writeday
				+ ", study_writer=" + study_writer + ", study_writer_num=" + study_writer_num + ", study_oldmainimage="
				+ study_oldmainimage + ", study_readcount=" + study_readcount + "]";
	}
	
}
