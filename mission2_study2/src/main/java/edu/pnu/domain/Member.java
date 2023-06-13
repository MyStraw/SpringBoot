package edu.pnu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder //빌더 사용 가능하게
@AllArgsConstructor //생성자 자동 생성
@NoArgsConstructor //빈 생성자 자동 생성

public class Member {

	private Long id;
	private String pass;
	private String name;
	private Date regidate;
	
}
