package edu.pnu.service;

import java.util.List;
import java.util.Map;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

public class MemberService {
	private MemberInterface memberInterface;;
//	private List<MemberVO> list;
	private LogDao logDao;

	public MemberService() {
		memberInterface = new MemberDaoH2Impl();

		// memberInterface = new MemberDaoListImpl();
		logDao = new LogDao();
	}

	public List<MemberVO> getMembers() {
		Map<String, Object> map = memberInterface.getMembers();
		logDao.addLog(map.get("method").toString(), map.get("sqlstring").toString(), (boolean) map.get("success"));
		return (List<MemberVO>) map.get("result");
	}

	public MemberVO getMember(Integer id) {
		Map<String, Object> map = memberInterface.getMember(id);
		logDao.addLog(map.get("method").toString(), map.get("sqlstring").toString(), (boolean) map.get("success"));
		return (MemberVO) map.get("result");
	}

	public MemberVO addMember(MemberVO member) {
		Map<String, Object> map = memberInterface.addMember(member);
		logDao.addLog(map.get("method").toString(), map.get("sqlstring").toString(), (boolean) map.get("success"));
		return (MemberVO) map.get("result");
	}

	public MemberVO updateMember(MemberVO member) {
		Map<String, Object> map = memberInterface.updateMember(member);
		logDao.addLog(map.get("method").toString(), map.get("sqlstring").toString(), (boolean) map.get("success"));
		return (MemberVO) map.get("result");
	}

	public int deleteMember(Integer id) {
		Map<String, Object> map = memberInterface.deleteMember(id);
		logDao.addLog(map.get("method").toString(), map.get("sqlstring").toString(), (boolean) map.get("success"));
		return (int) map.get("result");
	}

}