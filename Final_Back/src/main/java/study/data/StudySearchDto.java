package study.data;

import java.util.List;

public class StudySearchDto {

	private String textfield;
	private String searchSubject;
	private String searchLevel;
	private String searchType;
	private String searchStartdate;
	private String searchEnddate;
	private List<String> searchGatherday;
	private String searchAddress;
	private String searchDetailAddr;
	
	public String getSearchSubject() {
		return searchSubject;
	}
	public void setSearchSubject(String searchSubject) {
		this.searchSubject = searchSubject;
	}
	public String getSearchLevel() {
		return searchLevel;
	}
	public void setSearchLevel(String searchLevel) {
		this.searchLevel = searchLevel;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchStartdate() {
		return searchStartdate;
	}
	public void setSearchStartdate(String searchStartdate) {
		this.searchStartdate = searchStartdate;
	}
	public String getSearchEnddate() {
		return searchEnddate;
	}
	public void setSearchEnddate(String searchEnddate) {
		this.searchEnddate = searchEnddate;
	}
	public List<String> getSearchGatherday() {
		return searchGatherday;
	}
	public void setSearchGatherday(List<String> searchGatherday) {
		this.searchGatherday = searchGatherday;
	}
	public String getSearchAddress() {
		return searchAddress;
	}
	public void setSearchAddress(String searchAddress) {
		this.searchAddress = searchAddress;
	}
	public String getSearchDetailAddr() {
		return searchDetailAddr;
	}
	public void setSearchDetailAddr(String searchDetailAddr) {
		this.searchDetailAddr = searchDetailAddr;
	}
	public String getTextfield() {
		return textfield;
	}
	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	@Override
	public String toString() {
		return "StudySearchDto [textfield=" + textfield + ", searchSubject=" + searchSubject + ", searchLevel="
				+ searchLevel + ", searchType=" + searchType + ", searchStartdate=" + searchStartdate
				+ ", searchEnddate=" + searchEnddate + ", searchGatherday=" + searchGatherday + ", searchAddress="
				+ searchAddress + ", searchDetailAddr=" + searchDetailAddr + "]";
	}
	
	
}
