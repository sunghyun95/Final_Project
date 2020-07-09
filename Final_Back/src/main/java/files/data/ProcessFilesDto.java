package files.data;

public class ProcessFilesDto {
	private int processfiles_num;
	private int processfiles_process_num;
	private String processfiles_process_filename;
	public int getProcessfiles_num() {
		return processfiles_num;
	}
	public void setProcessfiles_num(int processfiles_num) {
		this.processfiles_num = processfiles_num;
	}
	public int getProcessfiles_process_num() {
		return processfiles_process_num;
	}
	public void setProcessfiles_process_num(int processfiles_process_num) {
		this.processfiles_process_num = processfiles_process_num;
	}
	public String getProcessfiles_process_filename() {
		return processfiles_process_filename;
	}
	public void setProcessfiles_process_filename(String processfiles_process_filename) {
		this.processfiles_process_filename = processfiles_process_filename;
	}
	@Override
	public String toString() {
		return "ProcessFilesDto [processfiles_num=" + processfiles_num + ", processfiles_process_num="
				+ processfiles_process_num + ", processfiles_process_filename=" + processfiles_process_filename + "]";
	}
	
	
}
