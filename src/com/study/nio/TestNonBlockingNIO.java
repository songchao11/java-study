package com.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/*
 * 1.使用NIO完成网络通信的三个核心
 * ①通道(Channel):负责连接
 * ②缓冲区(Buffer):负责数据的存取
 * ③选择器(Selector):是SelectableChannel的多路复用器.用于监控SelectableChannel的IO状况
 */
public class TestNonBlockingNIO {

	@Test
	public void client() throws IOException{
		//1.获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9897));
		//2.切换非阻塞模式
		sChannel.configureBlocking(false);	
		//3.分配指定大小的缓冲区
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		//4.发送数据给服务端
		bbf.put(new Date().toString().getBytes());
		bbf.flip();
		sChannel.write(bbf);
		bbf.clear();
		//5.关闭通道
		sChannel.close();
	}
	
	/*
	 * 选择器(Selector)是可选择通道的多路复用器,可用作可以进入非阻塞模式的特殊类型的通道.
	 * 它可以检查一个或多个NIO通道,并确定哪个通道准备好了可以进行通信,即读取或写入.
	 * 用于使用单个线程处理多个通道
	 */
	@Test
	public void server() throws IOException{
		//1.获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		//2.切换非阻塞模式
		ssChannel.configureBlocking(false);
		//3.绑定连接
		ssChannel.bind(new InetSocketAddress(9897));
		//4.获取选择器
		Selector selector = Selector.open();
		//5.将通道注册到选择器上,并指定"监听接收事件"
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		//6.轮询式的获取选择器上已经准备就绪的事件
		while(selector.select() > 0){
			//7.获取当前选择器中所有注册的"选择键(已就绪的监听事件)"
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			
			while(it.hasNext()){
				//8.获取准备就绪的事件
				SelectionKey sk = it.next(); 
				//9.判断具体是什么事件准备就绪
				if(sk.isAcceptable()){
					//10.若接收就绪,获取客户端连接
					SocketChannel sChannel = ssChannel.accept();
					//11.切换非阻塞模式
					sChannel.configureBlocking(false);
					//12.将通道注册到选择器上
					sChannel.register(selector, SelectionKey.OP_READ);
				}else if(sk.isReadable()){
					//13.获取当前选择器上读就绪状态的通道
					SocketChannel sChannel = (SocketChannel)sk.channel();
					//14.读取数据
					ByteBuffer buf = ByteBuffer.allocate(1024);
					
					int len = 0;
					while((len = sChannel.read(buf)) > 0){
						buf.flip();
						System.out.println(new String(buf.array(), 0, len));
						buf.clear();
					}
				}
				//15.取消选择键SelectionKey
				it.remove();
			}
			
		}
		
		
	}
	
}
