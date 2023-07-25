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

//제네릭 타입으로 Member, String을 받는다.
//JpaRepository는 Spring Data JPA가 제공하는 기본적인 
//CRUD(Create, Read, Update, Delete) 연산들을 정의한다.

//JpaRepository<Member, String> : 두개의 타입 파라미터를 받는다. Member은 엔티티 클래스 타입
//두번째는 엔티티의 ID 필드 타입이다.
//Member 의 ID필드가 username 이니까 String이 됐당

//이 MemberRepository 클래스는 이제 JpaRepository 인터페이스가 제공하는 여러 메서드를 사용해서 
//Member 엔티티에 대해 데이터베이스 연산을 수행할 수 있게된다. 
//save() 메서드로 엔티티를 저장하고, 
//findById() 메서드로 엔티티를 검색하고, 
//delete() 메서드로 엔티티를 삭제할 수 있게된다.