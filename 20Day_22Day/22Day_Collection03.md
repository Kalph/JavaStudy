목차
================
* [Map](#Map)<br/>
* [HashMap](#HashMap)<br/>
* [TreeMap](#TreeMap)<br/>
* [Properties](#Properties)<br/><br/>

## MAP

<br/>

key와 값으로 구성되어 있다.

키와 값은 모두 객체이다.

대응관계를 쉽게 표현해주는 자료형이다.

<br/>

### HashMap

<br/>

```java
package apartment.myhome;

import java.util.HashMap;


public class StartRoom {
	public static void main(String[] args) {
		// 기존의 CheckRoom을 이용해 hm 객체 생성
		HashMap<String, CheckRoom> hm = new HashMap<>();
		
		// 저장된 키와 값 객체를 맵에 저장
		hm.put("1번", new CheckRoom("김"));
		hm.put("2번", new CheckRoom("님"));
		
		System.out.println(hm);
		
		// key 값이 다르면 같은 객체도 저장이 가능하다.
		hm.put("3번", new CheckRoom("님"));
		
		System.out.println(hm);
		
		// 새로운 키 값을 이벽하면 새로운 객체로 기존의 값이 초괴화 된다.
		hm.put("3번", new CheckRoom("담"));
		
		System.out.println(hm);
		
		// 리스트에 해당 키가 있는지 확인한다.
		System.out.println(hm.containsKey("1번"));
		
		// 1번 키에 해당하는 객체를 삭제한다.
		hm.remove("1번");
		
		
		// 아래와 같이 저장하는 방식으로 활용도 가능하다.
		CheckRoom ck = hm.get("2번");
		System.out.println(ck);
		
		// value만을 리턴해준다
		System.out.println(hm.values());
		
	}		
}
```

<br/>

### 출력 방법

<br/>

```jaba
		Set<String> keySet = hm.keySet();
		Iterator<String> it = keySet.iterator();
		System.out.println(it);
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.printf("%s %s ", key, hm.get(key));
		}
		
		System.out.println();
		System.out.println("=====");
		
		Set<Entry<String, CheckRoom>> entrySet =  hm.entrySet();
		Iterator<Entry<String, CheckRoom>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Entry<String, CheckRoom> entry = it2.next();
			System.out.println(entry);
//			System.out.printf("%s %s ", entry.getKey(), entry.getValue());
		}
```

<br/>

위의 iterator은 주소를 담아 해당되는 key와 value를  출력시키지만 entry는 entry에 모든 객체를 담아 출력시킴을 알 수 있다.

<br/>

### TreeMap

<br/>

```java
package apartment.myhome;
import java.util.TreeMap;

public class StartRoom {
	public static void main(String[] args) {
		// 기존의 CheckRoom을 이용해 hm 객체 생성
		TreeMap<String, CheckRoom> hm = new TreeMap<>();
		
		// 저장된 키와 값 객체를 맵에 저장
		hm.put("2번", new CheckRoom("김"));
		hm.put("1번", new CheckRoom("님"));
		System.out.println(hm);
	}		
}
```

<br/>

저장된 TreeMap객체 key 값을 기준으로 정렬이 된다.

출력 방식은 HashMap과 동일하다.

<br/>

```java
package apartment.myhome;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StartRoom {
	public static void main(String[] args) {
		// 기존의 CheckRoom을 이용해 hm 객체 생성
		TreeMap<String, CheckRoom> hm = new TreeMap<>();
		
		// 저장된 키와 값 객체를 맵에 저장
		hm.put("1번", new CheckRoom("김"));
		hm.put("2번", new CheckRoom("님"));
		System.out.println(hm);
		
		for(String key : hm.keySet()) {
			System.out.printf("%s %s ",key, hm.get(key));
		}
		
		System.out.println();
		
		for(Entry<String, CheckRoom> entry : hm.entrySet()) {
			System.out.printf("%s %s ", entry.getKey(), entry.getValue());
		}

	}		
}
```

<br/>

또한 위와 같이 for문을 이용해 출력하는 방법도 있다.
