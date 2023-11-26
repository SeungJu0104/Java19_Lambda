package com.test01;

//함수형 인터페이스
//추상메소드 하나만 선언된 인터페이스
//@FunctionalInterface라고 Annotation 선언한다.
//익명 객체를 이용해 다른 클래스에서 별도 상속 없이도 간단하게 처리할 수 있다.

@FunctionalInterface
public interface Test02 {
	//매개변수 있는 추상 메소드
	public void prn(int i);
}
