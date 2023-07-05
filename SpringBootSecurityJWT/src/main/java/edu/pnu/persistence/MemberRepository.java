package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}

//회원들의 entity persistence를 관리하는 인터페이스. 이걸로 엔티티와 관련된 CRUD 작업 수행.
//스프링이 제공하는 기본적인 CRUD 메서드 상속. 
//Member 엔티티의 데이터 액세스를 추상화. 즉 구체적인 엑세스 기술에 대한 세부사항은 숨기고.
//더 일반화된 데이터 베이스 제공.
//이 인터페이스를 통해서
//DB에 저장된 회원정보를 조회,추가,수정,삭제등 작업 수행이 가능.
//별도의 쿼리작성이 없어도 조작이 가능하게 해준다.