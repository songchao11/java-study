package com.study.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/*
 * 1.通道(Channel):用于源节点与目标节点的连接.在Java NIO中负责缓冲区中数据的传输.
 * Channel本身不存储数据,因此需要配合缓冲区进行传输
 * 2.通道的主要实现类
 *  java.nio.channels.Channel接口:
 *  	|--FileChannel
 *  	|--SocketChannel
 *  	|--ServerSocketChannel
 *  	|--DatagramChannel
 * 3.获取通道
 * ①Java针对支持通道的类提供了getChannel()方法
 * 	本地IO:
 * 		FileInputStream  FileOutputStream
 * 		RandomAccessFile
 * 	网络IO:
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 * ②在jdk1.7中针对各个通道提供了静态方法open()
 * ③在jdk1.7中的Files工具类的newByteChannel()
 * 
 * 4.通道之间的数据传输
 * transferFrom()
 * transferTo()
 * 
 * 5.分散(Scatter)与聚集(Gather)
 * 分散读取(Scattering Reads):将通道中的数据分散到多个缓冲区内
 * 聚集写入(Gathering Writes):将多个缓冲区内的数据聚集到通道中
 */
public class TestChannel {

	/*
	 * 利用通道完成文件的复制(非直接缓冲区)
	 */
	@Test
	public void test1(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		//①获取通道
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			fis = new FileInputStream("hello.txt");
			fos = new FileOutputStream("channel.txt");
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			//②分配指定大小的缓冲区
			ByteBuffer bbf = ByteBuffer.allocate(1024);
			//③将通道中的数据存入缓冲区中
			while(inChannel.read(bbf) != -1){
				bbf.flip();//开启读数据模式
				//④将缓冲区中的数据写入通道
				outChannel.write(bbf);
				bbf.clear();//清空缓冲区
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(outChannel != null){
				try {
					outChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(inChannel != null){
				try {
					inChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * 使用直接缓冲区完成文件的复制(内存映射文件)
	 */
	@Test
	public void test2() throws IOException{
		FileChannel inChannel = FileChannel.open(Paths.get("hello.txt"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("channel1.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		//内存映射文件
		MappedByteBuffer inMappedBuf = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMappedBuf = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		
		//直接对缓冲区进行数据的读写操作
		byte[] b = new byte[inMappedBuf.limit()];
		inMappedBuf.get(b);
		outMappedBuf.put(b);
		
		inChannel.close();
		outChannel.close();
	}
	
	/*
	 * 通道之间的数据传输(直接缓冲区)
	 */
	@Test
	public void test3() throws IOException{
		FileChannel inChannel = FileChannel.open(Paths.get("hello.txt"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("haha.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
		
		inChannel.transferTo(0, inChannel.size(), outChannel);
		inChannel.close();
		outChannel.close();
	}
	
	/*
	 * 分散读取与聚集写入
	 */
	@Test
	public void test4() throws Exception{
		RandomAccessFile raf1 = new RandomAccessFile("ok.txt", "rw");
		//1.获取通道
		FileChannel channel1 = raf1.getChannel();
		//2.分配指定大小的缓冲区
		ByteBuffer bbf1 = ByteBuffer.allocate(100);
		ByteBuffer bbf2 = ByteBuffer.allocate(1024);
		//3.分散读取
		ByteBuffer[] bbfs = {bbf1, bbf2};
		channel1.read(bbfs);
		for(ByteBuffer bf : bbfs){
			bf.flip();
		}
		System.out.println(new String(bbfs[0].array(), 0, bbfs[0].limit()));
		System.out.println("-----------------");
		System.out.println(new String(bbfs[1].array(), 0, bbfs[1].limit()));
		
		//4.聚集写入
		RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
		FileChannel channel2 = raf2.getChannel();
		channel2.write(bbfs);
		channel1.close();
		channel2.close();
	}
	
	@Test
	public void test5(){
		Map<String, Charset> map = Charset.availableCharsets();
		Set<Entry<String, Charset>> set = map.entrySet();
		for(Entry<String, Charset> entry : set){
			System.out.println(entry.getKey()+"=="+entry.getValue());
		}
	}
	
	@Test
	public void test6() throws IOException{
		Charset cs1 = Charset.forName("GBK");
		//获取编码器
		CharsetEncoder ce = cs1.newEncoder();
		//获取解码器
		CharsetDecoder cd = cs1.newDecoder();
		
		CharBuffer cBuf = CharBuffer.allocate(1024);
		cBuf.put("获取解码器");
		cBuf.flip();
		//编码
		ByteBuffer bBuf = ce.encode(cBuf);
		for(int i = 0;i < 12;i++){
			System.out.println(bBuf.get());
		}
//		bBuf.flip();
//		CharBuffer cBuf2 = cd.decode(bBuf);
//		System.out.println(cBuf2.toString());
		
	}
	
}
