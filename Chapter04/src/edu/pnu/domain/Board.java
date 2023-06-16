package edu.pnu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // persistence로 해준다~지속성~
//@Table(name="MyBoard") 보드이름 바꿀수 있다. 하지만 잘 안써. 보통 클래스 네임으로.
public class Board {

	@Id // seq를 ID로 쓰겠다. DB를 설계중.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 값을 만들어준다. ID의 값을 만들어준다. MySQL은 Autoincrement.
	// 오라클은 시퀀스
	// h2는 디폴트가 시퀀스. AutoIncrment도 지원.
	// 전략으로 이걸 해줄수 있다. statege = 하고 ctrl 스페이스 하면 auto (각 sql마다 디폴트인걸로)
	// 아이덴티티가 오토인크리먼트
	private Long seq;
	@Column(length = 40) // varchar 40이랑 같은거
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Long cnt;

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedate() {
		return createDate;
	}

	public void setCreatedate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", cnt=" + cnt
				+ "]";
	}

}
