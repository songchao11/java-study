package com.study.nio;

import java.nio.ByteBuffer;

import org.junit.Test;

/*
 * 1.缓冲区(Buffer):在JavaNIO中负责数据的存取.缓冲区就是数组.用于存储不同数据类型的数据
 * 
 * 根据数据类型不同(Boolean除外),提供了相应类型的缓冲区:
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 上述缓冲区的管理方式几乎一致,通过allocate()获取缓冲区
 * 2.缓冲区存取数据的两个核心方法:
 * put():存入数据到缓冲区中
 * get():获取缓冲区中的数据
 * 
 * 3.缓冲区中的四个核心属性:
 * capacity: 容量,表示缓冲区中最大存储数据的容量.一旦声明,不能改变
 * limit: 界限,表示缓冲区中可以操作数据的大小.limit后的数据不能进行读写
 * position: 位置,表示缓冲区中正在操作数据的位置
 * mark: 标记,表示记录当前position的位置.可以通过reset()恢复到mark的位置
 * 
 * 0 <= mark <= position <= limit <= capacity
 * 
 * 4.直接缓冲区与非直接缓冲区
 * 非直接缓冲区:通过allocate()方法分配缓冲区,将缓冲区建立在JVM的内存中
 * 直接缓冲区:通过allocateDirect()方法分配直接缓冲区,将缓冲区建立在物理内存中.可以提高效率
 */
public class TestBuffer {

	@Test
	public void test1(){
		String str = "abcde";	
		//1.分配一个指定大小的缓冲区
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		System.out.println("--------allocate()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//2.利用put()方法存入数据到缓冲区
		bbf.put(str.getBytes());
		System.out.println("--------put()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//3.利用flip()方法切换到读模式
		bbf.flip();
		System.out.println("--------flip()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//4.利用get()读取缓冲区中的数据
		byte[] b = new byte[bbf.limit()];
		bbf.get(b);
		System.out.println("--------get()-----------");
		System.out.println(new String(b, 0, bbf.limit()));
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//5.rewind()可重复读
		bbf.rewind();
		System.out.println("--------rewind()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//6.clear()清空缓冲区,但是缓冲区内的数据并没有被清除,只是处于"被遗忘状态"
		bbf.clear();
		System.out.println("--------clear()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		System.out.println((char)bbf.get());
	}
	
	@Test
	public void test2(){
		String str = "abcde";
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		bbf.put(str.getBytes());
		bbf.flip();
		byte[] b = new byte[bbf.limit()];
		bbf.get(b, 0, 2);
		System.out.println(new String(b, 0, 2));
		System.out.println(bbf.position());
		//mark 标记
		bbf.mark();
		bbf.get(b, 2, 2);
		System.out.println(new String(b, 2, 2));
		System.out.println(bbf.position());
		//恢复到mark的位置
		bbf.reset();
		System.out.println(bbf.position());
		//判断缓冲区中是否还有剩余数据
		if(bbf.hasRemaining()){
			System.out.println(bbf.remaining());
		}
	}
	
	@Test
	public void test3(){
		ByteBuffer bbf = ByteBuffer.allocateDirect(1024);
		System.out.println(bbf.isDirect());
	}
	
}
