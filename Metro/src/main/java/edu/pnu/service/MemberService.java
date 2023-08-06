package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Member registerMember(Member member) {    	
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRole("ROLE_MEMBER"); // 기본 역할 설정
        member.setEnabled(true);
        return memberRepo.save(member);
    }
    // 로그인 서비스는 JWT 필터를 사용하여 처리
    
    
    
//    public void register(Member member) throws Exception {
//        // 비밀번호 암호화
//        member.setPassword(passwordEncoder.encode(member.getPassword()));
//        // ROLE 설정
//        member.setRole("ROLE_MEMBER");
//        member.setEnabled(true);
//        // 저장
//        memberRepo.save(member);
//    }
}