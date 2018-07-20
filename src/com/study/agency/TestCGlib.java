package com.study.agency;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/*
 * 动态代理的第二种方式:CGlib
 * cglib是针对类来实现代理的,原理是对指定的业务类生成一个子类,并覆盖其中业务方法实现代理.
 * 因为采用的是继承,所以不能对final修饰的类进行代理
 */

/*
 * 1.首先定义业务类,无需实现接口(当然实现接口也是可以的,不影响)
 */
class BookImpl{
	public void addBook(){
		System.out.println("新增书籍");
	}
}
/*
 * 实现MethodInterceptor方法代理接口,创建代理类
 */
class BookCGlib implements MethodInterceptor{
	private Object target;//业务类对象,供代理方法中进行真正的业务方法调用
	
	//相当于jdk动态代理中的绑定
	public Object getInstance(Object target){
		this.target = target;//给业务方法赋值
		//创建加强器,用来创建动态代理类
		Enhancer enhancer = new Enhancer();
		//为加强器指定要代理的业务类(即:为下面生成的代理类指定父类)
		enhancer.setSuperclass(this.target.getClass());
		//设置回调:对于代理类上所有方法的调用,都会调用CallBack,而CallBack则需要实现intercept()方法进行拦截
		enhancer.setCallback(this);
		return enhancer.create();
	}

	//实现回调方法
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("-----预处理-------");
		proxy.invokeSuper(obj, args);//调用业务类(父类中的方法)
		System.out.println("-----调用后操作-----");
		return null;
	}
	
} 
/*
 * 创建业务类和代理类对象,然后通过代理类对象.getInstance(业务类对象)返回一个动态代理类对象(他是业务类的子类,
 * 可以用业务类引用指向它.最后通过动态代理类对象进行方法调用)
 */
public class TestCGlib {
	public static void main(String[] args) {
		BookImpl bookImpl = new BookImpl();
		BookCGlib cglib = new BookCGlib();
		BookImpl bookCGlib = (BookImpl) cglib.getInstance(bookImpl);
		bookCGlib.addBook();
	}
}
