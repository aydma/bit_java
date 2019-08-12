package day23;

public class Test08 {
	public static void main(String[] args) {
		// System.out.println(Thread.MAX_PRIORITY);   // 10
		// System.out.println(Thread.MIN_PRIORITY);   // 1
		// System.out.println(Thread.NORM_PRIORITY);  // 5
		System.out.println("Main Start");
		
//		try {
//			Thread.sleep(50);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}								
		Thread.yield(); // 무시 양보하려면 기다리는애가있어야하는데기다리는애가 없어서 
		
		System.out.println(Thread.currentThread());
		
		// 스레드 생성
		T1 job1 = new T1();
		Thread t1 = new Thread(job1, "job1");
		
		T2 job2 = new T2();
		Thread t2 = new Thread(job2, "jpb2");
		
		// 스레드 실행대기큐에 넣기
		t1.start();
		t2.start();
		
		try {
			t1.join(); // t1하고 t2가 끝날때까지 아무것도 못함 // 이거끝나고 홀수합 + 짝수합  실행됨
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("홀수합 + 짝수합 = "+(job1.sum+job2.sum));
		System.out.println("Main End");
	}
}

// 가상의cpu위에 얹어질 thread 2개
class Job1 implements Runnable{
	int sum = 0;  // 홀수의 합을 계산할 변수
	public void run() {
		for(int i=1; i<100; i=i+2) {
			sum += i;
			System.out.print(Thread.currentThread()); // 현재 cpu를 점유한 Thread 정보
			System.out.println("1~"+i+" 홀수합 : "+sum);
			
		}
	}
}

class Job2 implements Runnable{
	int sum = 0;  // 짝수의 합을 계산할 변수
	public void run() {
		for(int i=0; i<100; i=i+2) {
			sum += i;
			System.out.print(Thread.currentThread()); // 현재 cpu를 점유한 Thread 정보
			System.out.println("0~"+i+" 짝수합 : "+sum);
			Thread.yield(); // 홀수가 기다리니까 양보함
		}
	}
}
