package com.test02;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Functional01 {

	public static void main(String[] args) {
		unaryTest();
		binaryTest();
		prediTest();
	}
	
	public static void unaryTest() {
		//[UnaryOperator]
		//특정 타입의 인자를 하나 받고, 동일 타입 객체를 리턴하는 함수형 인터페이스
		//UnaryOperator <특정 타입> 레퍼런스 변수 = 람다식
		//apply 메소드를 호출해 작업을 수행한다.
		
		UnaryOperator<String> hello = name -> "Hello" + name;
		System.out.println(hello.apply("Lambda"));
		
	}
	
	public static void binaryTest() {
		/* [BinaryOperator]
		 * 특정 타입의 인자를 2개 받고, 동일 타입 객체를 리턴하는 함수형 인터페이스
		 * BinaryOperator <특정 타입> 레퍼런스 변수 = 람다식
		 * apply 메소드를 호출해 작업을 수행한다.
		 */
		
		BinaryOperator<Integer> sum = (i,j) -> i+j;
		System.out.println(sum.apply(10, 4));
		
	}
	
	public static void prediTest() {
		/* [Predicate]
		 * 특정 타입의 인자를 하나 받아, boolean 타입으로 리턴하는 함수형 인터페이스
		 * Predicate <특정 타입> 레퍼런스 변수 = 람다식
		 * apply 메소드 사용
		 */
		
		Predicate<Integer> p = (n) -> n%2 == 0;
		
		if(p.test(5)) System.out.println("짝수입니다.");
		else System.out.println("홀수입니다.");
		
	}
	
	public static void funcTest() {
		/* [Function]
		 * 기본 함수형 인터페이스
		 * 매개변수 있고, 반환값도 있다.
		 * Function <매개변수 타입, 반환 값 타입> 레퍼런스 변수 = 람다식
		 * apply 메소드 사용
		 */
		Function<Integer, String> t = n -> (n<10) ? "0" + n : "" + n;
		System.out.println(t.apply(1));
		System.out.println(t.apply(11));
	}
	
	/* 이외에도
	 * BiFunction ==> 매개변수 2개이고, 반환값 있는 함수형 인터페이스. apply 메소드 사용
	 * Supplier ==> 매개변수 없고, 반환값만 있는 함수형 인터페이스. get 메소드 사용
	 * Consumer ==> 매개변수 있고, 반환 값 없는 함수형 인터페이스. accept 메소드 사용
	 * BiConsumer ==> 매개변수 2개 있고, 반환값 없는 함수형 인터페이스. accept 메소드 사용
	 */

}
