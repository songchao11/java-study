package com.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class TestBlockingNIO2 {
	
	@Test
	public void client() throws IOException{
		//1.��ȡͨ��
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9897));
		
		FileChannel inChannel = FileChannel.open(Paths.get("2.txt"), StandardOpenOption.READ);
		//2.����ָ����С�Ļ�����
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		
		//3.��ȡ�����ļ�,�����͵������
		while(inChannel.read(bbf) != -1){
			bbf.flip();//�л�����ģʽ
			sChannel.write(bbf);
			bbf.clear();
		}
		sChannel.shutdownOutput();
		//4.���շ���˵ķ���
		int len = 0;
		while((len = sChannel.read(bbf)) != -1){
			bbf.flip();
			System.out.println(new String(bbf.array(), 0, len));
		}
		
		sChannel.close();
		inChannel.close();
		
	}
	
	@Test
	public void server() throws IOException{
		//1.��ȡͨ��
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		
		FileChannel outChannel = FileChannel.open(Paths.get("3.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
		//2.������
		ssChannel.bind(new InetSocketAddress(9897));
		
		//3.��ȡ�ͻ������ӵ�ͨ��
		SocketChannel sChannel = ssChannel.accept();
		
		//4.����һ��ָ����С�Ļ�����
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		
		//5.���տͻ��˵�����,�����浽����
		while(sChannel.read(bbf) != -1){
			bbf.flip();
			outChannel.write(bbf);
			bbf.clear();
		}
		//6.���ͷ������ͻ���
		bbf.put("����˽������ݳɹ�".getBytes());
		bbf.flip();
		sChannel.write(bbf);
		//7.�ر�ͨ��
		ssChannel.close();
		outChannel.close();
		sChannel.close();
	}

}
