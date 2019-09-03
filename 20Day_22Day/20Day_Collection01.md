목차
==========
* [컬렉션](#컬렉션collection) </br> 
* [주요 인터페이스](#주요-인터페이스) </br>
* [ArrayList 실습](#ArrayList-실습) </br>
* [제네릭스](#제네릭스) </br>

## 컬렉션(Collection)

</br>

자바에서 컬렉션은 데이터의 집합, 그룹을 의미한다. - 프레임워크.

컬렉션을 사용하면 자료구조적 알고리즘을 구현할 필요가 없다.

</br>

컬렉션 프레임워크는 자바의 인터페이스를 사용하여 구현된다.

</br>

## 주요 인터페이스

</br>

### set 인터페이스

->순서를 유지하지 않는 데이터의 집합, 데이터 중복 허용 X

</br>

### List 인터페이스

-> 순서가 있는 데이터의 집합, 중복 허용

</br>

### Map 인터페이스

-> 키, 값의 쌍으로 이루어진 집합. 

순서 유지X, 키의 중복 허용 값의 중복X

</br>

**이 중에서 List와 set은 컬렉션을 상속받으나 Map은 별도로 지정된다.**

</br>

## ArrayList 실습.

</br>

* 조건 -

</br>

myRoom 객체 생성.

생성자 및 get,set, toString().

</br>

```java
ArrayList list = new Arraylist();
// ArrayList 클래스 객체 변수 list 에 ArrayList클래스 할당

list.add(myRoom input);
//list에 myRoom형 input를 추가

list.size();
// list의 크기 리턴

System.out.println(list.get(0));
// list의 0번 인덱스 리턴 후 출력

list.remove(0);
// list의 0번 인덱스 삭제

list.add(0, myRoom input)
// 리스트의 0번 인덱스에 input를 '삽입' 
// * 추가와는 다른 개념.
```

</br>

## 제네릭스

</br>

제네릭스란 컬렉션 클래스에서 다룰 객체를 미리 명시함으로 형변환을 생략하고 사용하는 것이다.

</br>

### 제네릭 사용 전

</br>

```java
ArrayList list = new ArrayList(1);

list.add(new myRoom("30평","거실"));
list.add("hi");

myRoom m = (myRoom)list.get(0);
// 다운 캐스팅 -> 어떤 객체인지 모르므로 형변환을 하였다.
System.out.println(m);
```

</br>

### 제네릭 사용 후

</br>

```java
ArrayList<myRoom> list = new ArrayList<myRoom>(1);
// 뒷 부분의 <>는 없어도 무상관
// 뒷 부분은 추론(자바의 기능)을 하기 때문에 없어도 된다. 
// 다만 명확하게 하기 위해 표기하였음.

list.add(new myRoom("30평","거실"));
// list.add("hi"); // 오류 발생 -> 주석 처리
// myRoom 제네릭으로 설정하였기 때문에 당연히 오류가 발생한다.

myRoom m = list.get(0);
// 형변환 생략 가능. 어떤 객체인지 알고 있음.
System.out.println(m);
```
