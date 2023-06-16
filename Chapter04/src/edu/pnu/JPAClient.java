package edu.pnu;

import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient {

	public static void main(String[] args) {
		System.out.println("JPA");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04"); // 이거 입력한 순간
		// 클래스에 적힌것들을 다 만들어준다.
		EntityManager em = emf.createEntityManager(); // 엔티티 매니저 만들기

		insertData(em);
		updateData(em);
//		deleteData(em);
//		EntityTransaction tx = em.getTransaction();

//		tx.begin();
//		
////		Board b = new Board();
////		b.setTitle("Title");
////		b.setWriter("Writer");
////		b.setContent("Content");
////		b.setCreatedate(new Date());
////		b.setCnt(0L);
//		
//		em.persist(b); //퍼시스턴스 메소드에 보드 넣어주면 자동으로 저장. 근데 이러면 안들어간다. transaction 써야해.
//		//sql 셋을 all or nothing 이걸 제어하는게 transacction. 트랜젝션 만들고 비긴, commint 감싸.
//		
//		tx.commit();

		em.close();
		emf.close();
	}

	private static void insertData(EntityManager em) { // 메인이 스태틱이니까 이거도 스태틱
		// 보드 데이터 10건 입력해보셈.
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			for (int i = 0; i < 10; i++) {
				Board b = new Board();
				b.setTitle("Title" + i);
				b.setWriter("Writer" + i);
				b.setContent("Content" + i);
				b.setCreatedate(new Date());
				b.setCnt(0L);
				em.persist(b);
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // 한거 되돌려.
		}

	}

	private static void updateData(EntityManager em) {

		Random rn = new Random();
		long l = rn.nextLong(30);
		
		Board b = em.find(Board.class, l); // delete 하기 위해선 검색을 먼저 해야. 검색해서 올라온 객체 삭제
		// 5번에.
		b.setTitle("나는 새로운 타이틀이다");

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(b); // 이러면 업데이트 된게 새롭게 저장.

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // 한거 되돌려.
		}

	}

	private static void deleteData(EntityManager em) {		
	
		Board b = em.find(Board.class, 9L); // delete 하기 위해선 검색을 먼저 해야. 검색해서 올라온 객체 삭제
		// 5번에.
		b.setTitle("나는 새로운 타이틀이다");

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.remove(b); // 삭제는 이렇게.

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // 한거 되돌려.
		}
	}
}
