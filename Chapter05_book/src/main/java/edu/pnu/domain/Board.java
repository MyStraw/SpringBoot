package edu.pnu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//엔티티 클래스. DB의 테이블을 매핑하는게 @Entity. 
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity //자바x 펄시스턴스로 임포트

public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //시퀀스 안넣어도 자동으로(오토 인크리먼트와 같은 옵션)
	//데이터베이스마다 자동으로 해주는게 달라. 오라클과 H2는 시퀀스, MySQL은 Auto_increment
	//전략 = identity가 auto_increment이다. default가 시퀀스라 이걸로 해줘.
	private Long seq;
	private String title;
	@Column(length = 32) //디폴트가 255
	private String writer;
	private String content;
	@Temporal(TemporalType.TIMESTAMP) //JPA에서 날짜와 시간 유형을 DB에 매핑하는 방법을 지정하는 어노테이션
	private Date createDate;
	private Long cnt;
	
	

}
