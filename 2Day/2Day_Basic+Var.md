2일차 기초+변수
=============

<br/>

bin = 클래스 파일이 생성되는 공간

ctrl,shift,+ = 글자 수 키우기

ctrl,shift.- = 화면 분할

ctrl + f11 = run 단축키

<br/>

클래스 명은 대문자로 시작한다. - 암묵적 규칙

<br/>

클래스 생성시 public static void main(String[] args) 옵션에 체크하면 메인 메소드를

생성하여 사용하겠다는 의미이다.

<br/>

드래그 후 ctrl,shift,/ -> 범위 주석 /* */ 

<br/>

드래그 후 ctrl,shift,\ -> 범위 주석 해제

<br/>

ctrl,shift,o -> 에러 자동 해결

ctrl,space -> 문장 자동 완성기능 ex) sysou + ctrl + space -> System.out.println(); 

```Java
package my.house.room; // 클래스의 패키지 경로
public class HelloWorld{  // 클래스 시작
	public static void main(String[] Args) { // 메서드 시작
		System.out.println("Hello World!"); // \n 추가 후 or 전 줄넘김 확인
		
		// print와 println의 차이 -> print는 화면 출력 후 줄넘김하지 않음
		// -> \n를 추가함으로 줄넘김을 시킴으로서 줄넘김 가능.
        System.out.print("어후"); // \n으로 줄넘김가능
		System.out.print("제 집에\n");
		System.out.println("어서오세요");
	}
}
```

<br/><br/>

프로젝트 - 하나의 프로젝트는 하나의 프로그램 개념

패키지 - 폴더와 같은 개념 -> 파일을 분류함

클래스 - 코드 작성

<br/>

하나의 프로젝트는 일반적으로 하나 이상의 패키지를 포함.

프로젝트는 패키지의 집합이며 패키지는 클래스의 집합임.

<br/>

```Java
package my.house.room;

public class Computer {	
	public void game() {
		
		System.out.println(11); // 정수
		System.out.println(1.1); // 실수
		
		System.out.println('a');
		System.out.println("컴퓨터 공부.");
		
		System.out.println(11 + 22);
		System.out.println(1.1 - 0.1);
		System.out.println('a'+1);
		
		System.out.println("컴퓨터" + 1 + 2 );	
	}
}
```

<br/><br/>

## 변수 

<br/>

변수? -> 값을 저장할 수 있는 메모리임. 

변수에 특정 값을 저장함으로서 의미를 부여할 수 있고 계속해서 반복적인 재사용이 가능 -> 유지보수또한 쉬워짐

<br/>

변수는 선언한 뒤 초기화를 해줘야 한다.

<br/>

```Java
package my.house.room;

public class Computer {
	public void game() {
		boolean game1; //1byte 
		byte game2; // 1byte
		short game3; // 2byte
		int game4; // 4byte
		long game5;// 8byte
		float game6; // 4byte
		double game7; // 8byte
		char ch; // 2byte
		// 문자열 -> 참조 자료형
        // 문자의 길이에 따라서 자료형의 크기가 유동적으로 변함
		String game00;
		int game8_1;
		int game9$2;
        // 변수 이름에 특수문자는 $와 _만 가능함
	}
}
```
