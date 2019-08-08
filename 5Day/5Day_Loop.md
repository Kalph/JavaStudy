반복문
=============

<br/>

for 문과 while문으로 나눠짐

<br/>

```Java
  public void myHome() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("어후 어서오세요.");
		}
	}
```

<br/>
<br/>
  
```Java
 public void myHome2() {
	int i = 0;
	while (i < 10) { 
		System.out.println("어후 어서오세요.");
		i++;
	}
}
```

<br/>


## 랜덤 함수 -

java.lang.Math클래스에서 제공하는 random(); 

* -> 메서드를 사용해서 랜덤 값을 발생시킬 수 있음.

* -> java.lang는 import 할 필요가 없다. - 컴파일러에 의해 import java.lang.*이 생성되기 때문임.

<br/>

int random = Math.random(); // -> 0.0 ~ 0.999999사이의 랜덤 값을 발생한다

이를 정수로 변환할 시 0<= random <1 사이의 범위가 되고 

원하는 값을 곱하거나 더함으로서 범위를 수정하는 것이 가능하다.

<br/>

ex) 100~500까지의 랜덤 값을 얻으려면
    math.random() * 401 + 100  -> 100<= random < 501

<br/>

문자열의 길이를 구하는 함수 - 문자열.length()

<br/>
