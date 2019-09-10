목차
=========
* [1. 스레드 사용 방법](#1-스레드-사용-방법)<br/><br/>
  * [1-1 Thread 클래스를 상속](#1-1-Thread-클래스를-상속)<br/>
  * [1-2 runnable 인터페이스를 상속](#1-2-runnable-인터페이스를-상속)<br/>
  * [1-3 Demon(), join()](#1-3-Demon(),-join())<br/>
  * [1-4 Interrupt](#1-4-Interrupt)

<br/><br/>

## 스레드(Thread)

하나의 프로세스 내부에서 독립적으로 실행되는 하나의 작업을 말한다.

프로세스는 프로그램이 실행 될 때마다 개별적으로 생성된다. 

보통 한 개의 프로세스에서는 한 가지의 일을 하지만 스레드를 이용할 경우 한 프로세스 내에서 두 가지일을 동시에 할 수 있다.

<br/>

[자바 쓰레드Java Thread의 정의를 알기 전에 프로세스Process에 대해 알아야 합니다. 보통 우리가 만드는 프로그래밍 언어Java, C/C++ 등로 소스를 짜서 만든 것을 "프로그램"이라고 합니다. 그리고 이 프로그램을 "실행" 시켜서 동작하게 만들면 이것을 "프로세스"라고 합니다. 이 프로세스는 보통 하나의 루틴프로그램 처리 경로을 가지고 있습니다. 이 루틴은 직렬적입니다. 즉 어떠한 일을 수행하는 것에 있어 프로그래머가 원하는 순서대로 일을 처리합니다. 그러나 생각해보면 굳이 앞뒤 순서가 필요 없는 일들이 있을 때 분리해서 동시에 처리하고 싶은 생각이 들 때가 있습니다. 이 때 자바에서 사용할 수 있는 것이 쓰레드Thread입니다.

자바 쓰레드를 이용하면 하나의 프로세스에서도 병렬적으로 처리, 즉 여러 개의 처리 루틴을 가질 수 있습니다. 단순 반복의 코드를 실행할 때도 여러 개의 쓰레드를 만들어서 분리 시킨 뒤 결과 데이터를 받아 합치면 그만큼 시간을 절약할 수 있습니다.](https://jdm.kr/blog/69)

<br/>

## 1. 스레드 사용 방법

<br/>

### 1-1 Thread 클래스를 상속

<br/>

```java
package apartment.myhome;

public class StartRoom extends Thread{
	// 상속 
	
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println(getName() + " " + i + "번");
		}
	}
	
	public static void main(String[] args) {
		StartRoom st = new StartRoom();
		st.start();
		
		// start() 메소드를 사용한 이유.
		
		// 모든 스레드는 독립적인 작업 수행을 위해 자신만의 호출 스택이 필요하다.
		// run() 메소드는 클래스에 오버라이딩 된 메소드를 사용하는 것이다.
		// start() 메소드는 새로운 스레드가 작업을 실행하는데 필요한 공간을 생성한 다음 run() 호출 -> 그 안에 있는 스택에 run()이 저장된다.
		// 스레드를 사용하기 위해 start() 실행시키면 스레드만의 독립적인 작업 공간인 호출 스택이 만들어진다.
		// 스레드가 종료되면 자업에 사용한 호출 스택은 소멸한다.

        st.run() 
        // st.run()을 호출할 경우 main에서 실행이 됨. 단순히 StartRoom 클래스안의
        // run이라는 메서드를 사용하는 의미가 되어버림.
	}		
}
```

<br/>

### 1-2 runnable 인터페이스를 상속

<br/>

```java
package apartment.myhome;

public class StartRoom implements Runnable{
	
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i + " ");
			// Thread 클래스를 상속받은 것이 아니므로 getName() 사용 불가능.
			// Thread의 currnetThead()를 통해 현재 실행중인 스레드의 객체를 받아 getName()으로 반환.
		}
	}		
	
	public static void main(String[] args) {
		Thread th = new Thread(new StartRoom());
		th.start();
		th.start(); // 오류 발생. 한 번 종료된 스레드는 재호출이 불가능함.
	}

}
```

### 1-3 Demon(), join()

```java
package apartment.myhome;

public class StartRoom implements Runnable{

	@Override
	public void run() {
		for(int i=0; i < 10; i++) {
			System.out.println(i + "번째로 지연 중");
			try {
				Thread.sleep(500); // 스레드를 지연시키는 메소드  0.5초 의미
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		Thread th = new Thread(new StartRoom());

		// 스레드는 1~10까지의 우선순위를 가짐
		// 기본값은 5
		System.out.println("th의 우선순위 : " + th.getPriority()); 
		th.setPriority(10); // 인위적으로 우선순위를 설정하는 방법
		th.setPriority(Thread.NORM_PRIORITY); // 5의 우선순위를 설정하는 방법
		// 이외에도 MAX, MIN을 이용하여 10과 1로 우선순위를 설정 가능.
		
		th.start();
	}
}
```

<br/>

*****

### StartRoom 클래스

```java

package apartment.myhome;

public class StartRoom implements Runnable{

	@Override
	public void run() {
		for(int i=0; i < 6; i++) {
			System.out.println(i + " StartRoom 스레드");
			try {
				Thread.sleep(500); // 스레드를 지연시키는 메소드  0.5초 의미
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
```

### LivingRoom 클래스

<br/>

```java
package apartment.myhome;


public class LivingRoom implements Runnable{

	@Override
	public void run() {
		for(int i=0; i < 11; i++) {
			System.out.println(i + " LivingRoom 스레드");
			try {
				Thread.sleep(500); // 스레드를 지연시키는 메소드  0.5초 의미
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
```

<br/>

### Run 클래스

<br/>

```java
package apartment.run;

import apartment.myhome.LivingRoom;
import apartment.myhome.StartRoom;


public class Run {
	public static void main(String[] args) {
		Thread t1 = new Thread(new StartRoom());
		Thread t2 = new Thread(new LivingRoom());

		t1.setPriority(Thread.MIN_PRIORITY);
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("t1의 우선순위 : " + t1.getPriority()); 
		System.out.println("t2의 우선순위 : " + t2.getPriority());
		
		// 데몬 스레드
		// 다른 일반 스레드(데몬 스레드가 아닌)의 작업을 돕는 보조적인 역활	
		// 일반 스레드가 모두 종료되면 데몬 스레드는 강제적으로 죵료된다.
		// 즉 t2.setDaemon(true); 구문 때문에 t1이 5까지 출력되고 끝나면 2는 6을 출력시키고 
		// 이후에도 코드를 출력시켜야 함에도 종료된다.
		t2.setDaemon(true); 
		
		t1.start();
		t2.start();
		
		// -> 우선 순위 적용이 안됨 -> cpu가 멀티 코어 환경이기 때문
		
		try {
			
			// join()은 메인 스레드가 종료되지 못하게 만든다.
			// 즉 데몬 스레드로 t2의 스레드가 종료되야 함에도 join() 메서드로 인해 t2는 종료되지 않는다.
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 종료");
	}
}
```

<br/>

### 데몬 스레드

<br/>

[https://hashcode.co.kr/questions/209/자바에서-데몬-쓰레드가-뭔가요](https://hashcode.co.kr/questions/209/자바에서-데몬-쓰레드가-뭔가요)

<br/>

### 1-4 Interrupt

<br/>

```java
package apartment.myhome;

import java.util.Scanner;

public class StartRoom implements Runnable{
	// interrupt를 이용하여 스레드의 작업을 취소시키기.

	@Override
	public void run() {
		int cnt = 0; 
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread().isAlive());
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println(Thread.interrupted());
		
		while(cnt<5 && !Thread.currentThread().isInterrupted()) {
			// 5초가 지나지 않고 interrupt 상태가 false인 동안 진행.
			
			try {
				Thread.sleep(1000);
				System.out.println(++cnt + "초");
			} catch (InterruptedException e) {
				System.out.println(cnt + "초 지남");
				Thread.currentThread().interrupt();
				// 5초 가 지날 경우 interrupt()를 호출함으로 true로 바꿈.
			}
		}
	}
	
	public static void main(String[] args) {
		Thread th = new Thread(new StartRoom());
		th.start();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("값 입력 : ");
		String input = sc.nextLine();
		System.out.println("입력한 값 : " + input);
		
		th.interrupt();
		// th 스레드에 interrupted를 true로 바꿈으로 스레드 종료
	}
}
```
