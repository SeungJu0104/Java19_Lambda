package com.test03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MTest {
	//스트림: 배열이나 컬렉션 같은 데이터 연속으로 하나씩 참조해 가공 처리를 할 수 있도록 도와주는 클래스 (배열의 for문 개념)
	
	public static void main(String[] args) {
		//createStream();
		//createCollection();
		pipeline();
	}
	
	//스트림
	public static void createStream() {
		//스트림: 배열이나 컬렉션 같은 데이터 연속으로 하나씩 참조해 가공 처리를 할 수 있도록 도와주는 클래스 (배열의 for문 개념)
		
		//생성
		//builder() : 스트림에 직접적으로 원하는 값을 넣을 수 있다. 값 넣으려면 add메소드 사용
		//build() : 생성한 스트림을 리턴.
		//forEach는 순서를 보장해주지 않는다.(병렬 처리할 때 드러난다.)
		Stream<String> stream01 = Stream.<String>builder().add("홍길동").add("이순신").add("이창진").build();
		stream01.forEach(System.out::println);
		
		//empty() : 빈 스트림을 생성.
		Stream<String> stream02 = Stream.empty();
		System.out.println(stream02.toArray().length);
		
		//generate(람다식) : Supplier<T>에 해당하는 람다식을 넣을 수 있다.
		//Supplier 는 매개변수 없고, 리턴 값만 있는 함수형 인터페이스이다.
		//Stream 타입과 리턴 타입은 Integer로 일치해야한다.
		//forEach는 순서를 보장해주지 않는다.(병렬 처리할 때 드러난다.)
		Stream<Integer> stream03 = Stream.generate(() -> 100).limit(3);
		//limit 없이 그냥 실행시키면 무한 반복된다. 그래서 limit로 횟수 제한을 걸어준다.
		stream03.forEach(System.out::println);
		
		//iterate(초기 값, 람다식) : 초기 값과 초기 값을 매개변수로 받아 사용하는 람다식을 이용해 스트림에 들어갈 요소를 생성한다.
		//여기서는 UnaryOperator가 쓰인다.
		//UnaryOperator 는 특정 타입의 인자를 하나 받고, 동일 타입 객체를 리턴하는 함수형 인터페이스.
		//forEach는 순서를 보장해주지 않는다.(병렬 처리할 때 드러난다.)
		Stream<Integer> stream04 = Stream.iterate(1, (i) -> ++i).limit(5);
		stream04.forEach(System.out::println);
		
		//IntStream : 정수 스트림
		//range(시작, 종료) : 시작부터 종료 전 값까지
		//Consumer가 쓰인다.
		//Consumer 는 매개변수 있고, 반환 값 없는 함수형 인터페이스
		//forEachOrdered는 순서를 보장해준다.
		IntStream range01 = IntStream.range(1, 5);
		range01.forEachOrdered((i) -> System.out.print(i + " "));
		System.out.println();
		
	}
	
	//콜렉션 스트림
	public static void createCollection() {
		//스트림: 배열이나 컬렉션 같은 데이터 연속으로 하나씩 참조해 가공 처리를 할 수 있도록 도와주는 클래스 (배열의 for문 개념)
		
		//배열 스트림
		//forEach는 순서를 보장해주지 않는다.(병렬 처리할 때 드러난다.)
		String [] arr = new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		Stream<String> stream01 = Arrays.stream(arr);
		stream01.forEach(System.out::println);
		
		//리스트 스트림
		//forEach는 순서를 보장해주지 않는다.(병렬 처리할 때 드러난다.)
		List<String> list = Arrays.asList(arr);
		//List<String> list0 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		
		Stream<String> stream02 = list.stream();
		stream02.forEach(System.out::println);
	}
	
	//리스트 스트림
	public static void pipeline() {
		//스트림: 배열이나 컬렉션 같은 데이터 연속으로 하나씩 참조해 가공 처리를 할 수 있도록 도와주는 클래스 (배열의 for문 개념)
		List <String> web28 = Arrays.asList("안해림", "주현록", "이진기" , "이예담" , "송제영" , "김송현", "태일", "이진");
		List <String> song = web28.stream().filter(name -> name.contains("송")).sorted().collect(Collectors.toList());
		//stream() : 스트림으로 바꿔준다.
		//filter() : 스트림에서 나오는 데이터 중 특정 데이터만 골라내는 역할
		//filter는 boolean 값을 리턴하는 람다식을 넣는다. (Predicate를 쓰기 때문이다.)
		//sorted() : 기본 정렬 (오름차순)
		//collect() : Stream을 다시 Collection으로 반환주는 기능
		//Collectors는 collect의 매개변수로 Collectors 클래스가 제공하는 메소드 이용.
		
		System.out.println(song);
		
		//이름이 2글자인 사람만 확인
		List <String> two = web28.stream().filter(name -> name.length() == 2).sorted().collect(Collectors.toList());
		System.out.println(two);
		//stream() : 스트림으로 바꿔준다.
		//filter() : 스트림에서 나오는 데이터 중 특정 데이터만 골라내는 역할
		//filter는 boolean 값을 리턴하는 람다식을 넣는다. (Predicate를 쓰기 때문이다.)
		//sorted() : 기본 정렬 (오름차순)
		//collect() : Stream을 다시 Collection으로 반환주는 기능
		//collect의 매개변수로 Collectors 클래스가 제공하는 메소드 이용.
		//Collectors는 상수 클래스
		
		web28.stream().filter(name -> name.contains("송")).sorted().map(w -> w.replace(w.substring(1, w.length()), "*".repeat(w.length()-1)))
		.collect(Collectors.toList()).forEach(System.out::println);
		//map () 은 값을 바꿔주는 기능을 한다.
		//map () 에는 Function(기본 함수형 인터페이스)이 사용된다.
		
		List <Integer> lotto = Stream.generate(() -> (int)(Math.random()*45)+1).distinct().limit(6).sorted().collect(Collectors.toList());
		//generate ()는 Supplier(매개변수 없고, 반환 값만 있는 함수형 인터페이스)가 사용된다.
		//limit 없으면 무한 반복되므로 limit를 이용해 갯수를 제한한다.
		//distinct () 는 중복을 제거한다.
		lotto.stream().forEachOrdered(i -> System.out.print(i + " "));
		//[] 없이 출력하기 위해 stream으로 바꿔 forEachOrdered를 이용해 원하는 형태로 출력한다.
		//forEachOrdered 는 순서 유지된다.
	}
}
