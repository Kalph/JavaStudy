이차원 배열 

===================

- 여러개의 일차원 배열을 하나로 묶어놓은 것을 의미한다.

<br/>

이차원 배열이상의 배열을 다차원 배열이라고 한다. -> 실질적으론 2차원 배열 이상은 잘 사용되지 않음.

<br/>

선언을 하게 되면 Stack에 참조형 변수를 생성하게 된다. -> 할당을 하게 되면 heap 영역에 해당 크기만큼의 공간을 할당함.

<br/>

```Java
int[][] tes1;
int[] test2[];
int[] test3[][];

test1 = new int[3][4];

System.out.println("행의 길이 : " + test1.length);
System.out.println("행의 길이 : " + test1[0].length);
```

<br/>

## 가변 배열 Ragged Array

<br/>

이차원 배열 중 열의 길이를 임의로 지정해줄 수 있는데 이를 **가변 배열**이라라 부른다.

여러개의 일차원 배열을 묶은 것이 이차원 배열이다. 
* 즉 일차원 배열의 열의 길이가 꼭 같을 필요는 없는 것이다.

<br/>

```Java
int[][] test = new int[5][];
test[0] = new int[6];
test[1] = new int[4];
test[3] = new int[5];
test[4] = new int[9];
test[5] = new int[15];

int[][] test2 = {{1,2,3},{4},{5,6,7,8,9,10,11,12,13,14}};

int[][] test3 = new int[2][5];
```
