package member.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao extends SqlSessionDaoSupport implements MemberDaoInter{

	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfMember",dto);
		
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfMember", dto);
		
	}

	@Override
	public void deleteMember(int member_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfMember",member_num);
	}
	//아이디 값 가져오기
	@Override
	public MemberDto selectOneMember(int member_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("SelectOneOfMember", member_num);
	}

	@Override
	public MemberDto searchMember(String field, String searchtxt) {
		// TODO Auto-generated method stub
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("field",field);
		map.put("searchtxt",searchtxt);
		return getSqlSession().selectOne("SearchOfMember",map);
	}
	
	@Override
	public int checkid(String member_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("checkIdOfMember",member_id);
	}

	@Override
	public int isCheckPass(String member_id, String member_password) {
		// TODO Auto-generated method stub
		HashMap<String, String> map =new HashMap<String, String>();
		map.put("member_id", member_id);
		map.put("member_password",member_password);
		return getSqlSession().selectOne("checkPassOfMember",map);
	}

	@Override
	public MemberDto selectNameMember(String member_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("SelectNameofMemeber",member_id);
	}
	
	@Override
	public MemberDto admin() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("adminOfMember");
	}
	
	@Override
	public int selectCountId(String member_name, String member_email, String member_phone) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("member_name", member_name);
		map.put("member_email", member_email);
		map.put("member_phone", member_phone);
		return getSqlSession().selectOne("selectOfCheckId", map);
	}
	
	@Override
	public String selectId(String member_name, String member_email, String member_phone) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("member_name", member_name);
		map.put("member_email", member_email);
		map.put("member_phone", member_phone);
		return getSqlSession().selectOne("idOfMember", map);
	}
	
	@Override
	public int selectCount(String member_name, String member_id, String member_phone) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("member_name", member_name);
		map.put("member_id", member_id);
		map.put("member_phone", member_phone);
		return getSqlSession().selectOne("selectOfCheck", map);
	}


	@Override
	public void updatePassword(String member_id, String member_password) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("member_id", member_id);
		map.put("member_password", member_password);
		getSqlSession().update("updatepasswordOfMember", map);
	}

	@Override
	public List<MemberDto> allOfMember(String type, String field,String search) {
		// TODO Auto-generated method stub
		
		Map<String, String> map=new HashMap<String, String>();
		if(type != null)
		map.put("type",type);
		if(search != null) {
			map.put("field",field);
			map.put("search", search);			
		}
		return getSqlSession().selectList("allOfMember", map);
	}

	@Override
	public void updateType(int member_num, String member_type) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("member_num", member_num);
		map.put("member_type",member_type);
		getSqlSession().update("updateTypeOfMember", map);
	}
	


}
