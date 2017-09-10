package com.wealth.certificate.dumps_1z0_809.question079;
@FunctionalInterface
public interface Moveable<Integer> {
	
	public default void walk(Integer distance) {System.out.println("Walking");}

	public void run(Integer distance);
	//@Override
	//public String equal(Object o1);
}
interface MyMoveable extends Moveable<Integer>{
	public default void walk(Integer distance) {System.out.println("Walking 2");};
}
class MyClass implements MyMoveable{

	@Override
	public void run(java.lang.Integer distance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walk(java.lang.Integer distance) {
		// TODO Auto-generated method stub
		MyMoveable.super.walk(10);	//if abst not call
		this.walk(11);
	}
	
}