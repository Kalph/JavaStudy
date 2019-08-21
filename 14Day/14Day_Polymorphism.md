다형성
===============

<br/>

부모 레퍼런스로 자식 객체를 다루는 기술

<br/>

```Java
Parent p = new Child();
Child c = new Parent(); 
//            - 자식이 부모 객체를 상속했으나 자식 
//              레퍼런스로 부모 객체를 생성할 수 없다.
```

<br/>


만일 부모 객체에 자식을 할당할 경우

<br/>

```Java
Parent p = new Child
```

<br/>

 위의 코드와 같이 할당을 하면 된다 여기서 = 연산자는 양 옆 자료형의 **형태**가 같아야 하는데 Child와 Parent의

자료형이 다름에도 오류가 생기지 않는 이유는 할당을 하는 과정에서 Child가 자동적으로 형변환 되기 때문이다.

<br/>

명시적으로 코드를 적어 준다면 아래와 같은 것이다.

<br/>

```Java
Parent p = (Parent)new Child();
```

<br/>

 이후 Child의 메서드를 사용하기 위해서는

<br/>

```Java
((Child)p).Childmetho1();
```

<br/>

 위와 같이 (Child)를 통해 명시적으로 형변환을 시켜주면 된다. - 다른 말로 강제 형변환으로 부르기도 한다.
 
<br/>

이와 같이 다형성을 사용하는 이유는

<br/>

[하나의 타입으로 다양한 실행 결과를 얻을 수 있으며 객체를 부품화하여 유지 보수를 용이하게 한다.](https://blog.naver.com/PostView.nhn?blogId=heartflow89&logNo=220979244668&proxyReferer=https%3A%2F%2Fwww.google.com%2F)

<br/>

* instanceof 연산자 - 클래스 타입이 일치하면 true, 다르면 false를 리턴하는 연산자

## 정적 바인딩과 동적 바인딩

<br/>

정적 바인딩 - 프로그램이 실행되는 과정에서 바인딩 되는 것을 의미한다.

* -> 실행 이전에 값이 확정되는 것

<br/>

동적 바인딩 - 원시 프로그램이 컴파일러 혹은 링크 시에 확정되는 바인딩을 의미한다.

**-> 실행 이후에 값이 확정되는 것**

<br/>

* 가급적 바인딩은 뒤로 미루는게 권고된다.

<br/>

[관련 참고 블로그  
자바 :: 바인딩(binding)](https://blog.naver.com/PostView.nhn?blogId=reeeh&logNo=220716449491&proxyReferer=https%3A%2F%2Fwww.google.com%2F)

<br/>
