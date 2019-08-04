```Java
  public void myhome {
		String room = "123456789";
		// int temRoom = Character.getNumericValue(room); 
		// 오류 Character.getNumericValue(); 은 Char을 Int로 변환할 때 사용됨
		int livingRoom = Character.getNumericValue(room.charAt(7));
		System.out.printf("%d\n", livingRoom);

		// int temRoom2 = Integer.parseInt(room.charAt(7));
		// 오류 Integer.parseInt(); 은  String을 Int로 변환할 때 사용됨
		int livingRoom2 = Integer.parseInt(room);
		System.out.printf("%d\n", livingRoom2);
	}
```
