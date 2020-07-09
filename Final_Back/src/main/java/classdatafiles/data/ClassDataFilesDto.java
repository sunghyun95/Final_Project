package classdatafiles.data;

public class ClassDataFilesDto {
	int classdatafiles_num;
	int classdatafiles_classdata_num;
	String classdatafiles_classdata_filename;
	public int getClassdatafiles_num() {
		return classdatafiles_num;
	}
	public void setClassdatafiles_num(int classdatafiles_num) {
		this.classdatafiles_num = classdatafiles_num;
	}
	public int getClassdatafiles_classdata_num() {
		return classdatafiles_classdata_num;
	}
	public void setClassdatafiles_classdata_num(int classdatafiles_classdata_num) {
		this.classdatafiles_classdata_num = classdatafiles_classdata_num;
	}
	public String getClassdatafiles_classdata_filename() {
		return classdatafiles_classdata_filename;
	}
	public void setClassdatafiles_classdata_filename(String classdatafiles_classdata_filename) {
		this.classdatafiles_classdata_filename = classdatafiles_classdata_filename;
	}
	@Override
	public String toString() {
		return "ClassDataFilesDto [classdatafiles_num=" + classdatafiles_num + ", classdatafiles_classdata_num="
				+ classdatafiles_classdata_num + ", classdatafiles_classdata_filename="
				+ classdatafiles_classdata_filename + "]";
	}
	
	
	
	
	
	
}
