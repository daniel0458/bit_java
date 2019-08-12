package day23;

public class Test08 {
	public static void main(String[] args) {
//		System.out.println(Thread.MAX_PRIORITY);
//		System.out.println(Thread.MIN_PRIORITY);
//		System.out.println(Thread.NORM_PRIORITY);
		
		System.out.println("Main Start");
//		try {
//		Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}		
		System.out.println(Thread.currentThread());
		
		Job1 job1 = new Job1();
		Thread t1 = new Thread(job1,"job1");
		
		Job2 job2 = new Job2();
		Thread t2 = new Thread(job2,"job2");
		
		//스레드 실행 대기큐에 넣기
		Thread.yield();
		t1.start();		 
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//스레드가 다돌지 않은 상태라 원하는 값이 안찍힘 
		System.out.println("홀수합+ 짝수합 = " + (job1.sum+job2.sum));
		
		System.out.println("Main End");
	}

}

class Job1 implements Runnable {
	int sum = 0;
	@Override
	public void run() {
		for (int i = 1; i<100; i=i+2) {
			sum += i;
			System.out.print(Thread.currentThread()+" ");
			System.out.println("1~" + i +"짝수합:" + sum);
		}
	}
	
}

class Job2 implements Runnable {
	int sum = 0;
	@Override
	public void run() {
		for (int i = 0; i<100; i=i+2) {
			sum += i;
			System.out.println("0~" + i +"홀수합:" + sum);
		}
	}
	
}