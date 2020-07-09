package member.data;

import java.util.List;

public interface MemberDaoInter {
	//회원 가입(회원 추가)
	public void insertMember(MemberDto dto);
	//회원 정보 수정
	public void updateMember(MemberDto dto);
	//회원 삭제
	public void deleteMember(int member_num);
	//회원 num으로 회원 조회
	public MemberDto selectOneMember(int member_num);
	//회원 id로 회원 조회
	public MemberDto selectNameMember(String member_id);

	//회원 검색
	public MemberDto searchMember(String field, String searchtxt);
	//회원 id있는지 조회
	public int checkid(String member_id);
	//로그인- id, password로 확인
	public int isCheckPass(String member_id,String member_password);
	//관리자 찾기
	public MemberDto admin();
	//아이디 재설정 위한 정보 확인
	public int selectCountId(String member_name, String member_email, String member_phone);
	//해당 입력한 정보의 회원 아이디
	public String selectId(String member_name, String member_email, String member_phone);
	//비밀번호 재설정 위한 정보 확인
	public int selectCount(String member_name, String member_id, String member_phone);
	//비밀번호 재설정
	public void updatePassword(String member_id, String member_password);

	//회원관리 검색
	public List<MemberDto> allOfMember(String type,String field,String search);
	
	//타입 재설정
	public void updateType(int member_num, String member_type);
}
