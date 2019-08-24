API
===========

- Application Programming Interface(응용 프로그램 프로그래밍 인터페이스)

자바는 각종 클래스와 메소드등의 다양한 정보를 API 문서를 통해 제공한다.

-> 자바 개발자에게 API를 보는 것은 필수이다.

-> 구글링을 통해 java api (버전)을 입력하는 것으로 이러한 API를 볼 수 있다.

또는 [다음 링크](ttps://moomini.tistory.com/5)의 방법과 같이 접속할 수 있다.

<br/>

> java.lang : 자바 프로그래밍을 위한 가장 기본적인 패키지와 클래스를 포함하고 있습니다.

> java.util : 프로그램을 제어하기 위한 클래스와 데이터를 효율적으로 저장하기 위한 클래스들을 담고 있습니다.

> java.io : 키보드, 모니터, 프린터, 파일 등을 제어할 수 있는 클래스들의 모음입니다.

> java.net : 통신을 위한 기능들을 담고 있습니다.

>> [출처] [JAVA] API와 API 문서 보는 법|작성자 유토피아

<br/>

## 실습

```java
String myHome1 = new String("hello");
String myHome2 = "hello";
```

<br/>

위의 두 코드의 차이는 문자열 "hello"를 각각 생성된 변수에 String 형으로 값을 초기화 하지만 

전자는 생산자(new String)을 통해 문자열을 생성한 것이고 후자는 리터럴로 값을 초기화 한 것이다.

<br/>

```java
String myHome1 = new String("hello");
String myHome2 = new String("hello");
System.out.println(myHome1 == myHome2); // false 출력됨
System.out.println(myHome1.equals(myHome2)); // true 출력됨
```

<br/>

전자는 힙 영역에서 다른 공간에 객체가 생성된다. 

* 즉, ==연산자로 주소값을 비교할 경우 false가 출력된다. (주소 값이 달라진다.)

*  반면 Objcet의 equals()로 비교를 할 경우 true가 출력됨을 알 수 있다. (String에서 실제 값을 비교하기 때문)

*  hashCode()는 실제 값을 비교한다.

*  System.identityHashCode()는 실제 주소값을 비교한다.

<br/>

```java
String myHome1 = "hello";
String myHome2 = "hello";
System.out.println(myHome1 == myHome2); // true 출력됨
System.out.println(myHome1.equals(myHome2)); // true 출력됨
```

<br/>

후자는 리터럴 값으로 변수를 초기화 했다.

이는 객체 생성이 아니다. **Heap 영역에 있는 String pool로 값이 초기화 된다.**

<br/>

즉, 실제로 String pool이라는 공간에 hello라는 문자열이 생성됨과 동시에 주소를 가지게 되고 

myHome1과 myHome2는 그 문자열의 주소를 가지게 되는 것이다. 

<br/>

* 따라서 == 연산자로 주소를 비교할 경우 true가 출력됨을 알 수 있다.

* hashCode또한 문자열의 실제 값을 출력시킨다.

* System.identityHashCode()또한 같은 실제 주소값을 출력시킨다.

<br/>

* 만일 여기서 myHome1에 다른 문자열을 할당한다면 String pool에 새로운 문자열의 값이 생기고 해당 주소를 myHome1이 가지게 된다. 

* 또한 myHome1이 다시 hello문자열을 할당한다면 일전의 myHome2는 계속 hello를 할당하고 있기 때문에 이미 만들어진 hello라는 값의 주소를 가지게 된다.

<br/>

## @Deprecated

자바 API에서 Deprecated라는 단어를 찾아볼 수 있는데 이는 클래스나 메소드에 @Deprecated가 붙어 있다면 

앞으로 버전업을 통해 사라질 수 있으니 사용을 권고하지 않는다는 의미이다.  

자바의 API는 하위 호환성을 고려되어 설계되었기에 클래스나 메소드라도 바로 삭제하지 않고 Deprecated를 붙여 표기한다.
