package com.study.agency;

/*
 * 静态代理模式
 */
//接口
interface ClothFactory{
	void productCloth();
}

//被代理类(目标对象)
class NickClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nick工厂生产Nick");
	}
	
}

//代理类(代理对象)
class ProxyFactory implements ClothFactory{

	//接收保存目标对象
	ClothFactory clothFactory;
	
	//创建代理类的对象时,实际传入一个被代理类的对象
	public ProxyFactory(ClothFactory cFactory){
		this.clothFactory = cFactory;
	}
	
	@Override
	public void productCloth() {
		System.out.println("代理类开始执行,收代理费");
		clothFactory.productCloth();
	}
	
}

public class TestClothProduct {

	public static void main(String[] args) {
		NickClothFactory nick = new NickClothFactory();
		ProxyFactory pro = new ProxyFactory(nick);
		pro.productCloth();
	}
}
