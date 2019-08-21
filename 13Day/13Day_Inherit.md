상속
================

<br/>

public class myRoom1 extends Livingroom{
 위 코드의 의미는 Livingroom를 myRoom1이 상속받겠다는 의미이다. 

이로서 myRoom은 LivingRoom 클래스의 생성자와 메서드들을 사용할 수 있다.

<br/>

```Java
	public myRoom1() {
	}
	
	public Desktop(String name, String bath, String mirror, int time, boolean roomIn) {
		super(name, bath, mirror ,price);
		this.roomIn = roomIn;
		
	}
```

<br/>

부모 객체의 생성자를 호출하기 위해선 super();를 사용한다.

위의 코드는 부모 객체에서 생성자를 포함한 set,get이 만들어졌다는 가정을 두고 쓴 코드이다.

super()를 통해 부모 객체에서 만들어진 name, bath, mirror, price의 생성자를 호출하였다.

<br/>

```Java
	public String information() {
		return super.information() + ", roomIn : " + roomIn;
	}
```

<br/>

만일 출력을 시키고 싶다면 위의 코드와 같이 super.을 이용하여 만들어진 부모 객체에서 만들어진 information() 을 이용하여 출력시키면 된다.

<br/>

## 상속의 장점 

<br/>

* 새로운 클래스 작성 가능

* 코드를 효율적인 관리 -> 유지보수 기여

https://codedragon.tistory.com/6287

<br/>

## 오버라이딩

<br/>

오버라이딩은 상위 클래스에서 상속한 메서드를 하위 클래스에서 재정의 하여 사용하는 것을 의미한다.

<br/>

```Java
public class livingRoom {
    public void print() {
		System.out.println("거실입니다.");
	}
}
```
<br/>

위의 클래스는 livingRoom 클래스이다.

<br/>

```Java
public class myRoom1 extends livingRoom {
    @Override
    public void print() {
		System.out.println("myRoom1 입니다.");
	}
}
```

<br/>

위의 클래스에선 livingRoom 클래스를 myRoom1로 상속하였다.

myRoom1에선 상속한 livingRoom1의 print() 메서드를 재정의하여 사용하였다.

이를 출력시킬 경우

<br/>

```
거실입니다.
myRoom1 입니다.
```

<br/>

와 같은 결과를 볼 수 있다.

<br/>

## @Override 어노테이션

자바에서 클래스를 작성할 때 부모 클래스의 매서드를 방금 전과 같이 오버라이드 하는 경우가 있다. 
이때 오버라이드를 했음에도 여러 실수(오타를 통해 메서드를 잘못 정의한다거나 등등의 문제가 생길경우) 이를 방지 하기 위해 

*자바에서는 @Override 어노테이션을 지원한다.*


http://www.gisdeveloper.co.kr/?p=1265
