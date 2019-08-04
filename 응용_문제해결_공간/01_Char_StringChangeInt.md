# <문제>


-를 포함한 주민번호 13자리를 입력받는다. ex)123456-123456

이 중 뒷자리 첫 번째 숫자를 통해 성별을 구분한다.(1,3이 남자 2,4는여자)
<br/><br/><br/>

## <처음 문제를 푼 방식>


```Java
	public void Private() { 
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(-포함) : "); 
		String SSN = sc.nextLine(); 
		char a = SSN.charAt(7); 
		String result = (a == '1' || a=='3') ? "남자" : "여자";
	  
		System.out.println(result); 
	 }
```

<br/><br/>

## 문제 풀이


->  String 자료형 SSN에 입력한 주민번호를 저장한 후

**char a = SSN.charAt(7);  구문에 문자 하나를 저장하여 이후 문자를 비교하여 출력시켜주는 방식을 사용했다.**
<br/>

* 여기서 주의할점은

자바에서 문자열은 == 로 비교를 하지 못한다는 것이다. 이는 주소값을 비교하는 것인데
<br/><br/>

String는 문자 배열 형태라고 생각하면 된다.

**String은 기본 자료형이 아니다.**
<br/><br/>

-> char가 여러개 붙은 문자열을 활용하기 위해 쉽게 제공되는 것이 String 클래스이다.


-> 기본 자료형은 메모리 공간안에 값이 들어가나, String는 주소값이 들어가는 것이다.


-> 둘의 차이가 있다는 정도로 이해하면 좋다.
<br/><br/>

## <문제를 다르게 푼 방식>


위에서의 문제 답안은

**String b = (a == (int)1 || a == (int)3) ? "남자" : "여자"; // (int)는 구분을 위해 표기 **

위의 코드와 같이 정수형태로 비교할 수는 없을까. 라는 의문으로 이어진다.


```Java
	public void Private() { 
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(-포함) : "); 
		String aaa=sc.nextLine();
		
		int a = Character.getNumericValue(aaa.charAt(7));
		System.out.printf("%d", a);
		
		String b = (a == (int)1 || a == (int)3) ? "남자" : "여자"; // (int)는 구분을 위해 표기
		System.out.println(b);
	 }
```


 따라서 https://codeday.me/ko/qa/20190306/10766.html 해당 링크를 참고하여

이는 String -> int가 되는 것이 아닌 char -> int형으로 수정하는 방법이다.(어쩌면 뇌피셜..)

푼 결과 Character.getNumericValue(); 메서드를 사용하는 것으로 해결이 되었다.


이 외에도 여러 차이를 비교해보고자 다양한 코드를 작성해보았다.

```Java

	public void private1() {
		String a="1";
		int b=Integer.parseInt(a); //String을 int형으로 변환시키는 방법
		System.out.printf("%d\n", b);
	}
	
	public void private2() {
		char a=1; // 여기서 char과 String형의 차이가 나타난다. 
		System.out.printf("%d", (int)a); 
	}
	
	public void private3() {
		String a="1234";
		String b=a.substring(0,1); // 문자열 슬라이싱 0~1까지의 범위 문자를 추출

		System.out.printf("%s\n",b);
		int c = Integer.parseInt(b); // 이후 추출한 문자를 String -> int형으로 변환시킴.
		System.out.printf("%d\n",c);
	}
 ```
<br/>

# 요약.


자바에서의 char과 String이 저장되는 형태는?

1. char은 기본 자료형 변수다.

2. String는 여러가지 기능을 제공하는 String 클래스이다. 기본 자료형이 아니므로 메모리 값에 공간이 들어가지 않으며, 주소값에 들어간다.


+ String는 객체를 생성할 때마다 주소값이 달라지므로 equals()를 통해서 두 개의 문자열이 동일한 값을 가지고 있는지 비교해야 할 필요가 있다.


- equals

equals는 두개의 문자열이 동일한 값을 가지고 있는지를 비교하여 결과값을 리턴한다.


