package com.sist.spring2;

public interface Hello {
	public void display();
	// 인터페이스 - 구현 된 메소드도, 구현 안 된 메소드도 갖다 쓸 수 있다!★★★ 
	// - 인터페이스에서 갖다쓸 수 있는 메소드: 1) default 2) static 
	public default void sayHello(){}
	public static void sayHello2(){}
}
