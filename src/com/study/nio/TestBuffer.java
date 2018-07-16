package com.study.nio;

import java.nio.ByteBuffer;

import org.junit.Test;

/*
 * 1.������(Buffer):��JavaNIO�и������ݵĴ�ȡ.��������������.���ڴ洢��ͬ�������͵�����
 * 
 * �����������Ͳ�ͬ(Boolean����),�ṩ����Ӧ���͵Ļ�����:
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * �����������Ĺ���ʽ����һ��,ͨ��allocate()��ȡ������
 * 2.��������ȡ���ݵ��������ķ���:
 * put():�������ݵ���������
 * get():��ȡ�������е�����
 * 
 * 3.�������е��ĸ���������:
 * capacity: ����,��ʾ�����������洢���ݵ�����.һ������,���ܸı�
 * limit: ����,��ʾ�������п��Բ������ݵĴ�С.limit������ݲ��ܽ��ж�д
 * position: λ��,��ʾ�����������ڲ������ݵ�λ��
 * mark: ���,��ʾ��¼��ǰposition��λ��.����ͨ��reset()�ָ���mark��λ��
 * 
 * 0 <= mark <= position <= limit <= capacity
 * 
 * 4.ֱ�ӻ��������ֱ�ӻ�����
 * ��ֱ�ӻ�����:ͨ��allocate()�������仺����,��������������JVM���ڴ���
 * ֱ�ӻ�����:ͨ��allocateDirect()��������ֱ�ӻ�����,�������������������ڴ���.�������Ч��
 */
public class TestBuffer {

	@Test
	public void test1(){
		String str = "abcde";	
		//1.����һ��ָ����С�Ļ�����
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		System.out.println("--------allocate()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//2.����put()�����������ݵ�������
		bbf.put(str.getBytes());
		System.out.println("--------put()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//3.����flip()�����л�����ģʽ
		bbf.flip();
		System.out.println("--------flip()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//4.����get()��ȡ�������е�����
		byte[] b = new byte[bbf.limit()];
		bbf.get(b);
		System.out.println("--------get()-----------");
		System.out.println(new String(b, 0, bbf.limit()));
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//5.rewind()���ظ���
		bbf.rewind();
		System.out.println("--------rewind()-----------");
		System.out.println(bbf.capacity());
		System.out.println(bbf.limit());
		System.out.println(bbf.position());
		//6.clear()��ջ�����,���ǻ������ڵ����ݲ�û�б����,ֻ�Ǵ���"������״̬"
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
		//mark ���
		bbf.mark();
		bbf.get(b, 2, 2);
		System.out.println(new String(b, 2, 2));
		System.out.println(bbf.position());
		//�ָ���mark��λ��
		bbf.reset();
		System.out.println(bbf.position());
		//�жϻ��������Ƿ���ʣ������
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
