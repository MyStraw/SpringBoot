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
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity // 아이디 필요하지 //우린 그냥.
public class Member {
	@Id
	private String username;
	private String password;
	private String role;
	private boolean enabled;

	public Collection<? extends GrantedAuthority> getAuthorities() {

		return AuthorityUtils.createAuthorityList(role); // 혹은 아래 코드로 직접 만들어도 된다.

//		Collection<GrantedAuthority> list = new ArrayList<>();
//		list.add(new GrantedAuthority() {
//
//			@Override
//			public String getAuthority() {
//
//				return role;
//			}
//		});
//		return list;
	}

}
