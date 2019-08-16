if(str.toUpperCase().equals("Y")) {

if(str.equalsIgnoreCase("Y")) { 

<br/>

// 우클릭 Source . (Alt + shift + s ) 

// 생성자 : Generate C'o'nstructor using Field 클릭 ( 단축키 - -> o )

// getter/setter : Gene'r'ate Getters and Setters 클릭( 단축키 -> r ) 

<br/>


```Java
package my.room.controller;

import java.util.Arrays;
import java.util.Scanner;

import my.room.model.vo.Product;

public class ProductController {
	private Product[] pro = null;
	public static int count;
	Scanner sc = new Scanner(System.in);
	{
		pro = new Product[10];
	}
	
	public void mainMenu() {
		int num=0;
		
		do {
			System.out.println(count);
			System.out.println("===== 제품 관리 메뉴 =====");
			System.out.println("1.제품 정보 추가 \n2.제품 정보 조회 \n3.제품 정보 삭제\n4.제품 정보 수정\n5.제품 정보 검색"
					+ "\n9.프로그램 종료");
			System.out.print("번호 입력 : ");
			num = sc.nextInt();
			sc.nextLine();
			switch(num){
			case 1: productInput(); break;
			case 2: productPrint(); break;
			case 3: productDelete(); break;
			case 4: modifyProduct(); break;
			case 5:	productSearch(); break;
			case 9: System.out.println("프로그램이 종료됩니다."); return;
			}
			
		}while(!(num==9));
		
	}
//	 aaa.toUppercase().equals("n")
	public void productInput() {
//		System.out.println(count);
		
		System.out.print("제품 번호 : ");
		int pId = sc.nextInt();
		sc.nextLine();
		System.out.print("제품명 : ");
		String pName = sc.nextLine();
		System.out.print("제품 가격 : ");
		int price = sc.nextInt();
		System.out.print("제품 세금 : ");
		double tax = sc.nextDouble();
		
		pro[count] = new Product(pId, pName, price, tax);
	}
	
	public void productPrint() {
		if(count==0) {
			System.out.println("등록된 제품이 없습니다.");
			return;
		}
		for(int i=0; i<count; i++) {
			if(pro[i]==null) {
				continue;
			}
			System.out.println(pro[i].information());
		}
	}
	
	public void productDelete() {
		boolean chk = false;
		if(count==0) {
			System.out.println("삭제할 제품이 없습니다.");
			return;
		}
		
		System.out.print("삭제할 제품 번호를 입력하세요 : ");	
		int search = sc.nextInt();
		for(int i=0; i<count; i++) {
			if(pro[i].getpId()==search) {
				System.out.println("삭제되었습니다.");
				pro[i]=null;
				chk=true;
				ArrayLeftSort();
				return;
//				pro[i] = null;
//				ArrayLeftSort();
//				return;
			}
			
			if(chk==false) {
				System.out.println("제품 번호가 잘못 입력되었습니다. 다시 입력하세요.");
				productDelete();
			}
		}
	}
	
	public void modifyProduct() {
		int num=0;
		int chk=-1;
		System.out.println("==== 제품 정보 수정 ====");
		while(!(num==9)) {
			System.out.print("변경할 제품명 입력 : ");
			String name = sc.nextLine();
			
			// 등록된 제품이 없는 경우 비교
			if(count==0) {
				System.out.println("등록된 제품이 없습니다.");
				return;
			}
			
			for(int i=0; i<count; i++) {

				// 문자열 비교해서 맞을경우 chk에 해당하는 배열 번호 저장
				if(pro[i].getpName().equals(name)) {
					chk = i;
					break;
				}
			}
			
			if(chk==-1) {
				System.out.println("해당 제품은 등록된 제품이 아닙니다.");
				return;
			}
			
			System.out.println("==== 제품 정보 ====");
			// 해당되는 배열 번호의 제품 정보 출력
			System.out.println(pro[chk].information());
			
			System.out.println("\n1.제품 번호 변경\n2.제품명 변경" + "\n3.제품 가격 변경"
				+ "\n4.제품 세금 변경\n9.이전메뉴로");
			System.out.print("메뉴 번호 선택 : ");
			num = sc.nextInt();
			sc.nextLine();
			switch(num){
			case 1: System.out.print("변경할 번호 : "); pro[chk].setpId(sc.nextInt()); sc.nextLine(); break;
			case 2: System.out.print("변경할 제품명 : "); pro[chk].setpName(sc.nextLine()); break;
			case 3: System.out.print("변경할 가격 : "); pro[chk].setPrice(sc.nextInt()); sc.nextLine(); break;
			case 4: System.out.print("변경할 세금 :"); pro[chk].setTax(sc.nextDouble()); sc.nextLine(); break;
			case 9: return;
			}
		}
	}
	
	public void productSearch() {
		int chk=0;
		System.out.print("검색할 제품명 : ");
		String search = sc.nextLine();
		for(int i=0; i<count; i++) {
//			if(pro[i]==null) {
//				continue;
//			}
			
			// 문자열 비교해서 맞을경우 chk에 해당하는 배열 번호 저장
			if(pro[i].getpName().equals(search)) {
				chk = i;
				break;
			}
		}
		System.out.println("검색된 제품의 정보 : " + 
		pro[chk].information());
	}
	
	
	public void ArrayLeftSort() {
		int chk=0;
		while(chk<count) {
			if(pro[chk]==null) {
				pro[chk]=pro[chk+1];
				pro[chk+1]=null;
				count--;
			}
			chk++;
		}
	}
}
```

<br/>
<br/>


```Java
package my.room.model.vo.Product;

import my.room.controller.ProductController;

public class Product {
	private int pId;
	private String pName;
	private int price;
	private double tax;
	
	public Product() {}

	public Product(int pId, String pName, int price, double tax) {
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.tax = tax;
		ProductController.count++;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public String information() {
		return "제품 번호 : " + pId + ", 제품명 : " + pName + ", 제품 가격  : " + price + ", 제품 세금 : " + tax; 
	}
}
```

<br/>
<br/>

```Java
package my.room.start.run;

import my.room.controller.ProductController;

public class Run {
	public static void main(String[] args) {
		ProductController pt = new ProductController();
		pt.mainMenu();
	}
}
```
