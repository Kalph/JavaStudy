

## 클래스나 인스턴트(객체)를 비교할때 instanceof와 getClass()를 이용하는 경우가 있다.

<br/>

## instaneof

<br/>

* Type비교 연산자로 객체 타입을 확인한다.

사용형식은 객체 + instance + 클래스이다.

<br/>

* 속성은 연산자이고 형변환이 가능하느냐에 따라 true / false로 리턴해준다

<br/>

```java
class LivingRoom {} // 클래스 LivingRoom 생성
class SmallRoom extends LivingRoom() {} // 클래스 SamllRoom 생성 -> LivingRoom 상속

public class CheckRoom{
	public static void main(String[] args) {
		LivingRoom l1 = new LivingRoom(); // l1 객체 생성
		SmallRoom l2 = new SmallRoom(); // l2 객체 생성
		LivingRoom l3 = new SmallRoom(); 
       // 다형성을 이용 LivingRoom형 l3에 SmallRoom이 자동 형변환되어 할당

		//System.out.println(l1 instanceof l2);
        // 오류 발생 l1 istanceof 클래스가 와야함

		//System.out.println(LivingRoom instanceof SmallRoom);
        // 오류 발생 객체 instanceof 클래스가 와야함

		System.out.println(l1 instanceof LivingRoom);
        // 결과 출력 true
        // l1은 LivingRoom으로 형변환 가능

		System.out.println(l1 instanceof SmallRoom);
        // 결과 출력 false
        // 부모가 자식이 되려했으므로 불가능

		System.out.println(l2 instanceof LivingRoom);
        // 결과 출력 true
        // l2의 클래스는 LivingRoom을 상속받은 SmallRoom 이므로 형변환 가능

		System.out.println(l2 instanceof SmallRoom);
        // 결과 발생 true
        // l2는 SmallRoom으로 형변환 가능

		System.out.println(l3 instanceof SmallRoom);
        // 결과 발생 true
        // l3의 자료형은 LivingRoom 임. 부모 객체로 자식객체를 다루는 방법(다형성)을 이용함
        // SmallRoom은 자동 형변환(AutoBoxing)되어 부모 객체 l3에 할당됨.
        // 따라서 l3는 true 출력.
			
		System.out.println(l1.getClass());
		System.out.println(l2.getClass());
		
		if(l1.getClass().equals(l2.getClass())) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
}
```

<br/>

## getClass()

<br/>

* 클래스의 주소값을 리턴한다.

```java
		System.out.println(l1.getClass());
		System.out.println(l2.getClass());
		
        // 문자열로 리턴된 클래스를 비교하는 과정.
		if(l1.getClass().equals(l2.getClass())) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
```
