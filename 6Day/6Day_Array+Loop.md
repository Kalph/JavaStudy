ctrl+(numpad)- = 페이지 접기

ctrl+(numpad)+ = 페이지 펼치기

<br/>

break - 반복문을 빠져나가는 용도 

<br/>

-> 반복문은 for, while문이 해당됨 if 문은 조건문임. 

-> switch의 break는 switch문만 빠져나가는 break로 반복문의 break와는 다른 개념.

<br/>

```Java
	public void Myhome() {
		
		Scanner sc = new Scanner(System.in); 
		
		while(true) {
			System.out.println("어후 어서오세요");
			String str = sc.nextLine();
			
			if(str.equals("그만 갈게요")) {
				System.out.println("어후 들어가세요");
				break; //반복을 강제 종료함
			}
		}
	}
```

<br/>

배열 
=============

**배열은 같은 타입의 데이터를자료형의 변수를연속된 공간에 나열시키고 각 데이터에 인덱스(index)를 부여해 놓은 자료구조입니다.**

<br/>

-> 저장된 값마다 인덱스가 지정되며 인덱스는 0부터 시작한다.

<br/>

배열을 사용하면 변수 선언을 다수 수행해야 할때 이에 배열을 사용하면 간단한 프로그래밍이 가능하다.


베열은 0~ 배열의 길이(-1)까지 반복하기 때문에 반복문으로 사용이 가능하다.

<br/>

```Java
int[] arr = new int[5];

for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
```

<br/>

 배열에서 사용되는 .length는 문자열의 길이를 비교하는 length()와는 다르다. 

-> 배열의 길이는 변수로 제공된다. ( String의 문자열 길이는 메서드로 제공됨. )

<br/>

### 배열을 선언시

* -> stack 영역에 공간이 발생함. -> 값을 담는 용도는 아님

<br/>

### 배열을 할당시

* -> 메모리의 heap 영역을 통해 배열의 크기만큼 공간이 발생한다. -> 그 공간의 주소값을 stack영역의 참조형 변수에 저장하게 된다.

<br/>

* -> 요약 : 배열을 선언하면 stack 영역에 공간이 생기지만 이 공간은 값을 담는 용도가 아니며 할당을 통해 메모리의 주소(heap에 배열의 크기만큼 공간이 만들어진다. 실질적으로 메모리의 주소를 수정할 수는 없으나 주소를 참조하여 사용하는 것은 가능하다.


<br/>


### garbage collector(자동 메모리관리)

- 메모리가 부족할때 쓰레기 메모리를 정리해주는 기능

이미 지정한 배열을 다른 배열 크기를 넣어 할당하거나

null 값을 넣어주면  할당된 배열을 제거할 수 있음.

<br/><br/>

##### 참고문헌

https://wanzargen.tistory.com/15

https://hunit.tistory.com/145

