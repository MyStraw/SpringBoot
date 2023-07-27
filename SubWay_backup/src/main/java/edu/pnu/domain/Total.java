package edu.pnu.domain;

import jakarta.persistence.Column;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="total")


public class Total {
	private String line_number;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long station_code;
	private String station_name;
	private String english_name;
	private String station_add;
	@Column()
	private String transfer_parking;
	private String cycle_locker;
	private String locker;
	private String photo;
	private String police;
	private String updown;
	private Long floor;
	private String connect;
	private Long meeting_place;
	private Long docu_machine;
	private Long babymilk;
	private Long wheel_lift;
	private Long elevator_in;
	private Long elevator_out;
	private Long escalator;
	private Long blind_way;
	private Long outside_sliding;
	private Long emergency_up;
	private Long emergency_down;
	@Column(length = 1000)
	private String history;	

}
