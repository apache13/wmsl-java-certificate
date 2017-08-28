package com.wealth.certificate.dumps_1z0_809_vce.question036;

public final class IceCream {
	public void prepare() {}
}
class Cake {     //if extends IceCream not compile 
	public final void bake(int min, int temp) {}
	public void mix() {}
}
class Shop {
	private Cake c = new Cake ();
	private final double discount = 0.25;
	public void makeReady () { c.bake(10, 120); }
}
class Bread extends Cake {
	public void bake(int minutes, int temperature) {}
	public void addToppings() {}
}
