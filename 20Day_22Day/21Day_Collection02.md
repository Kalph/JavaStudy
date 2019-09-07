목차
==========
* [Set](#Set)<br/>
* [HashSet](#1-HashSet)<br/>
* [LinkedHashSet](#2-LinkedHashSet)<br/>
* [TreeSet](#3-TreeSet)<br/><br/>

## Set

<br/>

### 특징

객체를 중복해서 저장이 불가능하다.

저장 순서가 보장되지 않는다.

* Set은 인터페이스이므로 Set set = new Set(); 과 같은 방식의 객체 생성은 불가능하다.

<br/>

대표적인 클래스로는 HashSet, TreeSet, LinkedHashSet 등이 있다.

<br/>

## 1. HashSet

<br/>

```java
HashSet<String> set = new HashSet<>();
Set<String> set2 = new HashSet<>();
```

<br/>

```java
HashSet<String> set = new HashSet<>();

set.add("hi");
String a = (" hello"):
set.add(a);
set.add(a);
System.out.println(set);
```

<br/>

위의 결과를 출력할 경우 저장 순서가 유지 안됨을 알 수 있다. 

또한 중복 저장이 되지 않는다.

<br/>

```java
package apartment.myhome;

import java.util.HashSet;
import java.util.Set;

public class StartRoom {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();

		set.add("hi");
		String a = (" hello");
		set.add(a);
		String b = (" hello");
		set.add(b);
		System.out.println(set);
		
		System.out.println(a.equals(b));

		Set<String> set2 = new HashSet<>();
		set2.add("hi");
		set2.add(" hello");
		
		System.out.println(set.equals(set2));
	}		
}
```

<br/>

위의 코드를 출력시킬 경우 set2의 경우 중복 값 제거를 할 때는 String 클래스 안에 오버라이드 된

 hashCode()를 확인 -> equals() 후 같으면 중복으로 인식하여 추가하지 않는다.

<br/>

마찬가지로 set1와 set2의 두 객체를 비교했음에도 true가 나오는 이유는 String 클래스 내부적으로 equals()가 오버라이딩되어 있기 때문이다.

<br/>

```java
Set<myRoom> set2 = new HashSet<>();
```

<br/>

만일 위와 같이 set2를 임의로 생성한 myRoom 클래스 객체로 생성한다면. myRoom 클래스에서는 HashCode()와 equals()를 오버라이딩 해 주어야 한다.

<br/>

```java
		for(String a1 : set) {
			System.out.println(a1);
		}
		
		Iterator<String> it =set2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
```

<br/>

하나씩 출력할 때는 위와 같은 방식으로 출력을 시킬 수 있다.

<br/>

## 2. LinkedHashSet

<br/>

HashSet과 동일하나 순서를 유지하면서 저장한다

<br/>

```java
package apartment.myhome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;

public class StartRoom {
	public static void main(String[] args) {
		LinkedHashSet<String> link = new LinkedHashSet<String>();
		link.add("hi");
		link.add(" hello");
		System.out.println(link);
		
		Iterator<String> it = link.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		ArrayList<String> link2 = new ArrayList<>();
		link2.addAll(link);
		
		ListIterator<String> lt = link2.listIterator();
		System.out.println("====");
		
        // 정방향
		while(lt.hasNext()) {
			System.out.println(lt.next());
		}
		// 역방향
		while(lt.hasPrevious()) {
			System.out.println(lt.previous());
		}
	}		
}
```

<br/>

출력시킬 경우 저장순서를 유지시킴을 알 수 있다.

<br/>

ListIterator은 양방향 Iterator를 사용할 수 있다.

<br/>

## 3. TreeSet

<br/>

TreeSet은 중복 저장을 못하나 정렬 기준을 가지고 값을 저장한다.

<br/>

```java
package apartment.myhome;

import java.util.Iterator;
import java.util.TreeSet;

public class StartRoom {
	public static void main(String[] args) {
		TreeSet<CheckRoom> set = new TreeSet<>();
		set.add(new CheckRoom("hi"));
		set.add(new CheckRoom(" hello"));
		set.add(new CheckRoom("my name"));
		
		Iterator<CheckRoom> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}		
}
```

<br/>

상단에서 정의한 CheckRoom 클래스를 이용하여 TreeSet을 사용한다.

<br/>

TreeSet은 정렬 기준이 반드시 필요하다. 즉 Comparable 필요하다.

CheckRoom의 CompareTo는 올림차순으로 정렬하는 방법이므로.

<br/>

입력된 문자열은 올림차순으로 정렬될 것이다. -> 이 과정에서 정렬 기준이 **중복되는 이름은 중복 제거** 된다.
