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
		//1.获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9897));
		
		FileChannel inChannel = FileChannel.open(Paths.get("2.txt"), StandardOpenOption.READ);
		//2.分配指定大小的缓冲区
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		
		//3.读取本地文件,并发送到服务端
		while(inChannel.read(bbf) != -1){
			bbf.flip();//切换到读模式
			sChannel.write(bbf);
			bbf.clear();
		}
		sChannel.shutdownOutput();
		//4.接收服务端的反馈
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
		//1.获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		
		FileChannel outChannel = FileChannel.open(Paths.get("3.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
		//2.绑定连接
		ssChannel.bind(new InetSocketAddress(9897));
		
		//3.获取客户端连接的通道
		SocketChannel sChannel = ssChannel.accept();
		
		//4.分配一个指定大小的缓冲区
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		
		//5.接收客户端的数据,并保存到本地
		while(sChannel.read(bbf) != -1){
			bbf.flip();
			outChannel.write(bbf);
			bbf.clear();
		}
		//6.发送反馈给客户端
		bbf.put("服务端接收数据成功".getBytes());
		bbf.flip();
		sChannel.write(bbf);
		//7.关闭通道
		ssChannel.close();
		outChannel.close();
		sChannel.close();
	}

}
