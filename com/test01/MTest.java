package com.test01;

public class MTest {
	//람다식 쓰려면 함수형 인터페이스 미리 선언해야하고, 추상 메소드 반드시 있어야한다.
	//별도로 상속을 선언할 필요는 없다.

	public static void main(String[] args) {
		
		//매개변수 없는 람다식
		//() -> {실행할 코드;};
		//() -> 실행할 코드; ====> 실행할 코드가 1줄일 경우 가능
		//별도로 상속받지 않더라도 실행된다.
		Test01 test01_1 = () -> {System.out.println("test01_1");};
		//익명 객체를 레퍼런스 변수 test01_1에 담았다.
		test01_1.prn();
		
		Test01 test01_2 = () -> System.out.println("test01_2");
		//익명 객체를 레퍼런스 변수 test01_2에 담았다.
		test01_2.prn();
		
		//매개변수 있는 람다식
		//(매개 변수) -> {실행할 코드;};
		//(매개 변수) -> 실행할 코드; ===> 실행할 코드가 1줄일 경우 가능
		//별도로 상속받지 않더라도 실행된다.
		Test02 test02_1 = (int n) -> {System.out.println("input : " + n);};
		//익명 객체를 레퍼런스 변수 test02_1에 담았다.
		test02_1.prn(3);
		
		Test02 test02_2 = (int n) -> System.out.println("input : " + n);
		//익명 객체를 레퍼런스 변수 test02_2에 담았다.
		test02_2.prn(5);
		
		//매개변수의 타입은 대부분 짐작 가능해 생략하는 경우가 많다.
		//(함수형 인터페이스에 매개변수 타입을 선언해뒀기 때문에 이를 갖고 매개변수 타입을 짐작한다.) 
		Test02 test02_3 = (n) -> System.out.println("input : " + n);
		test02_3.prn(1);
		
		//매개변수가 하나일 경우 매개변수의 괄호를 생략할 수 있다.
		Test02 test02_4 = n -> System.out.println("input : " + n);
		test02_4.prn(7);
		
		
//		Test var = n -> System.out.println("input : " + n);
		
//		이 람다식을 풀어서 쓰면 ====>
		
//		Test test = new Test() {
//			void prn(int n) {
//				System.out.println("input : " + n);
//			}
//		}
//		----------------------------
//		실행 ==> var.prn(1);
		
		//리턴 있는 람다식
		//매개변수가 1개면 리턴 생략 가능하다.
		//(매개 변수) -> 실행할 코드; ===> 실행할 코드가 1줄일 경우 가능 (return 생략됨)
		Test03 test03 = n -> n+n;
		//리턴 생략했다.
		System.out.println(test03.prn(9));
		
		//매개변수 2개와 리턴 있는 람다식
		//(매개변수1, 매개변수2) -> {실행할 코드; return 리턴 값;};
		//매개변수가 2개 이상이면 리턴 생략 불가하다.
		Test04 test04 = (i,j) -> {
			//매개변수의 타입은 대부분 짐작 가능해 생략하는 경우가 많다.
			//(함수형 인터페이스에 매개변수 타입을 선언해뒀기 때문에 이를 갖고 매개변수 타입을 짐작한다.)
			System.out.println("input : " + i + " and " + j);
			return i*j;
			//여기서는 리턴 생략 불가하다.
		};
		System.out.println(test04.prn(10, 6));
		
		//람다식을 활용한 사칙연산
		MyCalc sum = (a,b) -> a+b;
		MyCalc sub = (a,b) -> a-b;
		MyCalc mul = (a,b) -> a*b;
		
		int i = 10;
		int j = 3;
		
		System.out.println(sum.calc(i, j));
		System.out.println(sub.calc(i, j));
		System.out.println(mul.calc(i, j));
	}

}
