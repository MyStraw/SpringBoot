package edu.pnu.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//JPA 엔티티. 자바와 관계형데이터베이스 간의 매핑하는 역할. SQL문을 직접 작성하는 대신 얘가 다루게.
//이 클래스의 인스턴스들이 데이터베이스의 레코드와 매핑이 된다. 이 어노테이션 붙은 클래스는 JPA가 관리하는 테이블과 매핑
//기본적으로 클래스 이름을 테이블 이름으로 사용한다. 다른 이름 하려면 @Table 어노테이션을 쓰면 된다.

public class Member {
	@Id //해당 필드가 엔티티의 PK, 기본키임을 나타낸다. username이 기본키.
	private String username;
	private String password;
	private String role;
	private boolean enabled;
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return AuthorityUtils.createAuthorityList(role);
	}//AuthorityUtils : 스프링에서 제공하는 유틸리티 클래스, 권한 관련 메소드 제공

}
