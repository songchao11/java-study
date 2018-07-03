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

/*
 * 1.使用NIO完成网络通信的三个核心
 * ①通道(Channel):负责连接
 * ②缓冲区(Buffer):负责数据的存取
 * ③选择器(Selector):是SelectableChannel的多路复用器.用于监控SelectableChannel的IO状况
 */
public class TestBlockingNIO {

	/*
	 * 客户端
	 */
	@Test
	public void client() throws IOException{
		//1.获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		
		FileChannel inChannel = FileChannel.open(Paths.get("2.txt"), StandardOpenOption.READ);
		//2.分配指定大小的缓冲区
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		
		//3.读取本地文件,并发送到服务端
		while(inChannel.read(bbf) != -1){
			bbf.flip();//切换到读模式
			sChannel.write(bbf);
			bbf.clear();
		}
		sChannel.close();
		inChannel.close();
	}
	
	/*
	 * 服务端
	 */
	@Test
	public void server() throws IOException{
		//1.获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		
		FileChannel outChannel = FileChannel.open(Paths.get("3.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
		//2.绑定连接
		ssChannel.bind(new InetSocketAddress(9898));
		
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
		//6.关闭通道
		ssChannel.close();
		outChannel.close();
		sChannel.close();
		
	}
	
}
