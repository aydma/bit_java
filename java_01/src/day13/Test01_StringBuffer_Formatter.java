package day13;

import java.util.Calendar;
import java.util.Formatter;

public class Test01_StringBuffer_Formatter {
	public static void main(String[] args) throws Exception{ // throws Exception 오류가 나면 JVM이 처리해 준다는 소리다.
		
//		Calendar c = new Calendar();    // 객체생성이 막혀있음
		Calendar c = Calendar.getInstance();
		System.out.println(c);
//		System.out.println("2019년 "+Calendar.DAY_OF_YEAR+" 일째"); // DAY_OF_YEAR 상수화된 것이 있다.
		String date = String.format("현재시간은 %tk시: %tM분: %tS초 %n", c,c,c);
		System.out.println(date);
		
		System.out.printf("%f",Math.PI);
		String f = String.format("%f", Math.PI);
		
		System.out.println("-------------------------------------------------");
		
		// 기억하기 StringBuffer/Formatter
		StringBuffer sb = new StringBuffer();
//		Formatter fm = new Formatter(sb);
		Formatter fm = new Formatter("sss.txt"); // "sss.txt" 이렇게만 쓰면 오류가 난다. 그래서 메인함수에 throws Exception 해준다.
											     // 오류가 나면 JVM이 처리해 준다는 소리다.
												 // ("sss.txt") 경로지정하면 그 경로에 파일이 저장된다. 경로지정 안하면 프로젝트안에 파일생김
//		Formatter fm = new Formatter();
//		Formatter fm = new Formatter(System.out);
		fm.format("현재시간은 %tk시: %tM분: %tS초 %n", c,c,c); // format형태인  fm이 sb에 연결이 되어있어서 StringBuffer로 가버림 sb에 기록이 됨
		// "현재시간은 %tk시: %tM분: %tS초 %n", c,c,c 내용이 "sss.txt"파일에 기록됨
		// 컴파일하면 "sss.txt"파일이 만들어짐
		fm.format("%f",Math.PI);
		System.out.println(sb);
		fm.flush();  // 버퍼의 내용을 "sss.txt"파일로 정보 밀어내기 이거 안해주면 "sss.txt"파일에 기록안됨
		// Formatter
		// 내가 원하는 메세지를 파일로 보낼때 ,
		// 어떤 정보들을 포맷형태를 유지하면서 즉 내가 원하는 포맷 형태로 파일로 보내고 싶을때 사용한다.
		// Formatter fm = new Formatter(sb); 의 sb에는 파일정보가 많이 온다.
		// 로그(기록)파일 만들때 사용하기 // ex)로그아웃시간,로그인시간, 검색기록 등 기록하는것
		
		// StringBuffer는 데이터들을 차곡차곡 넣어서 관리하는 것
		// 하드 디스크에 가서 어떤 내용을 기록한다면 조금씩 100번하는 것보다 모아서 기록하는게 성능이 더 나은데
		// 버퍼가 꽉차면 하드에 기록하고 돌아와서 다시 기록하고 데이터를 모아놓는다.
		// fm.flush(); 지금 나의 버퍼에 있는 정보들을 꼭 하드에 가서 기록해줘 하는거 안하는거 성능차이 많이 난다.
		
	}

}
