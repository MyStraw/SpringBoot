package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "stations")
public class Stations {
	@Id	
	private Long StationCode;
	private String StationName;
	private String StationNameplus;
	private String EnglishName;
	private String Tel;
	private String Address;
	@Column(length = 1000)
	private String History;
}