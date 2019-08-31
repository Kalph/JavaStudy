목차
===============
* [이클립스 단축키](#이클립스-단축키) <br/>
* [IO](#IO) <br/>
* [1-1. FILE 테스트](#1-1-file-테스트) <br/>
  * [1-2. FileByte](#1-2-filebyte-테스트) <br/>
  * [1-3. 이미지 파일을 바이트 기반으로 읽어오고 저장하기](#1-3-이미지-파일을-바이트-기반으로-읽어오고-저장하기) <br/>
  <br/>
* [2-1 FileChar 테스트](#2-1-filechar-테스트) <br/>
* [write() 상세 사용법](#2-2-write-상세-사용법) <br/>

<br/>

## <이클립스 단축키>

Ctrl + Shift + F4 : 열린 파일을 모두 닫음

ctrl + 1 - 오류 메시지 해결 픽스 퀵 픽스

F3 : 선언된 변수나 메소드 정의로 이동

<br/>

기반 스트림과 보조 스트림의 차이.

보조 스트림은 단독으로 사용할 수 없다.

<br/>

## IO

<br/>

Java에서 I/O는 java.io 패키지에 클래스가 정의되어 있다.

<br/>

[[JAVA] I/O 입출력 클래스의 종류](https://hyeonstorage.tistory.com/250)

<br/>

## 1-1 FILE 테스트 

<br/>

java.i의 File 클래스를 이용한 파일 생성을 해본다.

<br/>

```java
import java.io.File;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		try {
			File f2 = new File("myRoom.txt"); // 메모리에 객체로 있는 상태
			f2.createNewFile(); // 파일 생성
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

<br/>

위와 같은 코드로 인해 현재 프로젝트를 새로고침 하면 mRoom.txt라는 파일이 생성되었음을 알 수 있다.

예외처리를 한 이유는 컴파일러에서 발생할 수도 있는 IOException대한 예외처리를 요구했기 때문이다.

<br/>

```java
import java.io.File;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		try {
			File f2 = new File("D:\\myRoom\\myRoom.txt"); // 메모리에 객체로 있는 상태
			f2.createNewFile(); // 파일 생성
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

<br/>

또한 위와 같이 \\를 두 번 붙임으로서 \를 인식하게 시켜 상대적으로 경로를 지정해 줄 수도 있다. 

* 다만 이 경우 실제로 경로가 존재하지 않는다면 '지정된 경로를 찾을 수 없습니다.' 라는 에러가 발생하게 된다.

<br/>

```java
import java.io.File;
import java.io.IOException;

public static void main(String[] args) {
		
		try {
			File f2 = new File("D:\\myRoom\\temp");
			f2.mkdir();
//          f2.mkdirs(); // 경로상의 모든 디렉토리 생성
			
			File f4 = new File("D:\\myRoom\\temp\\test.txt");
			f4.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

이 경우 위처럼 mkdir명령어를 이용해 먼저 폴더를 만들어주고, 이후에 파일을 생성하면 문제가 없다.

이 외에도 mkdirs라는 명령어가 있다.

<br/>

```java
import java.io.File;
import java.io.IOException;

public static void main(String[] args) {
		
		try {
			File f2 = new File("D:\\myRoom\\temp\\test.txt");
			f2.mkdir();
			f2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

<br/>

그럼 f2.mkdir로 폴더를 생성하고 f2.createNewFile()로 파일을 생성하면 아까보다 더 간단할 것 같지만

<br/>

위의 코드는 정상 동작하지 않는다. f2.createNewFile() 부분에서 IOException - 지정된 경로를 찾을 수 없다는 에러가 발생하기 때문이다. 

<br/>

* 만약 정상적으로 동작한다면 이미 해당 경로의 temp 폴더가 이미 있기 때문일테니 지우고 다시 실행하면 오류를 확인 할 수 있다.

<br/>

f2.delete

<br/>

delete()는 파일이나 폴더를 제거할 때 사용한다.

파일을 지울때는 - 파일의 내부값을 비워줘야 하며, 디렉토리 또한 내부의 파일이나 디렉토리가 모두 삭제된 상태여야 한다.

<br/>

## 1-2. FileByte 테스트

<br/>

먼저 파일을 프로그램으로부터 내보내는 것을 실습한다.

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		FileOutputStream fout = null;
		// fout를 밖에서 선언한 이유는 try 부분 안에서 finally를 진행할 때
//      fout를 인식하지 못하기 때문이다.

		try {
			fout = new FileOutputStream("livingRoom.txt");

//          아래의 코드들은 다양한 방법을 통해서 fout의 만들어진 livingRoom 파일에 텍스트를
//          입력하였다.
//          이 경우 반드시 byte 단위가 와야 하며 따라서 ' ' 를 통해 값들을 입력한 방식이다.
			fout.write(65);
			fout.write('A');
			fout.write('ㅎ');
			fout.write('히');
			
			fout.write(' '); // 공백 처리
		
//          여러개의 값을 입력하고 싶을 경우엔 이 방법을 사용한다.
			byte[] by = {65,66,67};
			fout.write(by);
			
			fout.write(' '); // 공백 처리
			
			fout.write(by,0,1); // 배열의 저장된 내용중 0번째부터 1번째 만큼 쓰겠다는 의미.
            // 65의 아스키코드 A가 추가되었음을 알 수 있다.

		} /*catch (FileNotFoundException e) {
			e.printStackTrace();*/
			// 다형성을 적용하여 IOException은 FileNotFoundException의 부모이기 때문에
            // 생략한 모습이다.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fout.close(); // 파일을 닫아줬으며 이 경우 생기는 오류를 예외처리 하였다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
```

<br/>

이번에는 파일을 읽어오는 방법을 실습한다.  

<br/>

```java
import java.io.FileInputStream;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		// finally를 진행하기 위해 fis를 전역변수로 선언해준 모습
		FileInputStream fis = null;
		try {
			// 상대 경로 지정 현재 이 클래스가 있는 자바 프로젝트의 위치부터 경로를 잡아온다. 
			// 생성했을때도 상대경로로 생성했기 때문에 가능
			fis = new FileInputStream("living.txt");
			int value = 0;
			while((value=fis.read()) != -1) {
				System.out.println((char)value);
			
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
```

<br/>

위의 코드에서 read()라는 메소드를 사용하였다 해당 read에 커서를 누르고 f3을 누르면 해당 read가 선언된 내부로 들어갈 수 있다.

<br/>

```java
    public int read() throws IOException {
        return read0();
    }

    private native int read0() throws IOException;
```

<br/>

형태를 살펴보면 public 정수 형태로 반환하는 read는 예외를 IOException에게 떠넘긴다는 의미이다.

<br/>

아래 read0은 native라는 단어가 눈에 띄는데 이는 자바가 아닌 언어(C,C++)로 구현한 후 자바에서 사용하려고 할 때 JNI(Java Native Interface)를 활용한다.

<br/>

## 1-3. 이미지 파일을 바이트 기반으로 읽어오고 저장하기

<br/>

```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("samplepng");
			fos = new FileOutputStream("sampleCopy.png");
			
			// 보조 스트림 이용해서 저장함으로서 읽어오고 출력하는 속도를 향상 시킴. 
			BufferedInputStream fis2 = new BufferedInputStream(fis);
			BufferedOutputStream fos2 = new BufferedOutputStream(fos);
			
			byte[] by = new byte[1024];
			
			int cnt = 1;
			int input =0;
			
			while((input = fis2.read(by)) != -1) {
				fos2.write(by,0,input);
				System.out.println(cnt++ + "kb 전송");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
```

<br/>

```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		try(BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream("sample.txt"));
			BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream("sampleCopy.txt"));) {
			
			
			int cnt =1;
			int input = 0;
			while((input = bis.read(new byte[1024])) != -1) {
				bos.write(new byte[1024], 0, input);
				System.out.println((cnt++) + "kb 전송");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

<br/>

위의 코드는 try with resources를 이용하는 것으로 try() 안에 해당 스트림을 모두 선언함으로서 finally의 close()를 생략할 수 있게 되는 것이다.

<br/>

[중첩 try with resources 는 어떻게 작동할까?](https://multifrontgarden.tistory.com/192)

<br/>

## 2-1. FileChar 테스트

<br/>

```java
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test {
	public static void fileSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("char.txt", true);
			fw.write("hello ");
			fw.write("my\nRoom", 0, 5); // my\nRo 출력 확인
			fw.write(' ');
			
			char[] cArr = { 'i', 'a', 'm','i','s' };
			fw.write(cArr); // iamis 출력 확인
			fw.write("\n");
			fw.write(cArr, 1, 3); // ami 출력 확인

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void fileOpen() {
		FileReader fr = null;
		try {
			fr = new FileReader("char.txt");
			int value =0;
			
			while((value = fr.read()) != -1) {
				System.out.println((char)value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		fileSave();
		fileOpen();
	}
}
```

<br/>

먼저 위의 코드는 하나의 클래스 안의 static 클래스 두 개를 만들어 진행하였다.

<br/>

## 2-2 write() 상세 사용법

<br/>

```java
fw.write("my\nRoom", 0, 5); // my\nRo 출력 확인
```

<br/>

위 코드는 my\nRoom 이라는 문자열에서 0부터 5개를 읽어 작성하겠다는 의미이다.

<br/>

```java
fw.write("my\nRoom", 0, 7); // \n도 하나의 문자로 인식 따라서 0의 위치부터 7개의 문자를 출력

fw.write(my\nRoom",1,7); // 오류 발생 -> StringIndexOutOfBoundsException - 
// 1의 위치부터 읽어온다면 즉, y \n R o o m 은 총 6개임. 7번째 위치의 문자는 존재X

char[] cArr = { 'i', 'a', 'm','i','s' };
fw.write(cArr, 2, 3); // ami 출력 확인 

fw.write(cArr, 2, 4); // 마찬가지로 오류 발생
//cArr[2] 의 위치는 'm' 여기서 4개의 숫자를 읽어올수는 없음 
// 마지막 cArr[5] 는 존재하지 않음 따라서 오류 발생.
```
