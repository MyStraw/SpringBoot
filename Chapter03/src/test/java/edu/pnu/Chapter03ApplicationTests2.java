package edu.pnu;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc; //테스트에서 제공해주는 객체

//@SpringBootTest
//@AutoConfiguration // 이건 전체 다 테스트 하는거. 이건 위에 스프링부트 테스트랑 같이써. (이거 맞나? 뒤에 test 붙는게 또 있나 찾아봐)
@WebMvcTest //이걸 이용해서 컨트롤러를 테스트. 이건 컨트롤러만 테스트. 전체 다 테스트 하려면 위에꺼


class Chapter03ApplicationTests2 {
	@Autowired
	MockMvc mockMvc; //객체를 선언만 해줬다. new로 어떻게 만드느냐 /@Autowired를 붙여줘야!.<- 이 용어땜에 테스트 배운다
	//JVM이 값 데이터를 heap 어딘가 객체로 만들어 놨는데 어딨는진 모르니, 여기에 접근할수 있는게 참조변수. 이건 참조변수다
	//@Autowired가 자동으로 매핑 시킨다.
	//그럼 아래 @Test에서 사용 가능.
	//이거 없으면 클래스 안에 필드는 mockMvc가 없다고 나온다.
	//@Autowired가 있으면 @WebMvcTest로 자동으로 만들어진 mockMvc 객체가 자동 할당되면서 아래에서 @Test로 사용가능
	
	
	@Test
	void contextLoads() throws Exception { //hello 라는
		mockMvc.perform(get("/hello").param("name", "둘리"))
		.andExpect(status().isOk())
	//	.andExpect(content().string("Hello : 둘리")) //이거 버전때문에 안돌아간다.
		.andDo(print()); //이거까지 타이핑 하고 Run As -> Junit 실행해봐
	}

}
