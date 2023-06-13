package edu.pnu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Getter 
//@Setter 롬복은 반복적인 코드 사용을 줄이고자 개발자들에게 이런 편의를 제공해줬다. 게터세터를 작성해줘도 되지만 이 어노테이션으로 끝난다.
//@ToString
@Builder
//Builder: 객체 생성을 위한 빌더 패턴을 자동으로 생성해줍니다. 따라서, Member.builder().id(1L).name("John").build()와 같은 방식으로 객체를 생성할 수 있습니다.

//@AllArgsConstructor //모든 필드를 포함한 매개변수를 받는 생성자가 자동으로 생성됩니다.
//@NoArgsConstructor //매개변수 없는 기본 생성자가 자동으로 생성됩니다.
public class Member {
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}
	private Long id;
	private String pass;
	private String name;
	private Date regidate; //유틸 date 인지, sql date 인지 잘 구분. 이거 엇갈리면 나중에 오류
	
	

	public Member() {	
	}
	
	public Member(Long id, String pass, String name, Date regidate) {		
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	
}
