<br/>

```java
package apartment.myhome;


public class CheckRoom implements Comparable<CheckRoom>{
	
	private String name;
	
	public CheckRoom() {	
	}

	public CheckRoom(String name) {
		this.name = name;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "CheckRoom [name=" + name + "]";
	}



	@Override
	public int compareTo(CheckRoom o) {
		return /*this.name*/name.compareTo(o.getName()
           /*get, set을 생략한다면 o.name 대체 가능*/); 
        // 올림차순

//		return o.getName().compareTo(name); // 내림차순
	}
}
```

<br/>

```java
package apartment.myhome;

import java.util.Comparator;

public class LivingRoom implements Comparator<CheckRoom>{

	@Override
	public int compare(CheckRoom o1, CheckRoom o2) {
//		return o1.getName().compareTo(o2.getName()); // 내림차순
		return o2.getName().compareTo(o1.getName()); // 올림차순
	}
	
}
```

```java
package apartment.myhome;

import java.util.ArrayList;
import java.util.Collections;

public class StartRoom {
	public void test() {
		ArrayList<CheckRoom> al = new ArrayList<CheckRoom>();
		// CheckRoom 객체 세 개를 리스트에 추가.
		al.add(new CheckRoom("hi"));
		al.add(new CheckRoom("b"));
		al.add(new CheckRoom("c"));
		
		// Collections.sort 정렬 메소드 사용.
		// al만 넣을 경우 CheckRoom의 오버라이딩한 compareTo가 sort 내부적으로 호출되어 사용됨. (정렬 기준 재정의.)
		Collections.sort(al);
        // 배열 하나만을 매개변수를 받는 sort() 메서드는 배열을 '자연스런 순서'로 정렬

		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		System.out.println("=====");
		
		// al 이후에 new LivingRoom의 오버라이딩 한 compare정렬 기준을 추가함. 
		Collections.sort(al, new LivingRoom());
		for(CheckRoom cr : al) {
			System.out.println(cr);
		}
		
	}
}
```

<br/>

```java
package apartment.run;

import apartment.myhome.StartRoom;

public class Run {
	public static void main(String[] args) {
		StartRoom sr = new StartRoom();
		sr.test();
	}
}
```

<br/>

## Comparable, Comparator 은 정렬을 떠올리면된다.

<br/>

* Comparable - 일반적인 정렬 - compareTo() 메서드를 구현

* Comparator - 특정한 정렬 - compare() 메서드를 구현

<br/>

**간단하게 요약하자면 comparator은 Collections.sort()를 사용할 때 매개변수를 하나로 받으며 Comparable은 Collections.sort()를 사용할 때 매개변수를 두 개를 받는 식으로 사용하면된다.**

<br/>

> Comparable - 이 인터페이스를 구현한 객체 스스로에게 부여하는 한 가지 기본 정렬 규칙을 설정하는 목적으로 사용한다. <br/>
> Comparator - 이 인터페이스를 구현한 클래스는 정렬 규칙 그 자체를 의미하며, 기본 정렬 규칙과 다르게 원하는대로 정렬순서를 지정하고 싶을 때 사용한다. <br/>
>> 출처: https://dev-daddy.tistory.com/23 [대한민국 개발자 아빠]

<br/>
