package member.data;

import org.springframework.web.multipart.MultipartFile;

public class MemberDto {
	private int member_num;
	private String member_name;
	private String member_id;
	private String member_password;
	private String member_phone;
	private String member_email;
	private String member_address;
	private String member_detailaddr;
	private String member_type;
	private String member_profile;
	private MultipartFile profile_image;
	
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_detailaddr() {
		return member_detailaddr;
	}
	public void setMember_detailaddr(String member_detailaddr) {
		this.member_detailaddr = member_detailaddr;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
	public String getMember_profile() {
		return member_profile;
	}
	public void setMember_profile(String member_profile) {
		this.member_profile = member_profile;
	}
	public MultipartFile getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(MultipartFile profile_image) {
		this.profile_image = profile_image;
	}
	
	@Override
	public String toString() {
		return "MemberDto [member_num=" + member_num + ", member_name=" + member_name + ", member_id=" + member_id
				+ ", member_password=" + member_password + ", member_phone=" + member_phone + ", member_email="
				+ member_email + ", member_address=" + member_address + ", member_detailaddr=" + member_detailaddr
				+ ", member_type=" + member_type + ", member_profile=" + member_profile + "]";
	}
	
}
