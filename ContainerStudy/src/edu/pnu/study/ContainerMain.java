package edu.pnu.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.pnu.study.operator.MyOperatorContainer;

public class ContainerMain {

	// Thread 종료 조건 변수
	private volatile boolean threadCheck = true;
	// Operator 문자열 저장 배열
	private ArrayList<String> list = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
	private MyOperatorContainer moc = new MyOperatorContainer();

	// 이 클래스의 정체가 뭐냐.
	public static void main(String[] args) { //이 메인이 메인 쓰레드. 프로세스 자체가 메인이다. 하나의 flow니까 메인 프로세스. 메인쓰레드.
		ContainerMain cm = new ContainerMain(); 

		// 일정 시간동안 사용되지 않고 있는 Operator 객체를 제거하는 Thread
		Thread th = new Thread(() -> { //자식쓰레드. 객체로 만드는 과정.
			MyOperatorContainer moc = cm.getContainer();

			// 메인 Thread가 종료하면 같이 종료되도록 종료 조건 변수(threadCheck)를 확인한다. 부모 쓰레드 죽었는지 확인. 부모 죽었으면
			// 자식도 끝내라는 코드.
			while (cm.getThreadCheck()) { //쓰레드 도는지 체크. 트루로 되어있네. 자바는 부모쓰레드 죽어도 자식쓰레드가 돌기때문에.

				System.out.println("Container Size : " + moc.getOperatorSize());
				// 생존 기준 시간인 millisecond를 넘겨서 사용되지 않은 객체는 제거한다.
				moc.releaseOldObject(15000); // 10초간. 연산자 읽어와지는게 없으면 자동으로 객체 삭제.

				try {
					Thread.sleep(1000); // 이거 안하면 cpu 엄청 잡아먹는다. 뺑뺑돈다. 1초간격
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread");
			}
			System.out.println("쓰레드를 종료합니다.");
		}); //여기까지가 쓰레드 객체. 실제 실행은 안돼. 자식쓰레드 객체 생성이다. 
		// Thread 시작
		th.start(); //얘를 호출함과 동시에 쓰레드가 작동.

		System.out.println("프로그램을 시작합니다.");

		cm.doTest();

		System.out.println("프로그램을 종료합니다.");
	}

	public MyOperatorContainer getContainer() {
		return moc;
	}

	public boolean getThreadCheck() {
		return threadCheck;
	}

	private boolean isOperator(String str) {
		if (list.contains(str))
			return true;
		return false;
	}

	private void printCmd(String cmd) {
		switch (cmd) {
		case "+":
			System.out.println("더하기 연산을 합니다.");
			break;
		case "-":
			System.out.println("빼기 연산을 합니다.");
			break;
		case "*":
			System.out.println("곱하기 연산을 합니다.");
			break;
		case "/":
			System.out.println("나누기 연산을 합니다.");
			break;
		}
	}

	public void doTest() {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("연산자를 입력하세요.(+,-,*,/) : ");
			String cmd = sc.next();

			if (isOperator(cmd) == false) {
				sc.close();
				threadCheck = false;
				return;
			}
			printCmd(cmd);

			System.out.print("첫번째 숫자 : ");
			int f = sc.nextInt();
			System.out.print("두번째 숫자 : ");
			int s = sc.nextInt();

			System.out.println("연산 결과 : " + moc.doOperate(cmd, f, s));
			System.out.println("-".repeat(40));
		}
	}
}
