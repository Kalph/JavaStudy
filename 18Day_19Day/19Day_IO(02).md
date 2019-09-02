목차
=========
* [1. 콘솔 입출력 테스트](#1-콘솔-입출력-테스트) <br/>
* [2. 버퍼 입출력 테스트](#2-버퍼-입출력-테스트) <br/>
* [3. 데이터 입출력 테스트](#3-데이터-입출력-테스트) <br/>
* [4. 오브젝트 스트림](#4-오브젝트-스) <br/>

<br/>

## 1. 콘솔 입출력 테스트

<br/>

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.print("입력 : ");
			String input = br.readLine(); // readLine은 한 줄씩 입력받는다.
			System.out.println("입력한 값 : " + input);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			String input = "hello";
			bw.write(input);
			// try-with-resources로 bw.close()가 생략되었다.
            // bw.close()가 진행되면 자동으로 flush 처리를 해준다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} 
```

<br/>

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.print("입력 : ");
			String input = br.readLine();
			System.out.println("입력한 값 : " + input);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStreamWriter isw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(isw);
		try{
			String input = "hello";
			bw.write(input); // 버퍼에 쌓는 의미
			bw.flush(); // 콘솔에 출력하는 의미 위의
			String input2 ="myName";
			bw.write(input2);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
                bw.close();
				isw.close(); // 이 부분은 생략 가능. 
                             // bw.close() 내부적으로 안에서 사용하고 있는 스트림을
                             // close() 하라고 호출하기 때문. 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
```

<br/>

## 2. 버퍼 입출력 테스트

<br/>

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("buffer.txt"))){
			bw.write("hi\n");
			bw.write("my name");
			bw.newLine(); // newLine을 통해 개행 가능
			bw.write("myRoom");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader("buffer.txt"))){
			String input ="";
			while((input=br.readLine()) != null) { 
				// String 단위로 읽어오고 있으므로 초과해서 읽을 경우는 null인 경우임
				// 따라서 null이  아닌 경우만 출력
				System.out.println(input);
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

## 3. 데이터 입출력 테스트

<br/>

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("data.txt"))){
			// 여러가지 입력 방식
			dout.writeUTF("구라");
			dout.writeByte('a');
			dout.writeChar('a');
			dout.writeDouble(11.1);
			dout.writeInt(1);;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"))){
			// 반복문 이용 읽어올 수 없을 경우 EOFException 오류 발생 아래에서 예외처리로 해결.
			// \t를 통해 문자열 출력 형태를 가꿈.
			while(true) {
				System.out.println(dis.readUTF() + "\t" + dis.readByte() + "\t" 
						+ dis.readChar() + "\t" + dis.readDouble() + "\t" + dis.readInt());
			}
			
		} catch(EOFException e){
			System.out.println("모든 파일 읽어옴.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

<br/>

## 4. 오브젝트 스트림

<br/>

[[JAVA] 객체 직렬화 ObjectInputStream / ObjectOutputStream](https://hyeonstorage.tistory.com/252)

<br/>

[자바 객체 입출력 보조 스트림 - ObjectInputStream , ObjectOutputStream](https://altongmon.tistory.com/276)

