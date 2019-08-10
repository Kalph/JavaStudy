<br/>

ctrl + home = 코드 시작 패키지 부분이동

ctrl + end = 코드 끝 으로 패키지 끝으로 이동

<br/>

ctrl + 마우스 좌 클릭 = 내가 뜯어보고 싶은 소스 보기(external location 에서 경로 지정을 할 때

자바 폴더의 - src 누르고 - 그 외 java api 8  - https://docs.oracle.com/javase/8/docs/api/(현재 자바가 설치된 버전에 맞는 api 리스트 경로) 로 이동하여 제공하는 api 확인 가능.

<br/>

api - 중 자바단에서 열리는 clone의 앞에 native는 자바에서 개발된 메서드 들이 아님.

다른 언어를 가져온 것이기 때문에 소스코드를 볼 수 없다.

<br/>

## 배열

<br/>

배열을 선언하고 아무런 값도 할당하지 않으면 jvm은 int형 배열에 0을 char형 배열에 공백을 String형 배열에는 null을 자동으로 할당시켜 준다.

<br/>

## 배열 복사

<br/>

### 얕은 복사 - 배열의 주소를 복사

<br/>

```Java
	public void myHome() {
		int[] origin = { 1, 2, 3, 4, 5 };

		int[] copy = origin;

		System.out.println("원본 배열");
		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println();

		System.out.println("복사본 배열");
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();

		copy[2] = 0;

		System.out.println("값 변경 ");

		System.out.println("원본 배열");
		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println();

		System.out.println("복사본 배열");
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();
	}
```

<br/>

### <알 수 있는 것>

얕은 복사로 복사한 copy 배열의 값을 수정했으나 origin 배열의 2인덱스 값도 0으로 수정된 것임을 알 수 있음.

*이는 서로의 주소값이 같은 곳을 참고 하고 있기 때문임 -> 같은 주소를 가지고 있다.


<br/>
<br/>


### 깊은 복사 - 동일한 배열을 생성하여 배열의 내부 값들을 복사

<br/>

```Java
	public void myHome() {
		int[] origin = { 1, 2, 3, 4, 5 };

		int[] copy = new int[5];
		for (int i = 0; i < origin.length; i++) {
			copy[i] = origin[i];
		}
```
<br/>

 기본적으로 깊은 복사를 하려면 위와 같이 for문을 돌려 copy의 인덱스에 origin의 값을 하나씩 넣어주는 방법이 있다.

<br/>

<br/>

* Syste.marraycopy();  

* Array.copyOf();

* .clone();

<br/>

그 외에도 위와 같이 활용할 수 있는 메서드가 존재한다.

<br/>

Arrays.sort() = 배열 정렬 메서드(오름차순으로 정렬해준다)

System.out.println(Arrays.toString()); // 배열을 출력시켜서 값을 확인할 때 유용히 사용 가능
