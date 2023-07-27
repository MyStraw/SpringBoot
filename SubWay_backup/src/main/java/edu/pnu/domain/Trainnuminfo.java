package edu.pnu.domain;

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
@Table(name = "trainnuminfo")

public class Trainnuminfo {
	@Id	
	private Long Seq;
	private String LineNum;
	private String StationNameplus;
	private String AboveUnder;
	private Boolean Floor;
	private Boolean Connection;
	private Boolean TransferParking;
	private Boolean CycleLocker;
	private Boolean MeetPlace;
	private Boolean Locker;
	private Boolean Photo;
	private Boolean DocMachine;
	private Boolean BabyMilk;
	private Boolean WheelLift;
	private Boolean ElevatorInside;
	private Boolean ElevatorOut;
	private Boolean Escalator;
	private Boolean BlindWay;
	private Boolean ExternalRamp;
	private Boolean EmergencyPhone;
	private Boolean Police;	
	
	

}
