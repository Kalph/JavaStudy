목차
=========
* [네트워크](#네트워크 )</br>
* [소켓 프로그래밍](#소켓-프로그래밍)</br>
* [TCP](#TCP-TransMission-Control-Protocol)</br>
* [UDP](#UDP-User-Datagram-Protocol)</br></br>


## 네트워크 

</br>

[https://cornswrold.tistory.com/67](https://cornswrold.tistory.com/67)</br>

</br>

## 소켓 프로그래밍

</br>

소켓을 이용한 통신 프로그래밍을 뜻함

소켓(socket)이란 프로세스간의 통신에 사용되는 양쪽 끝단(endpoint)을 의미함

</br>

## TCP(TransMission Control Protocol) 

</br>

연결성 통신 방법 

실시간 소통 방식, 신뢰성이 높다. -> 네트워크 부담이 크다.

</br>

```java
	public void start() {
		// 서버의 포트 번호 설정
		int port = 8888;
		
		try {
			// 서버 소켓 port 매개변수를 가진 serverSocket객체 server 생성
			ServerSocket server = new ServerSocket(port);

			// 아직 client 측에서 연결 요청이 오지 않았음으로 대기
			System.out.println("클라 요청 대기 중");
			
			// Client 측에서 연결 요청이 올 경우 Socket을 이용해 접속한 정보를 cli에 저장
			Socket cli = server.accept();
			// Client 측의 아이피를 보여주며 연결 요청 메시지 출력.
			System.out.println(cli.getInetAddress().getHostAddress() + "가 연결을 요청함");
			
			// 클라이언트 측에서 ois 변수를 통해 받아온 정보들을 oos 변수를 통해 uploaded.dat로 작성한다.
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("uploaded.dat"));
			ObjectInputStream ois = new ObjectInputStream(cli.getInputStream());
			
			// 모든 작성이 끝나고 client측의 구동을 종료시키기 위해 pw변수 이용
			PrintWriter pw = new PrintWriter(cli.getOutputStream());
			
			// 반복문이용
			while(true) {
				// 클라이언트 측에서 입력한 정보를 받아 obj에 저장
				Object obj = ois.readObject();
				
				// client 측에서 마지막에 null을 추가해줌으로 해당 문자가 들어가면 반복문을 탈출.
				if(obj==null) {
					break;
				}
				
				// flush()를 통해 데이터를 내보낸다.
				oos.writeObject(obj);
				oos.flush();
			}

			// 모든 저장이 끝났으면 pw로 클라이언트 측에 exit를 보냄으로서 모든 저장이 끝났음을 알린다.
			pw.print("exit");
			pw.flush();
			
			pw.close();
			oos.close();
			ois.close();
			cli.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
```

</br>

```java
	public void start() {
		// 클라이언트 측은 서버의 아이피와 포트번호를 알고 있어야 한다.
		int port = 8888;
		// 초기 서버의 아이피는 모른다는 가정을 하고 null을 넣는다.
		String ser = null;
		
		try {
			// ser의 아이피는 내 컴퓨터의 아이피로 설정한다.
			ser = InetAddress.getLocalHost().getHostAddress();
			
			// Socket을 통해 아이피, 포트를 넣어주어 soc 변수에 저장함으로 서버에 연결을 시도한다.
			Socket soc = new Socket(ser,port);
			
			// 만일 soc에 값이 담긴다면 정상적으로 연결이 되었음을 의미함.
			if(soc!=null) {
				
				// ois를 통해 myRoom.dat 파일을 읽어들인다. -> 이 파일을 읽어서 서버측으로 보내면
				// 서버측에서 받은 정보를 uploaded.dat로 작성하여 저장시킬 것이다.
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myRoom.dat"));
				
				ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());

				// br은 서버 측에서 보내는 메시지를 인식하기 위한 변수이다.
				BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				
				try {
					// 반복문으로 진입.
					while(true) {
						// obj가 계속해서 myRoom의 정보를 읽어들이게 하고
						Object obj = ois.readObject();
						// oos를 통해 읽어들인 정보를 서버측으로 보내준다.
						oos.writeObject(obj);
						// flush()를 통해 데이터를 내보낸다.
						oos.flush();
					}
					// 반복문을 탈출하지 못할 경우는 모든 파일을 읽고 나서 오류가 발생할 때 뿐이다. -> 그 오류를 예외처리 한다.(EOFException)
				} catch(EOFException e) {
					// oos에 null을 넣어 입력함으로 오류가 발생하는 대신 null이 읽어들인 myRoom데이터 마지막에 저장되도록 한다.
					oos.writeObject(null);
					oos.flush();
				}
				
				// 서버측으로부터 문자를 읽어들여 만일 문자가
				String rem = br.readLine();
				// exit라면 서버의 모든 작업이 끝났다는 의미이므로 클라이언트 측도 모든 작업을 종료시켜 준다.
				if(rem.equals("exit")) {
					ois.close();
					oos.close();
					br.close();
					soc.close();
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
```

</br>

```java
package apartment.myhome;


public class StartRoom{
	public static void main(String[] args) {
		LivingRoom lr = new LivingRoom();
		lr.start();
	}
}
```

</br>

```java
package apartment.myhome;

public class StartRoom2 {
	public static void main(String[] args) {
		CheckRoom cr = new CheckRoom();
		cr.start();
	}
}
```

</br>

실행 시킬 때에는 server -> client 순으로 구동을 시켜야 오류가 발생하지 않는다.

</br>

## UDP(User Datagram Protocol)

</br>

비연결형 통신 방법

신뢰성이 떨어진다

네트워크 부담이 비교적 적다

</br>

```java
public void start2() {
		try {
			// 서버측 포트 설정. UDP는 비연결형 방식임.
			int port =8888;
			// 각각 사용할 변수를 만든다.
			DatagramSocket soc = new DatagramSocket();
			DatagramPacket inp,oup;
			
			// 클라이언트의 ip를 받아올 msg 변수. 
			byte[] msg = new byte[4];
			byte[] omsg;
			
			while(true) {
				// inp를 통해 클라이언트측에서의 정보를 받아 입력시킨다.
				inp = new DatagramPacket(msg, msg.length);
				// receive를 통해 inp는 클라이언트가 send()를 통해 입력시키는 정보를 저장하게 된다.
				soc.receive(inp);
				
				// 클라이언트 측의 아피와 포트를 저장해놓는다.
				InetAddress ad = inp.getAddress();
				int port2 = inp.getPort();
				
				// 서버측에서는 클라이언트 측에 데이터를 입력한 시간을 보낸다.
				SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm:dd");
				String time = sdf.format(new Date());
				
				// 서버측에서 클라이언트측에 현재 시간을 보내기 위해 해당 String을 byte로 쪼개 준다.
				omsg = time.getBytes();
				
				// oup 변수에 클라이언트 측으로 보낼 정보와 클라이언트의 아이피, 포트를 입력시켜 저장하고
				oup = new DatagramPacket(omsg, omsg.length, ad, port2);
				// send()를 통해 클라이언트에게 oup의 정보를 보낸다.
				soc.send(oup);
				
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

</br>

```java
public void start2() {
		// 서버측에서 전달하는 정보를 받기위한 msg변수 선언
		byte[] msg = new byte[100];
		
		try {
			// 소켓 ds 변수를 만들고
			DatagramSocket ds = new DatagramSocket();
			
			// 클라이언트 측에서 서버 측에 먼저 정보를 보낼 것임으로 아이피와 포트를 알고 있어야 함
			// 따라서 아이피와 포트 정보를 미리 설정하여 저장해준다.
			InetAddress ser = InetAddress.getLocalHost();
			int port = 8888;
			
			// 서버측에 자신의 클라이언트 측의 아이피와 포트를 알리기 위해 패킷을 넣어 보낸다.
			DatagramPacket ods = new DatagramPacket(msg, 1, ser, port);
			ds.send(ods);

			// 서버측에서 받은 정보를 ois 변수에 저장시킨다.
			DatagramPacket ois = new DatagramPacket(msg, msg.length);
			ds.receive(ois);
			
			// 바이트 형식이므로 문자열로 변환시켜 출력시켜준다.
			System.out.println(new String(ois.getData()));

			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

</br>

```java
package apartment.myhome;


public class StartRoom{
	public static void main(String[] args) {
		LivingRoom lr = new LivingRoom();
		lr.start2();
	}
}
```

</br>

```java
package apartment.myhome;

public class StartRoom2 {
	public static void main(String[] args) {
		CheckRoom cr = new CheckRoom();
		cr.start2();
	}
}
```
