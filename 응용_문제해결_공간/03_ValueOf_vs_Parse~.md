
```java
String num1 = "hi";
```

<br/>

 위와 같은 String형의 num1 변수에 리터럴 hi 문자열을 할당하였다.

<br/>

```java
int cp1 = Integer.parseInt(a);
Integer cp2 = Integer.parseInt(a);
		
int cv1 = Integer.valueOf(a);
Integer cv2 = Integer.valueOf(a);
```

<br/>

이후 위와 같이 네 줄의 코드를 작성해보았다.

결과는 모두 정상적으로 가동하는 것을 알 수 있다.

<br/>

다른 점이라면 int라는 자료형과 Integer라는 객체로 저장하는 것의 차이일 것이다.

<br/>

## ParesInt와 valueOf의 차이.

<br/>

valueOf - 로 리턴되는 것은 new Integer()로 객체이다.

pareInt - 로 리턴되는 것은 int로 기본 자료형이다.

<br/>

```java
int cp1 = Integer.parseInt(a);
Integer cp2 = Integer.parseInt(a);
```

<br/>

여기서 위의 두 코드에서도 차이를 볼 수 있는데 parseInt는 int인 기본 자료형으로 반환을 하게 된다. 

그러나 Integer cp2 는 객체를 받아야 하는데 int 기본 자료형을 받게 됨에도 아무런 문제가 없다.

<br/>

```java
int cp1 = Integer.parseInt(a);
Integer cp2 = new Integer(Integer.parseInt(a));
```

<br/>

직관적으로는 Integer cp2에 저장을 하려면 위의 코드 처럼 new Integer()을 붙여주는 것이 맞을 것이다.

<br/>

## AutoBoxing

<br/>

이는 자바의 AutoBoxing 기능 때문이다.

자바 컴파일러가 원시 데이터 유형을 wrapper 클래스로 자동 변환 시켜주는 것을 의미하기 때문이다.

<br/>

boolean -> Boolean<br/>

char -> Character<br/>

short -> Short<br/>

byte -> Byte<br/>

int -> Integer<br/>

long -> Long<br/>

float -> Float<br/>

double -> Double<br/>

<br/>

여기서 주의해야 할 것은 같은 type의 형을 wrapper 클래스로 변환시켜줄 수 있다는 것이다.

<br/>

```java
Integer num1 = new Integer("123"); 
// -> 객체를 생성하면서 할당하면 문자열도 넣을 수 있음 ( 정수만을 넣는다는 가정 하에 )
System.out.println(num1);

// Integer num2 = "123"; 
// 오류 발생 -> 문자열을 Interger의 wrapper 클래스로 변환시켜줄 순 없음.
// "123" -> 123으로 수정함으로서 해결 가능

String str = "123";
// Integer num3 = str;
// 위와 마찬가지의 오류. 
// Integer num3 = str; -> Integer.parseInt(str); 로 수정함으로서 해결 가능
```

<br/>

```java
Integer k = Integer.valueOf(Integer.parseInt("1")); // 본래 형태로 받아주는 것
int l = Integer.valueOf(Integer.parseInt("1")); // 오토 언박싱의 원리
```
