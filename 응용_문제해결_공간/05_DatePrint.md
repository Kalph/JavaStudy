<br/>

```java
package myRoom.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
	public static void main(String[] args) {
		// Data 클래스 이용
		Date today = new Date();
		System.out.println(today);
		
		
		// Date 안에 Long형 숫자를 넣으면
		// 1900년 1월 1일 0시 0분 0초부터 123456789초 경과한 시간을 객체 d에 저장.
		Date d = new Date(123456789L);
		System.out.println(d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		String format1 = sdf.format(d);
		System.out.println(format1);
//		System.out.println(sdf.format(d));
		 
		// GregorianCalendar 클래스 이용
		GregorianCalendar d2 = new GregorianCalendar();
		String format2 = sdf.format(d2.getTime());
		System.out.println(format2);
		
		//Calendar 클래스 이용
		// Calendar의 생성자는 protected이므로 new 사용 불가능. 따라서 getInstance()를 이용 현재 시간 받아옴.
		Calendar d3 = Calendar.getInstance();
		// format의 사용 예 : https://hyeonstorage.tistory.com/231
		String format33 = sdf.format(d3.getTime());
		System.out.println(format33);
		
		
		d3.setTime(d);
		String format3 = sdf.format(d3.getTime());
		System.out.println(format3);
		
		int year = d3.get(Calendar.YEAR);
		int month = d3.get(Calendar.MONTH)+1;
		int date = d3.get(Calendar.DATE);
		int ampm = d3.get(Calendar.AM_PM);
		int hour = d3.get(Calendar.HOUR);
		int min = d3.get(Calendar.MINUTE);
		int sec = d3.get(Calendar.SECOND);
		
		String sAmPm = (ampm == Calendar.AM) ? "오전" : "오후";
		
		System.out.printf("%d년 %02d월 %02d일 %s %02d시 %02d분 %02d초\n",year,month,date,sAmPm, hour,min,sec);
		
	}
}
```
