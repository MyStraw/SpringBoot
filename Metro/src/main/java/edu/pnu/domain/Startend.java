package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "startend")

public class Startend{
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Seq;
	private Long TrainNum;
	private String LineNum;
	private Long Start;
	private Long End;
	private String WeekDayHoliDay;
}