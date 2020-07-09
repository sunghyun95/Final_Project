package studygroup.data;

public class StudyGroupDto {
	private int studygroup_num;
	private int studygroup_study_num;
	private int studygroup_member_num;
	
	public int getStudygroup_num() {
		return studygroup_num;
	}
	public void setStudygroup_num(int studygroup_num) {
		this.studygroup_num = studygroup_num;
	}
	public int getStudygroup_study_num() {
		return studygroup_study_num;
	}
	public void setStudygroup_study_num(int studygroup_study_num) {
		this.studygroup_study_num = studygroup_study_num;
	}
	public int getStudygroup_member_num() {
		return studygroup_member_num;
	}
	public void setStudygroup_member_num(int studygroup_member_num) {
		this.studygroup_member_num = studygroup_member_num;
	}
	
	@Override
	public String toString() {
		return "StudyGroupDto [studygroup_num=" + studygroup_num + ", studygroup_study_num=" + studygroup_study_num
				+ ", studygroup_member_num=" + studygroup_member_num + "]";
	}
	
}
