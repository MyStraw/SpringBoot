package edu.pnu.dao;

import java.sql.Connection;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDao {
	
	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:tcp://localhost/~/mission2";
	private String username = "scott";
	private String password = "tiger";
	
	private Connection con;
	
	
	public List<MemberVO> getMambers() {		
		return null;
	}
	

	public MemberVO getMember(Integer id) {		
		return null;
	}

	public MemberVO addMember(MemberVO member) {		
		return null;
	}

	public MemberVO updateMamber(MemberVO member) {		
		return null;
	}

	public int deleteMember(Integer id) {		
		return 0;
	}

	

	

}
