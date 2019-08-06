4일차 조건문
=============

Ctrl + /  - 주석

ctrl + shift + F - 자동 정렬

<br/>

next()와 nextline(0의 차이 

 -> next()는 개행 공백을 무시하고 입력을 받는다.

nextline()는 한 줄 단위로 입력하기에 개행도 한줄로 인식한다.

<br/>

## 조건문 

-> 조건식을 통해 참과 거짓을 구분함.

if, switch 문이 있다.

<br/>

```Java
	public void MyTest() {
		/* 사용자에게 점수를 입력 받아
		 점수별로 등급을 나눠 점수와 등급을 출력하는 코드 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		String grade = "";
		
		if(score >= 90) {
			grade = "A등급";
		}else if(score >= 80) {
			grade = "B등급";
		}else if(score >= 70) {
			grade = "C등급";
		}else if(score >=60) {
			grade = "D등급";
		}else {
			grade = "F등급";
		}
		
		System.out.println("당신의 점수는 " + score + "이고, 등급은 " + grade + "입니다.");
	} 
```

<br/>

## Switch

<br/>

return; 은 메서드 자체를 종료. -> 메서드 영역에서 아예 종료시킬때 사용됨

<br/>

```Java
	public void meTest2() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("과자 이름 입력 : ");
		String fruit = sc.nextLine();
		
		int snack = 0; 
		
		switch(snack) {
			case "초코칩": price = 1000; break;
			case "바나나칩": price = 1500; break;
			case "맛등산": price = 2000; break;
			case "불량식품":price = 500;break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				return;
		}	
		System.out.println(snack + "의 가격은 " + price + "원 입니다.");
	}
```
 
 <br/>
